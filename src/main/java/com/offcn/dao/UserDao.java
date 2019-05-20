package com.offcn.dao;

import com.offcn.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    //自动化推导查询
    public List<User> findByName(String name);

    //排序
    public List<User> findByName(String name, Sort sort);

    //分页方式1 100W
    /*public Page<User> findByNameLike(String name, Pageable pageable);*/
    //分页方式2
    public Slice<User> findByNameLike(String name, Pageable pageable);


    //自动生成排序
    public List<User> findByNameOrderByIdDesc(String name);
    //获取前N条记录
    public List<User> findFirst2ByNameOrderByIdDesc(String name);

    public User findByNameAndAge(String name,Integer age);

    @Query("select u from User u where u.name=:name")
    public List<User> searchNnnn(@Param("name") String name);


    @Query("select u from User u where u.name=?1 and u.age=?2")
    public User searchNameAndAge(@Param("name") String name,@Param("age") Integer age);

    @Modifying
    @Transactional(readOnly = false)
    @Query("update User u set u.name=?2 where u.id=?1")
    public int updateName(@Param("id") Long id,@Param("name") String name);

    @Modifying
    @Transactional(readOnly = false)
    @Query("delete from User u where u.id=?1")
    public int delete(@Param("id")Long id);

}
