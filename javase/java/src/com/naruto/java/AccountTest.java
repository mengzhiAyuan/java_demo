package com.naruto.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：mengzhiayuan
 * @description：
 * 两个账户分别向同一个账户存钱（3000），存三次每次打印余额
 * @date ：2021/2/2 18:32
 */
public class AccountTest {
    public static void main(String[] args) {
        Account bank1=new Account();
        Customer t1=new Customer("罗威",bank1);
        Customer t2=new Customer("汪洋好",bank1);
        t1.start();
        t2.start();
    }
}
class Customer extends Thread{
    private Account name;
    public Customer(String s,Account name){
        super(s);
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            name.setNum(100);
        }
    }
}
class Account{
    private double num;
    Account(){
        this.num=0;
    }
    private ReentrantLock lock=new ReentrantLock();//一定要注意锁的唯一性
    public void setNum(double x) {
        lock.lock();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.num+=x;
        System.out.println(Thread.currentThread().getName()+"余额为"+this.num);
        lock.unlock();
    }

}
