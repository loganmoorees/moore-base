package com.moore.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestLambda {

    /**
     * 原来的匿名内部类
     */
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
    }

    /**
     * Java8 Lambda 表达式
     */
    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 3500.00),
            new Employee("李四", 28, 4500.00),
            new Employee("王五", 26, 3900.00),
            new Employee("赵六", 27, 5000.00),
            new Employee("孙七", 32, 6510.00),
            new Employee("周八", 18, 2000.00)
    );

    @Test
    public void test3() {
        List<Employee> list = filterEmployeesByAge(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 拿到年纪大于25的数据
     *
     * @param list
     *
     * @return
     */
    public List<Employee> filterEmployeesByAge(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= 25) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    /**
     * 拿到员工工资大于5000的人
     *
     * @param list
     *
     * @return
     */
    public List<Employee> filterEmployeesBySalary(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() >= 5000) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }


    /**
     * 优化方式一： 策略设计模式
     */
    @Test
    public void test4() {
        List<Employee> employeeList = filterEmployee(this.employees, new FilterEmployeesByAge());
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /**
     * 采用设计模式：但是每个字段过滤就得建立一个类
     *
     * @param list
     * @param myPredicate
     *
     * @return
     */
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if (myPredicate.test(employee)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    /**
     * 采用匿名内部类方式
     */
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 5000;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    /**
     * 采用Lambda表达式
     */
    @Test
    public void test6() {
        List<Employee> employees = filterEmployee(this.employees, (e) -> e.getSalary() < 5000);
        employees.forEach(System.out::println);
    }

    /**
     * 采用Stream
     */
    @Test
    public void streamTest() {
        employees.stream()
                .filter((e) -> e.getSalary() >= 5000)
                .forEach(System.out::println);
    }
}