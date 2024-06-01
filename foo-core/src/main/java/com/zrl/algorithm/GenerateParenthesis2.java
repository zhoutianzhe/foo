package com.zrl.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author riliang.zrl
 * @Date 2024/5/28 16:18
 * @Description
 **/
public class GenerateParenthesis2 {

    public static void main(String[] args) {
        GenerateParenthesis2 obj = new GenerateParenthesis2();
        obj.generateParenthesis(2);
    }


    private void generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        trackback(ans, sb, 0, 0, n);
    }

    private void trackback(List<String> ans, StringBuilder sb, int left, int right, int n) {
        if(sb.length() == n*2){
            ans.add(sb.toString());
        }
        if(left<n){
            sb.append('(');
            trackback(ans, sb, left+1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            trackback(ans,sb,left,right+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}