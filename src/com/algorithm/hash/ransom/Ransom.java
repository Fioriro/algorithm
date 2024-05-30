package com.algorithm.hash.ransom;

public class Ransom {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        char[] charArray = magazine.toCharArray();
        char[] charArray1 = ransomNote.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i] - 'a']++;
        }

        for (int i = 0; i < charArray1.length; i++) {
            map[charArray1[i] - 'a']--;
        }

        for (int i = 0; i < map.length; i++) {
            if(map[i] < 0){
                return false;
            }
        }
        return true;
    }
}
