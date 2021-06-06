package com.naruto.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：mengzhiayuan
 * @description：
 * 创建线程的方法4，使用线程池
 * @date ：2021/2/3 12:16
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class ThreadPoll {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(10);
        service.submit(new NumberThread());
//        service.submit();
        service.shutdown();
    }
}

