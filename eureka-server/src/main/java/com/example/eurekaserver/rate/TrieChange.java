package com.example.eurekaserver.rate;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 查找前缀匹配
 */

public class TrieChange {

    private final TrieNode root = new TrieNode(
            new Space(0L, 0L, 0L, "/", "")
    );

    private static final List<TrieNode> spaces = Lists.newArrayList(
            new TrieNode(new Space(100L, 0L, 100L, "101房间", "房间")),
            new TrieNode(new Space(100L, 100L, 1001L, "101房间-厨房", "厨房"))
    );

    // 往Trie树中插入一个字符串
    public void insert(List<TrieNode> spaces) {
        TrieNode p = root;
        for (TrieNode trieNode : spaces) {
            int index = Collections.binarySearch(p.children, trieNode, Comparator.comparing(o -> o.space.getId()));
            if (index < 0) {
                p.children.add(trieNode);
                p = trieNode;
            } else {
                p = p.children.get(index);
            }
        }
        p.isEndingChar = true;
    }

    public static void main(String[] args) {
//        TrieChange change = new TrieChange();
//        change.insert(spaces);
//        System.out.println(change.root);
//        List<String> cs = Lists.newArrayList();
//        cs.add("xxx");

        List<String> l1 = Lists.newArrayList("aaa1", "aaa2");
        List<String> l2 = Lists.newArrayList("bbb1", "bbb2");
        List<String> l3 = Lists.newArrayList("ccc1", "ccc2");

        for (String s : l1) {
            for (String l: l2) {
                for (String v: l3) {
                    System.out.println(s + l + v);
                }
            }
        }

    }

//    // 在Trie树中查找一个字符串
//    public boolean find(char[] pattern) {
//        TrieNode p = root;
//        for (char c : pattern) {
//            int index = c - 'a';
//            if (p.children[index] == null) {
//                return false; // 不存在pattern
//            }
//            p = p.children[index];
//        }
//        // 找到pattern
//        return p.isEndingChar; // 不能完全匹配，只是前缀
//    }

    public static class TrieNode {
        public Space space;
        public List<TrieNode> children = Lists.newArrayList();
        public boolean isEndingChar = false;
        public TrieNode(Space space) {
            this.space = space;
        }

        public Space getSpace() {
            return space;
        }

        public void setSpace(Space space) {
            this.space = space;
        }

        public List<TrieNode> getChildren() {
            return children;
        }

        public void setChildren(List<TrieNode> children) {
            this.children = children;
        }

        public boolean isEndingChar() {
            return isEndingChar;
        }

        public void setEndingChar(boolean endingChar) {
            isEndingChar = endingChar;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "space=" + space +
                    ", children=" + children +
                    ", isEndingChar=" + isEndingChar +
                    '}';
        }
    }
}