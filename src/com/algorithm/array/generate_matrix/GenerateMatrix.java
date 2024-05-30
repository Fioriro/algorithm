package com.algorithm.array.generate_matrix;

public class GenerateMatrix {


    public static void main(String[] args) {
        int n = 3;
        traverse(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startX = 0, startY = 0; //每一圈的起始点
        int offset = 1; // 控制每一条边遍历的长度，每次循环右边界收缩一位
        int count = 1; // 用来给矩阵中的空格赋值
        int loop =  1; // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int i, j;
        while (loop <= n / 2){ // 都是左闭右开
            // 上行从右到左
            for (j = startY; j < n - offset; j++){
                res[startX][j] = count++;
            }
            // 右列从上到下
            for (i = startX; i < n - offset; i++){
                res[i][j] = count++;
            }
            // 下行从右到左
            for(; j > startY; j--){
                res[i][j] = count++;
            }
            // 左列从下到上
            for(; i > startX; i--){
                res[i][j] = count++;
            }

            // 第二圈开始的时候，起始位置要各自加1
            // 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startX++;
            startY++;

            // offset 控制每一圈里每一条边遍历的长度
            offset++;
            loop++;
        }
        if(n % 2 == 1){
            res[startX][startY] = count;
        }
        return res;
    }

    public static void traverse(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
