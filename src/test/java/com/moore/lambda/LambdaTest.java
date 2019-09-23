package com.moore.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {

    /**
     * 无参Lambda
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello !");
            }
        };

        runnable.run();
        System.out.println("----------------------------");
        Runnable run = () -> System.out.println("Hello World!");
        run.run();
    }

    /**
     * 一个参数无返回值（若只有一个参数，小括号可以省略）
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("Moore");
        System.out.println("-------------------");
        Consumer<String> consumers = s -> System.out.println(s);
        consumer.accept("Moore");
    }

    /**
     * 有两个以上的参数,有返回值,并且Lambda体中有多条语句:
     * 多条语句必须加上大括号
     */
    @Test
    public void Test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("This My Test：");
            return Integer.compare(x, y);
        };
    }

    /**
     * Lambda中只有一条语句, return和大括号都可以省略
     */
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 函数式接口
     */
    @Test
    public void test5() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
        Integer number = operation(100, (x) -> x + 200);
        System.out.println(number);
    }


    public Integer operation(Integer num, MyInterface mi) {
        return mi.getValue(num);
    }
}
