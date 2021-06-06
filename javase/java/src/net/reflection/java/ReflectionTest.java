package net.reflection.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 *  反射
 * @date ：2021/3/7 15:49
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        test1();
        test2();
    }
//    获取Class实例的方式
    public static void test1() throws ClassNotFoundException {
//        方式一：调用运行时类的属性：.Class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
//        方式二：通过运行时类的对象，调用getClass
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
//        方式三：调用Class静态方法：forName(String classPAth)
        Class<?> clazz3 = Class.forName("net.reflection.java.Person");
        System.out.println(clazz3);
        Class<?> clazz4 = Class.forName("java.lang.String");
        System.out.println(clazz4);
        System.out.println(clazz1==clazz2);
        System.out.println(clazz2==clazz3);
        System.out.println(clazz3==clazz4);
//        方式四：使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("net.reflection.java.Person");
        System.out.println(loadClass);
    }
    //用来读取配置文件，使用ClassLoad加载配置文件
    public  static void test2() throws IOException {
        //方式一，此时的文件默认在当前的module下
        Properties pro=new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\javase\\java\\jdbc1.properties");
        pro.load(fileInputStream);
        String user = pro.getProperty("user");
        String otherName = pro.getProperty("otherName");
        System.out.println("user"+user+"otherName"+otherName);
        System.out.println("*****************************");
        //方式二，文件在src下
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("D:\\javase\\java\\src\\jdbc1.properties");
        pro.load(is);
        user = pro.getProperty("user");
        otherName = pro.getProperty("otherName");
        System.out.println("user"+user+"otherName"+otherName);
        System.out.println("*****************************");
    }
}
