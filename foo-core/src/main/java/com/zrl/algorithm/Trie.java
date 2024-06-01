package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/28 00:18
 * @Description
 **/
public class Trie {

    private class Node{
        Node[] children = new Node[26];
        boolean isLeaf = false;
    }

    private Node root;

    public Trie() {
       root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null){
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index]==null){
                return false;
            }
            current = current.children[index];
        }
        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(current.children[index]==null){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

}
