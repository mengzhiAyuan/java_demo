package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：实现三个窗口买票，Runnable接口实现
 * @date ：2021/2/1 11:52
 */
class RunTest implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println("当前票为" + Thread.currentThread().getName() + "**$" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class RunnableTest{
    public static void main(String[] args) {
        RunTest f=new RunTest();
        Thread f1=new Thread(f);
        Thread f2=new Thread(f);
        Thread f3=new Thread(f);
        f1.setName("窗口1");
        f2.setName("窗口2");
        f3.setName("窗口3");
        f1.start();
        f2.start();
        f3.start();
    }
}
