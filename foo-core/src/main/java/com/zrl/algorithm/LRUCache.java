package com.zrl.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author riliang.zrl
 * @Date 2024/5/9 15:59
 * @Description
 **/
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

//        [2,1],[1,1],[2,3],[4,1],[1],[2]
        lRUCache.put(2,1);
        lRUCache.put(1,1);
        lRUCache.put(2,3);
        lRUCache.put(4,1);
        lRUCache.get(1);
        lRUCache.get(2);
    }

    private Map<Integer, Integer> cache;

    private int size;
    private int capacity;

    private LinkedList<Integer> list = new LinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if(value == null){
            return -1;
        }
        list.remove((Integer) key);
        list.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        boolean contain = cache.containsKey(key);
        if(contain){
            list.remove((Integer) key);
            list.addFirst(key);
            cache.put(key, value);
        }else{
            if(size == capacity){
                Integer e = list.removeLast();
                cache.remove(e);
                size--;
            }
            cache.put(key, value);
            list.addFirst(key);
            size++;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
