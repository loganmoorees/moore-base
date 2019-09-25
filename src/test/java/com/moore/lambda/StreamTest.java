package com.moore.lambda;

import com.moore.lambda.entity.Employee;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * @author moore
 * @date 2019-09-25 18:49
 * @desc Stream 流
 * 1. Stream自己不会存储元素
 * 2. Stream不会改变源对象, 相反, 他们会返回一个持有结果的新Stream
 * 3. Stream操作是延迟执行的, 意味着他们会等到需要结果时候才会执行
 */
public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 23, 3500.00),
            new Employee("李四", 25, 4500.00),
            new Employee("王五", 23, 3900.00),
            new Employee("赵六", 25, 5000.00),
            new Employee("孙七", 32, 6510.00),
            new Employee("周八", 25, 2000.00),
            new Employee("周八", 25, 2000.00),
            new Employee("周八", 25, 2000.00));

    /**
     * filter 过滤
     */
    @Test
    public void test1() {
        employees.stream()
                .filter(e -> e.getAge() > 25)
                .forEach(out::println);
    }

    /**
     * 截取: limit
     */
    @Test
    public void test2() {
        employees.stream()
                .filter(e -> e.getSalary() > 4500)
                .limit(1)
                .forEach(out::println);
    }

    /**
     * 跳过元素 skip
     */
    @Test
    public void test3() {
        employees.stream()
                .filter(e -> e.getSalary() > 4500)
                .skip(1)
                .forEach(out::println);
    }

    /**
     * 去重 distinct
     */
    @Test
    public void test4() {
        employees.stream()
                .filter(e -> e.getAge() == 25)
                .distinct()
                .forEach(out::println);
    }

    /**
     * 映射 map, 取出元素映射成一个新的元素
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(out::println);

        out.println("--------------");
        employees.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(out::print);
        out.println("--------------");
        Optional<Double> optional = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        out.println("最小工资为:  " + optional.get());
        long num = employees.stream()
                .count();
        out.println("总个数为： " + num);
    }

    /**
     * 归约（归并）
     * <p>
     * map reduce 提取归并，比如Hadoop的map reduce模式或者Google, 应用非常广泛
     */
    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        out.println(sum);

        out.println("*****************");
        Optional<Double> optional = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        out.println("最小工资为:  " + optional.get());
    }

    /**
     * 搜集
     */
    @Test
    public void test7() {
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(out::println);


        // 拿到平均值
        out.println("平均值是：" + employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary)));

        // 将名字连成一个字符串中间用逗号分隔
        out.println(employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",")));
    }

    // 分组
    @Test
    public void test8() {
        // 默认根据工资从大小排序, 返回Map, 工资为Key, Value是集合
        Map<Double, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
        out.println(map.get(2000.0));

        out.println("-------------多级分组");

        // 多级分组里面其实就是Map套Map
        Map<Double, Map<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy(e -> {
                    if (((Employee) e).getAge() < 30) {
                        return "青年";
                    } else if (((Employee) e).getAge() < 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        out.println(collect);
        out.println(collect.get(2000.0).get("青年"));
    }
}
