package com.zrl.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018-10-25
 */
public class ListDiff {

    /**
     * list1 list2 不相同的元素
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> getDiffrent(List<String> list1, List<String> list2)
    {
        Map<String,Integer> map = new HashMap<String,Integer>(list1.size()+list2.size());
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }

        for (String string : maxList)
        {
            map.put(string, 1);
        }

        for (String string : minList)
        {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }

        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }

    /**
     * list1比list2多出多少数据
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> getList1More(List<String> list1, List<String> list2)
    {
        Map<String,Integer> map = new HashMap<String, Integer>(list1.size());
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;

        for (String string : maxList)
        {
            map.put(string, 1);
        }

        for (String string : minList)
        {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
        }

        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }

}
