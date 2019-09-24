package com.moore.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author moore
 * @date 2019-09-24 19:16
 * @desc
 */
public class TestMethodRefe {

    /**
     * 方法引用：
     * 对象::方法实例名
     * Lambda体中调用方法的参数返回类型和参数列表必须与被调用的方法的参数和返回类型必须保持一致
     */
    @Test
    public void test1() {
        PrintStream printStream = System.out;
        // 打印
        Consumer<String> consumer = e -> System.out.println(e);

        // 可以写作
        Consumer<String> consumers = e -> printStream.println(e);

        // 又可以写作
        Consumer<String> consum = printStream::println;
        consum.accept("1");
    }

    /**
     * 类::静态方法名
     * comparator
     */
    @Test
    public void test2() {
        // 比较两个参数大小
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        // 可以写作
        Comparator<Integer> compara = Integer::compare;
    }

    /**
     * 类::实例方法名
     */
    @Test
    public void test3() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPred = String::equals;
    }

    /**
     * 构造器引用
     * 类::对象
     */
    @Test
    public void test4() {
        Supplier<Employee> supplier = () -> new Employee();
        Supplier<Employee> employee = Employee::new;
    }

    /**
     * 数组引用
     * 类似于构造器引用
     */
    @Test
    public void test5() {
        Function<Integer, String[]> function = x -> new String[x];
        Function<Integer, String[]> fun = String[]::new;
    }
}
