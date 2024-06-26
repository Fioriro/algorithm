package com.algorithm.greedy.lowestlexicography;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        });
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));
    }
}
