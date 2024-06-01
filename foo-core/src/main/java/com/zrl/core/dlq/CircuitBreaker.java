package com.zrl.core.dlq;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zrl
 * @date 2024/5/31 22:15
 * @description xxx
 */
public class CircuitBreaker {

    private Config config;

    private Counter counter;

    private State state;

    //上一次开启时间
    private long lastOpenTime;

    public CircuitBreaker(Config config){
        this.config = config;
        this.state = State.CLOSED;
        counter = new Counter(config.getCloseFailedCount(), config.getFailureTimeInterval());
    }

    public <R> R run(Supplier<R> supplier, Function<Throwable, R> callback){
        try {
            if(state == State.CLOSED){
                return supplier.get();
            }else if(state == State.OPEN){
                //判断要不要半开
                if(halfOpenTimeOut()){
                    halfOpen();
                    return halfOpenHandle(supplier, callback);
                }
                return callback.apply(new RuntimeException("降级处理"));
            }else{
                return halfOpenHandle(supplier, callback);
            }
        } catch (Throwable t){
            counter.inrcFailureCount();
            if(counter.failureCountOver()){
                //开启
                open();
            }
            return callback.apply(t);
        }
    }

    private <R> R halfOpenHandle(Supplier<R> supplier, Function<Throwable,R> callback) {
        try {
            R r = supplier.get();
            counter.inrcSuccessCount();
            if(counter.getSuccessCount() >= config.getOpenSuccessCount()){
                close();
            }
            return r;
        }catch (Exception e){
            counter.inrcFailureCount();
            return callback.apply(e);
        }
    }

    private boolean halfOpenTimeOut(){
        return System.currentTimeMillis() - lastOpenTime > config.getHalfOpenTimeOut();
    }

    private void close(){
        System.out.println("关闭降级");
        state = State.CLOSED;
    }

    private void open(){
        System.out.println("开启降级");
        state = State.OPEN;
        //关键 不要楼这一步
        lastOpenTime = System.currentTimeMillis();
    }

    private void halfOpen() {
        System.out.println("进入半开状态");
        state = State.HALF_OPEN;
    }

}
