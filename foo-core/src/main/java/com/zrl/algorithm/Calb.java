package com.zrl.algorithm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author riliang.zrl
 * @Date 2024/4/17 17:37
 * @Description
 **/
public class Calb {

    public static void main(String[] args) throws InterruptedException {
        Calb calb = new Calb();
        int ans = calb.numSquares(13);
        System.out.println(ans);

        ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024*1024*300);
        ByteBuffer directBuffer2 = ByteBuffer.allocateDirect(1024*1024*500);

        Thread.sleep(1000*60);
    }

    public int numSquares(int n) {
        int ans = 0;
        List<Integer> cache = new ArrayList();
        for(int i=1;;i++){
            int ii = i*i;
            if(ii>n){
                break;
            }
            cache.add(ii);
        }

        for(int i=cache.size();i>0;i--){
            while(true){
                if(n==12){
                    return ans+3;
                }
                int temp = n-cache.get(i-1);
                if(temp>=0){
                    n = temp;
                    ans++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

}
