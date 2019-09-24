package com.moore.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    /**
     * 消费型接口
     */
    @Test
    public void test6() {
        happy(1000, (e) -> System.out.println("每次消费" + e + "元"));
    }

    /**
     * 消费型接口
     *
     * @param money
     * @param consumer
     */
    private void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * 供给型接口
     */
    @Test
    public void test7() {
        List<Integer> list = getNumberList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);
    }

    /**
     * 产生指定整数放入集合
     *
     * @param num
     * @param supplier
     * @return
     */
    private List<Integer> getNumberList(int num, Supplier<Integer> supplier) {
        List<Integer> list = IntStream.range(0, num).mapToObj(i -> supplier.get()).collect(Collectors.toList());
        return list;
    }

    /**
     * 函数型接口
     */
    @Test
    public void test8() {
        String str = strHandler("学习Lambda    ", s -> s.substring(0, 2));
        System.out.println(str);
    }

    /**
     * 函数型接口：给定一个字符串，返回一个字符串
     *
     * @param str
     * @param function
     * @return
     */
    private String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    /**
     * 断言型接口
     */
    @Test
    public void test9() {
        List<String> list = Arrays.asList("Hello", "Moore", "Student", "Teacher");
        List<String> strings = getString(list, (s) -> s.length() > 6);
        System.out.println(strings);
    }

    /**
     * 断言型接口，将满足条件的字符串放入集合中
     *
     * @param list
     * @param predicate
     * @return
     */
    private List<String> getString(List<String> list, Predicate<String> predicate) {
        List<String> strings = list.stream()
                .filter(predicate::test)
                .collect(Collectors.toList());
        return strings;
    }
}
