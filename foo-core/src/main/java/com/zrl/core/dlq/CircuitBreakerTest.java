package com.zrl.core.dlq;

import java.util.concurrent.TimeUnit;

/**
 * @author zrl
 * @date 2024/5/31 23:25
 * @description xxx
 */
public class CircuitBreakerTest {

    public static void main(String[] args) {
        Config config = new Config();
        CircuitBreaker cb = new CircuitBreaker(config);
        for (int i = 0; i < 10; i++) {
            if(i == 6){
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int finalI = i;
            String result = cb.run(()->{
                System.out.println("执行方法数" + finalI);
                if(finalI < 6){
                    int a = 1/0;
                }
                return "success";
            }, (t)->{
                System.out.println(t);
                return "执行方法";
            });
        }
    }

}
