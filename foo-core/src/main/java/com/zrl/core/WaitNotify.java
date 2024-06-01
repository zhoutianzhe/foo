package com.zrl.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author riliang.zrl
 * @Date 2024/5/13 19:27
 * @Description
 **/
public class WaitNotify {

    public static void main(String[] args) {
        //1、定义共享资源
        //2、定义生产者，消费者
        //3、创建生产者消费者线程
        //4、启动

        List<Integer> list = new ArrayList<>();

        Runnable producer = ()->{
            //关键 synchronized这里生产者消费者共同的锁对象
            synchronized (list){
                while(true){
                    if(list.size()>0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        int item = new Random(100).nextInt();
                        list.add(item);
                        System.out.println("producer: add item: " + item);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        list.notify();
                    }
                }
            }
        };

        Runnable consumer = ()->{
            //关键 synchronized这里生产者消费者共同的锁对象
            synchronized (list){
                while(true){
                    if(list.size()==1){
                        Integer item = list.remove(0);
                        System.out.println("consumer: add item: " + item);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        list.notify();
                    }else{
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Thread pt = new Thread(producer);
        Thread ct = new Thread(consumer);

        pt.start();
        ct.start();

    }

}
