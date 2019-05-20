package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "personId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Dog> dogs;
}
