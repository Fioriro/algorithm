package com.algorithm.hash.randompool;

import java.util.HashMap;
import java.util.Map;

public class RandomPool {
    public static class Pool<K> {
        private Map<K, Integer> keyIndexMap;
        private Map<Integer, K> indexKeyMap;
        private int size;


        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }


        public void insert(K key) {
            if(!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++,key);
            }
        }

        public void delete(K key) {
            if(this.keyIndexMap.containsKey(key)){
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }

        }

        public  K getRandom() {
            if(this.size == 0){
                return null;
            }
            return this.indexKeyMap.get((int) (Math.random() * this.size));
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
    }
}
