package com.moore.lambda.entity;

import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;

    private int age;

    private double salary;
}
