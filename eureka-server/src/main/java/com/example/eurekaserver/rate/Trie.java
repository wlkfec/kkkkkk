package com.example.eurekaserver.rate;

/**
 * 查找前缀匹配
 */

public class Trie {

    // 如果只是固定的一些字符串信息， 可以使用字符串数组字符串匹配算法进行判断
    // 如果涉及到了前缀，可以使用trie操作，但是由于存放的都是指针，并不利于缓存
    // 如果其中设计了 ** 正则，那么就需要使用 回溯算法进行操作
    private final TrieNode root = new TrieNode('/'); // 存储无意义字符

    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(c);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在Trie树中查找一个字符串
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        // 找到pattern
        return p.isEndingChar; // 不能完全匹配，只是前缀
    }

    public static class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }
}