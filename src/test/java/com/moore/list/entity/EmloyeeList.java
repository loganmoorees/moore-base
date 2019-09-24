package com.moore.list.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author moore
 * @date 2019-09-24 16:24
 * @desc
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class EmloyeeList {

    private String name;

    private int age;

    private double salary;

    List<EmloyeeList> emloyeeLists;
}
