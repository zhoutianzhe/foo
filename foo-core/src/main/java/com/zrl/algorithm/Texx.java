package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/4/18 23:21
 * @Description
 **/
public class Texx {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> ss = new ArrayList<>();
        ss.add("apple");
        ss.add("pen");
        boolean a = wordBreak(s, ss);
        System.out.println(a);
        List<String> wordDict = new ArrayList<>();
        for (String s1 : wordDict) {
            
        }

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        int n = s.length();
        boolean[] f = new boolean[n+10];
        f[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i && !f[i];j++){
                String sub = s.substring(j-1, i);
                if(set.contains(sub)){
                    f[i] = f[j-1];
                }
            }
        }
        return f[n];
    }

}
