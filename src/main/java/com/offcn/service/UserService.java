package com.offcn.service;

import com.offcn.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    public void save(User user);

    public void update(User user);

    public void  delete(Long id);

    public List<User> getAll();
    public List<User> findByName(String name);
    public List<User> findByName(String name, Sort sort);

    public User findOneUser(Long id);

    public User findByNameAndAge(String name,Integer age);

    public List<User> searchNnnn(String name);

    public User searchNameAndAge(String name,Integer age);


    public int updateName(Long id,String name);

    public int deleteId(Long id);


    /*public Page<User> findByNameLike(String name, Pageable pageable);*/
    public Slice<User> findByNameLike(String name, Pageable pageable);

    public List<User> findByNameOrderByIdDesc(String name);

    public List<User> findFirst2ByNameOrderByIdDesc(String name);

}
