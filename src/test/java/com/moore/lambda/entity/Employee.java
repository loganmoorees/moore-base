package com.moore.lambda.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Cloneable, Serializable {

    private static final long serialVersionUID = 1602530844797554896L;

    private String name;

    private int age;

    private double salary;

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
