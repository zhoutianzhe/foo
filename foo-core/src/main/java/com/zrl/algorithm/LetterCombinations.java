package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/13 16:22
 * @Description
 **/
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations obj = new LetterCombinations();
        List<String> ans = obj.letterCombinations("23");
        System.out.println(ans);
    }

    List<String> ans = new ArrayList<>();

    List<String> temp = new ArrayList<>();

    static Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("2", Arrays.asList(new String[]{"a","b","c"}));
        map.put("3", Arrays.asList(new String[]{"d","e","f"}));
        map.put("4", Arrays.asList(new String[]{"g","h","i"}));
        map.put("5", Arrays.asList(new String[]{"j","k","l"}));
        map.put("6", Arrays.asList(new String[]{"m","n","o"}));
        map.put("7", Arrays.asList(new String[]{"p","q","r","s"}));
        map.put("8", Arrays.asList(new String[]{"t","u","v"}));
        map.put("9", Arrays.asList(new String[]{"w","x","y","z"}));
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<List<String>> list = new ArrayList<>();
        for (char aChar : chars) {
            List<String> cs = map.get(String.valueOf(aChar));
            list.add(cs);
        }

        int n = chars.length;
        trackBack(list, n, 0);

        return ans;
    }

    private void trackBack(List<List<String>> list, int n, int i) {
        if(i == n && temp.size() == n){
            ans.add(join(temp));
            return;
        }

        for(int j=i; j<n; j++){
            List<String> strings = list.get(j);
            for (String string : strings) {
                temp.add(string);
                trackBack(list, n, j+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static String join(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

}
