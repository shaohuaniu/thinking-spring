package com.tech.zsh.algorithm.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = RandomArrayUtil.randomIntArray(20,100);
        RandomArrayUtil.printArray(array);
        sort(array);
        RandomArrayUtil.printArray(array);
    }

    private static void sort(int[] array){
        for(int i=array.length/2;i>=0;i--){
            buildHeap(array,i,array.length);
        }
        for(int i=array.length-1;i>=0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            buildHeap(array,0,i);
        }
    }

    private static void buildHeap(int[] arr,int i,int length) {
        int temp = arr[i];
        //其中 left为当前节点下左子节点，left=left*2+1为子节点的下个子节点
        for(int left=2*i+1;left<length;left=left*2+1){
            //左节点和右节点比较
            int right = left+1 ;
            if( right <length && arr[right]>arr[left]){
                left++;
            }
            //最大的节点赋值给父节点，并记录被替换节点的位置信息，用户全部比较完成后赋值，完成交换。
            if(left<length && arr[left]>temp){
                arr[i] = arr[left];
                i = left;
            }else{
                break;
            }
        }
        arr[i] = temp;

    }




}
