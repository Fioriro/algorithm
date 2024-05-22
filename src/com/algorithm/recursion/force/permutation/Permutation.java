package com.algorithm.recursion.force.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static ArrayList<String> printPermutation(String str){
        ArrayList<String> res = new ArrayList<String>();
        char[] charArray = str.toCharArray();
        process(charArray, 0, res);
        return res;
    }


    public static void process(char[] str, int i, ArrayList<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
        }
        //分支限界， 剪枝
        boolean[] visit = new boolean[26];
        for(int j = i; j < str.length; j++){
            if(!visit[str[j] - 'a']){
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> res = printPermutation("abc");
        System.out.println(res);
    }
}
