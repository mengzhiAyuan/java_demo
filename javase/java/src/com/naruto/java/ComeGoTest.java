package com.naruto.java;

/**
 * @author ：mengzhiayuan
 * @description：
 * 生产者-消费者模式是一个十分经典的多线程并发协作的模式，弄懂生产者-消费者问题能够让我们对并发编程的理解加深。
 * 所谓生产者-消费者问题，实际上主要是包含了两类线程，一种是生产者线程用于生产数据，另一种是消费者线程用于消费数据，
 * 为了解耦生产者和消费者的关系，通常会有一个共享的数据区域，就像是一个仓库，生产者生产数据之后直接放置在共享数据区中，
 * 并不需要关心消费者的行为；而消费者只需要从共享数据区中去获取数据，就不再需要关心生产者的行为。
 * 但是，这个共享数据区域中应该具备这样的线程间并发协作的功能：
 * 如果共享数据区已满的话，阻塞生产者继续生产数据放置入内；
 * 如果共享数据区为空的话，阻塞消费者继续消费数据；
 * @date ：2021/2/3 13:56
 */
public class ComeGoTest {
    public static void main(String[] args) {
        Clerk p=new Clerk();
        Producer producer = new Producer(p);
        Consumer consumer = new Consumer(p);
        producer.setName("生产者");
        consumer.setName("消费者");
        producer.start();
        consumer.start();
    }
}
class Clerk{
    private int ProduceCount=0;
    public synchronized void produce() {
        if(ProduceCount<20){
            ProduceCount++;
            notify();
            System.out.println(Thread.currentThread().getName()+"开始进货：第"+ProduceCount+"件产品");
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {//同步监视器为当前类对象
        if(ProduceCount>0){
            ProduceCount--;
            notify();
            System.out.println(Thread.currentThread().getName()+"开始消费：第"+ProduceCount+"件产品");
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        while(true){
            System.out.println(getName()+"开始生产，柜员进货");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.produce();
        }
    }
}
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        while(true){
            System.out.println(getName()+"消费者买产品");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}
