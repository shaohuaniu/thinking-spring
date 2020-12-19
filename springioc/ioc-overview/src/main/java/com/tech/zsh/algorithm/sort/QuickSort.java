package com.tech.zsh.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = RandomArrayUtil.randomIntArray(20,100);
        RandomArrayUtil.printArray(array);
        sort(array);
        RandomArrayUtil.printArray(array);
    }

    private static void sort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array,int l,int h) {
        if(l>h){
            return;
        }
        int ol = l,oh=h;
        int mid = l+(h-l)/2;
        int temp = array[mid];
        array[mid] = array[l];
        array[l] = temp;
        while(l<h){
            while(l<h && array[h]>=temp){
                h--;
            }
            array[l]=array[h];
            while (l<h && array[l]<=temp){
                l++;
            }
            array[h]=array[l];
        }
        array[l] = temp;
        quickSort(array, ol, l - 1);
        quickSort(array, l + 1, oh);

    }




}
