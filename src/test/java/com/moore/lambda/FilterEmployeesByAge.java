package com.moore.lambda;

public class FilterEmployeesByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 25;
    }
}
