package com.algorithm.recursion.force.subsequence;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    /**
     * convert the specified string to a character array
     * then, begin the recursive process
     * @param str
     */
    public static void printAllSubsequences(String str){
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    /**
     *
     * @param str the given character array
     * @param i
     * @param res
     */
    public static void process(char[] str, int i, List<Character> res){
        if(i == str.length){
            printList(res);
            return;
        }
        List<Character> resKeep = new ArrayList<>(res);
        resKeep.add(str[i]);
        process(str, i + 1, resKeep);
        List<Character> resExcluded = new ArrayList<>(res);
        process(str, i + 1, resExcluded);
    }

    public static void printList(List<Character> list){
        for (Character c : list) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printAllSubsequences("abc");
    }
}
