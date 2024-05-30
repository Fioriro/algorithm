package com.algorithm.hash.getUnion;

import java.util.HashSet;
import java.util.Set;

public class GetUnion {



    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.retainAll(set2);
        int[] array = set1.stream().mapToInt(i -> i).toArray();
    }
}
