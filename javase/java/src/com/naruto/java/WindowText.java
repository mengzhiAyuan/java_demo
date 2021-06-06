package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：多窗口买票，
 * @date ：2021/2/1 11:18
 */
class Window extends Thread{
    private  static  int ticket=100;
    private  static  Object obj=new Object();
    public Window(){}
    public Window(String s) {
        super(s);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {//锁必须唯一
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println("当前票为" + getName() + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowText {
    public static void main(String[] args) {
        Window f1=new Window("线程一");
        Window f2=new Window("线程二");
        Window f3=new Window("线程三");
        f1.start();
        f2.start();
        f3.start();
    }
}
