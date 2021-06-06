package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：单例模式懒汉式线程安全的解决
 * @date ：2021/2/2 16:29
 */
public class BankTest {
    public static void main(String[] args) {

    }
}
class bank{
    private bank(){}
    private static bank obj=null;
    public static synchronized bank getObj(){//此时锁为bank.class
        if(obj==null){
            obj=new bank();
        }
        return obj;
    }

}

