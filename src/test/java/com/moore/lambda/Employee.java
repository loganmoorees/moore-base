package com.moore.lambda;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;

    private int age;

    private double salary;
}
