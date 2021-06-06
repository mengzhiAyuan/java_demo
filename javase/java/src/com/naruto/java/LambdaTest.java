package com.naruto.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：mengzhiayuan
 * @description：
 *  java8新特性
 *  lambda表达式的使用
 * @date ：2021/3/11 10:49
 */
public class LambdaTest {
    public static void main(String[] args) {
        test3();
    }
    public static void test1(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

// 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

// 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

// 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }
    public static void test2(){
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

// 1.2使用 lambda expression
        new Thread(() -> System.out.println("Hello world !")).start();

// 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

// 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");

// 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }
    //利用lambda表达式进行排序
    public static void test3(){
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        for(String e:players){
            System.out.print(e);
        }
        System.out.println("********************************");
// 1.1 使用匿名内部类根据 name 排序 players
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return (s.compareTo(t1));
//            }
//        });
//        使用lambda expression 排序 players
        Comparator<String> sortByName=(s1,s2)->(s1.compareTo(s2));//类型推断
        Arrays.sort(players,sortByName);
        //另式
        Arrays.sort(players,(String s1,String s2)->(s1.compareTo(s2)));
        System.out.println(Arrays.toString(players));
    }
}
