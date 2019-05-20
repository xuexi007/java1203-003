package com.offcn.controller;

import com.offcn.dao.PersonDao;
import com.offcn.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @Autowired
    private PersonDao personDao;
    @RequestMapping("/person/{id}")
    public Person findPerson(@PathVariable("id")Long id){
      return   personDao.findPerson(id);

    }
}
