package com.zrl.algorithm;

import java.util.*;

/*
 * @author  wuluo
 * @Date 2024/4/9 11:07
 * @Description
 **/
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }
    public static String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        if(sn<tn){
            return "";
        }

        Character c = null;

        List<Character> sarr = new ArrayList();
        for(int i=0; i<sn; i++){
            c = s.charAt(i);
            sarr.add(c);
        }
        Map<Character, Integer> rcache = new HashMap();
        for(int i=0; i<tn; i++){
            c = s.charAt(i);
            rcache.put(c, rcache.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> tcache = new HashMap();
        for(int i=0; i<tn; i++){
            c = t.charAt(i);
            tcache.put(c, tcache.getOrDefault(c,0)+1);
        }

        int l=0;
        int r=tn-1;
        int min = Integer.MAX_VALUE;
        int[] ansr = null;
        while(r<sn){
            if(r-l+2>=tn && check(rcache, tcache)){
                if(r-l<min){
                    min = r-l;
                    ansr = new int[]{l,r};
                }
                c = sarr.get(l);
                rcache.put(c, rcache.getOrDefault(c,0)-1);
                l++;
            }else{
                if(r<sn-1){
                    r++;
                    c = sarr.get(r);
                    rcache.put(c, rcache.getOrDefault(c,0)+1);
                }
            }
            if(r-l<tn && r==sn-1){
                break;
            }
        }


        if(ansr!=null){
            return s.substring(ansr[0],ansr[1]+1);
        }
        return "";
    }

    private static boolean check(Map<Character, Integer> rcache, Map<Character, Integer> tcache){
        for(Map.Entry<Character, Integer> entry : tcache.entrySet()){
            if(entry.getValue() > rcache.getOrDefault(entry.getKey(),0)){
                return false;
            }
        }
        return true;
    }
}
