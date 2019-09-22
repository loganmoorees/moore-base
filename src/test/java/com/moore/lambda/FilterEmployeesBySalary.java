package com.moore.lambda;

/**
 * 根据工资进行过滤
 */
public class FilterEmployeesBySalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
