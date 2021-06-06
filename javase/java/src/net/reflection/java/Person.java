package net.reflection.java;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * 一个javabean
 * @date ：2021/3/7 15:52
 */
public class Person {
    private  String name;
    private  int id;

    public Person() {
    }
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
