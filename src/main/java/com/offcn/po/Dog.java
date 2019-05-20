package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//***************************************
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    //名字
    private String name;

    //人员id
    private Long personId;

    //新增年龄字段
    private Integer age;
}
