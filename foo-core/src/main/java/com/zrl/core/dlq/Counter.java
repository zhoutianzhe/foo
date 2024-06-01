package com.zrl.core.dlq;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zrl
 * @date 2024/5/31 22:26
 * @description 计数器
 */
public class Counter {

    private int failureCount;

    private long failureTimeInterval;

    /**
     * 失败个数
     */
    private AtomicInteger currentFailureCount = new AtomicInteger(0);

    /**
     * 成功个数
     */
    private AtomicInteger successCount = new AtomicInteger(0);

    private long lastTime;


    public Counter(int failureCount, long failureTimeInterval){
        this.failureCount = failureCount;
        this.failureTimeInterval = failureTimeInterval;
        currentFailureCount = new AtomicInteger(0);
        successCount = new AtomicInteger(0);
        this.lastTime = System.currentTimeMillis();
    }

    /**
     * 失败数+1
     * 关键 同步锁
     */
    public synchronized int inrcFailureCount(){
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastTime > failureTimeInterval){
            lastTime = currentTime;
            currentFailureCount.set(0);
        }
        return currentFailureCount.incrementAndGet();
    }

    /**
     * 成功数+1
     */
    public synchronized int inrcSuccessCount(){
        return successCount.incrementAndGet();
    }

    public int getSuccessCount(){
        return successCount.get();
    }

    /**
     * 失败总数是否超过
     */
    public boolean failureCountOver(){
        return currentFailureCount.get() >= failureCount;
    }


    //关键 synchronized
    public synchronized void reset(){
        successCount.set(0);
        currentFailureCount.set(0);
    }

}
