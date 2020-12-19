package com.tech.zsh.algorithm.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = RandomArrayUtil.randomIntArray(20,100);
        RandomArrayUtil.printArray(array);
        sort(array);
        RandomArrayUtil.printArray(array);
    }

    private static void sort(int[] array){
       for(int i=1;i<array.length-1;i++){
           int temp = array[i+1];
           int j = i;
           for(;j>=0;j--){
               if(array[j]>temp){
                   array[j+1] = array[j];
               }else{
                   break;
               }
           }
           array[j+1] = temp;
       }
    }






}
