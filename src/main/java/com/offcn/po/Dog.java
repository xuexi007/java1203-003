package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    //服务器修改，新增地址字段

    private String address;


    //小王，新增方法
    public void xiaowang001(){
        for (int i = 0; i < 10; i++) {
            System.out.println("i:"+i);
        }
    }
}
