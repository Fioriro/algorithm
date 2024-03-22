package com.algorithm.trie;

public class TrieProblem {
    public static class TrieNode {
        public int pass; //The number of times the current node has been passed
        public int end; //The number of times the current node as an end node
        public TrieNode[] nexts;
        public TrieNode(){
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }

    }

    public static class Trie {

        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word){
            if(search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefix(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("hello");
        trie.insert("world");
        trie.insert("trie");
        trie.insert("tree");

        // Search for words
        System.out.println(trie.search("hello")); // Expected: 1
        System.out.println(trie.search("world")); // Expected: 1
        System.out.println(trie.search("trie"));  // Expected: 1
        System.out.println(trie.search("tree"));  // Expected: 1

        // Delete words
        trie.delete("hello");
        trie.delete("world");

        // Search for words after deletion
        System.out.println(trie.search("hello")); // Expected: 0
        System.out.println(trie.search("world")); // Expected: 0
        System.out.println(trie.search("trie"));  // Expected: 1
        System.out.println(trie.search("tree"));  // Expected: 1
    }
}
