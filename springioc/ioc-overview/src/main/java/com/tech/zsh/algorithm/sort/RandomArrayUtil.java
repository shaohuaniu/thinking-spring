package com.tech.zsh.algorithm.sort;

import java.util.Random;

/**
 * 随机生成一个数组
 * @see java.util.Arrays
 */
public class RandomArrayUtil {


    public static int[] randomIntArray(int count,int limit){
        int[] array = new int[count];
        Random random = new Random();
        for(int i=0;i<count;i++){
            array[i] = random.nextInt(limit);
        }
        return array;
    }


    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
        System.out.println();
    }
}
