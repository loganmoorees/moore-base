package com.moore.list;

import com.moore.lambda.entity.Employee;
import com.moore.list.entity.EmloyeeList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moore
 * @date 2019-09-24 11:47
 * @desc 给定两个集合，取出两个集合中的对象相同字段的数据
 */
public class ListTest {

    /**
     * 构建集合
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 3500.00),
            new Employee("李四", 25, 4500.00),
            new Employee("王五", 23, 3900.00),
            new Employee("赵六", 25, 5000.00),
            new Employee("孙七", 32, 6510.00),
            new Employee("周八", 25, 2000.00)
    );

    EmloyeeList emloyeeList = new EmloyeeList("25岁", 25, 3000.00, null);
    EmloyeeList emloyees = new EmloyeeList("23岁", 23, 2500.00, null);

    @Test
    public void test() {
        int age = emloyeeList.getAge();
        List<Employee> collect = employees.stream()
                .filter(d -> age == d.getAge())
                .collect(Collectors.toList());
    }

}
