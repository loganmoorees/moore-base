package com.moore.base;

import com.moore.lambda.entity.Employee;
import com.moore.utils.SerializeUtil;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 对象创建方式
 *
 * @author moore
 * @date 2020-01-02
 */
public class NewObject {

    /**
     * 方式1：new 关键字创建对象
     */
    @Test
    public void test1() {
        Employee employee = new Employee();
        employee.setAge(1);
        employee.setName("1");
        employee.setSalary(1);
        System.out.println(employee);
    }

    /**
     * 方式二：Class类的newInstance方法
     */
    @Test
    public void test2() {
        Class<Employee> c = Employee.class;
        try {
            Employee employee = c.newInstance();
            employee.setAge(2);
            employee.setName("2");
            employee.setSalary(2);
            System.out.println(employee);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式三：Constructor类的newInstance方法
     */
    @Test
    public void test3() {
        try {
            Employee employee = (Employee) Employee.class.getConstructor().newInstance();
            employee.setAge(3);
            employee.setName("3");
            employee.setSalary(3);
            System.out.println(employee);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式四：重写Object类的clone方法
     */
    @Test
    public void test4() {
        Employee employee = new Employee();
        try {
            Employee clone = (Employee) employee.clone();
            clone.setAge(4);
            clone.setName("4");
            clone.setSalary(4);
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式五： 反序列化操作
     */
    @Test
    public void test5() {
        com.moore.entity.Employee employee = SerializeUtil.deserialize();
        employee.setName("Hello");
        System.out.println(employee);
    }


    /**
     * 浅拷贝测试
     */
    @Test
    public void test6() {
        Employee employee = new Employee();
        System.out.println(employee.toString());
        Employee copy = employee;
        System.out.println();
        System.out.println(copy.toString());
    }

    public void func(int a) {
        a = 20;
        System.out.println(20);
    }

    /**
     * 值传递与引用传递测试
     *     Java只有值传递，没有引用传递
     */
    @Test
    public void test7() {
        int a = 10;
        func(a);
        System.out.println(a);
    }
}
