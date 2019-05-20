package com.offcn.dao;

import com.offcn.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonDao extends JpaRepository<Person,Long> {

    @Query("select p from Person p join p.dogs where p.id=?1")
   public Person findPerson(@Param("id") Long id);
}
