package com.luoleo.program2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    private final int MAX_NUM=10;
    private final LinkedList<Object> list=new LinkedList<>();
    private final Lock lock=new ReentrantLock();
    private final Condition full=lock.newCondition();
    private final Condition empty=lock.newCondition();


    public void produce(){
        lock.lock();
        while (list.size() +1> MAX_NUM) {
            try {
                System.out.println("生产者"+Thread.currentThread()+"阻塞，库存为："+list.size());
                full.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.add(new Object());
        empty.signalAll();
        System.out.println("生产者"+Thread.currentThread()+"生成一个物品，库存为："+list.size());
        lock.unlock();
    }

    public void consumer(){
        lock.lock();
        while (list.size() ==0) {
            try {
                System.out.println("消费者"+Thread.currentThread()+"阻塞，库存为："+list.size());
                empty.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.remove();
        full.signalAll();
        System.out.println("消费者"+Thread.currentThread()+"消费一个物品，库存为："+list.size());
        lock.unlock();
    }
}
