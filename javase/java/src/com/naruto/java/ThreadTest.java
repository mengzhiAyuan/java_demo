package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：多线程创建，继承Thread子类
 * @date ：2021/1/31 19:32
 */
class MyThreadTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 99; i++) {
            if(i%2==0){
                System.out.println(MyThreadTest.currentThread().getName()+":"+i);
            }
            if(i%6==0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThreadTest t1=new MyThreadTest();
        t1.setName("线程1");
        t1.start();
         // MyThreadTest t2=new MyThreadTest();
        // t2.start();
        //创建Thread类匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                int i=1000;
                for(;i>0;i--){
                    System.out.println(i+"$$$$$$");
                }
            }
        }.start();
        //给主线程命名
        Thread.currentThread().setName("@主线程");
        for (int i = 0; i < 99; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+i+"********");
            }
        }
    }
}
