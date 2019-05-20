package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @CacheEvict(value ={"getAll","findByName","findOneUser"} ,allEntries = true)
    public void save(User user) {
       userDao.save(user);
    }

    @Override
    @CacheEvict(value ={"getAll","findByName","findOneUser"} ,allEntries = true)
    public void update(User user) {
      userDao.saveAndFlush(user);
    }

    @Override
    @CacheEvict(value ={"getAll","findByName","findOneUser"} ,allEntries = true)
    public void delete(Long id) {
     userDao.deleteById(id);
    }

    @Override
    @Cacheable(value ="getAll",key="'Users'" )//判断redis缓存是否存在要读取的缓存内容，如果有直接返回，如果没有再继续读取数据库，读取完成，把结果存入到缓存，在返回
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    @Cacheable(value ="findByName",key="'User'+#name" )
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

  /*  @Override
    public Page<User> findByNameLike(String name, Pageable pageable) {
        return userDao.findByNameLike("%"+name+"%", pageable);
    }*/

    @Override
    public List<User> findByName(String name, Sort sort) {
        return userDao.findByName(name,sort);
    }

    @Override
    public User findByNameAndAge(String name, Integer age) {
        return userDao.findByNameAndAge(name,age);
    }

    @Override
    @Cacheable(value ="findOneUser",key="'User'+#id" )
    public User findOneUser(Long id) {

        return userDao.findById(id).get();
    }

    @Override
    public List<User> searchNnnn(String name) {
        return userDao.searchNnnn(name);
    }

    @Override
    public User searchNameAndAge(String name, Integer age) {
        return userDao.searchNameAndAge(name, age);
    }

    @Override
    public int updateName(Long id, String name) {
        return userDao.updateName(id, name);
    }

    @Override
    public int deleteId(Long id) {
        return userDao.delete(id);
    }

    @Override
    public Slice<User> findByNameLike(String name, Pageable pageable) {
        return userDao.findByNameLike("%"+name+"%", pageable);
    }

    @Override
    public List<User> findByNameOrderByIdDesc(String name) {
        return userDao.findByNameOrderByIdDesc(name);
    }

    @Override
    public List<User> findFirst2ByNameOrderByIdDesc(String name) {
        return userDao.findFirst2ByNameOrderByIdDesc(name);
    }
}
