package com.moore.utils;

import com.moore.entity.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化与反序列化操作
 *
 * @author moore
 * @date 2020-01-02
 */
public class SerializeUtil {

    static String filePath = "d:/SerializeUtil.txt";

    /**
     * 序列化到磁盘文件
     */
    public static void serialize() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(filePath));

            Employee employee = new Employee();
            employee.setAge(22);
            employee.setName("Moore");
            employee.setSalary(1000);
            out.writeObject(employee);
            out.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    /**
     * 从文件反序列化到对象
     */
    public static Employee deserialize() {
        Employee employee = null;
        try {
            // 创建一个对象输入流，从文件读取对象
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    filePath));
            employee = (Employee) (in.readObject());
            in.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
        return employee;
    }
}
