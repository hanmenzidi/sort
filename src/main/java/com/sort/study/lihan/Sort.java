package com.sort.study.lihan;
/*
* @author lihan
* @date 2021/12/4
*
* */

import java.util.Arrays;

public class Sort {
    /**
     * 冒泡排序
     * @param arr 待排序的数组
     */

    public static void bubbleSort(int[] arr){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen -1 ; i++) {
            boolean isSwapped= false;
            for (int j = 0; j < arrLen -1 -i  ; j++) {
                int front = arr[j];
                int next  = arr[j +1 ];
                if(front > next){
                     arr[j +1 ] = front;
                     arr[j] = next;
                     isSwapped = true;
                }

            }
            if( !isSwapped) {
                {
                    break;
                }
            }

        }

    }

   //选择排序
    public static void selectSort(int[] arr){
        int len = arr.length;
        //选择次数
        for(int i = 0; i < len-1; i++){
            int maxIndex = 0;
            //选择为排序里面最大的值
            for (int j = 0; j < len -i ; j++) {
                if( arr[j] >= arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[ len-i-1];
            arr[len -i -1] = arr[maxIndex];
            arr[maxIndex] = temp;

        }

    }

  //插入排序
    public static void insertSort(int[] arr){
        int len = arr.length;
        //待排序的元素
        for (int i = 1; i < len ; i++) {
            int val = arr[i];
     //直接放入就有序
            if(val >= arr[i-1])continue;
            for (int j = i-1; j >=0 ; j--) {
                if( val <  arr[j]){
                    arr[j +1] = arr[j];
                }else{
                    arr[j+1] = val;
                    break;
                }
            }

        }

    }

    //归并排序
    /*
    @param: 待排序的数组
    * */

    public static void mergerSort(int[] arr, int start, int end,int[] temp){

        if(start < end){
            int mid = (start + end)/2;
            mergerSort(arr, start, mid, temp);
            mergerSort(arr, mid+1, end, temp);
            hebing(arr,start,end,temp);
        }


    }

    public static void hebing(int[]arr, int start, int end, int[] temp) {
        int mid = (start + end)/2;
        int leftIndex = start;
        int rightIndex = mid +1;
        int storeIndex = 0;
        while (leftIndex<= mid && rightIndex<= end ){
            if(arr[rightIndex] <= arr[leftIndex]){
                temp[storeIndex++] = arr[rightIndex];
                rightIndex++;

            }else {
                temp[storeIndex++] = arr[leftIndex];
                leftIndex++;
            }

        }
        if (leftIndex <= mid){
            for (int i = leftIndex; i <= mid ; i++) {
                temp[storeIndex++] = arr[i];
            }
        }

        if (rightIndex <= end){
            for (int i = rightIndex; i <= end ; i++) {
                temp[storeIndex++] = arr[i];
            }
        }
        storeIndex = 0;
        for (int i = start; i <= end ; i++) {
            arr[i] = temp[storeIndex++];
        }


    }


    //计数排序
    public static void  jishuSort(int[] arr){
        int[] base = new int[101];
        int len = arr.length;
        int[] result = new int[len];
//统计每个数出现的次数
        for (int i = 0; i < len; i++) {
            int temp = arr[i];
            base[temp]++;
        }
//求出每个数，最后一次出现的位置
        for (int i = 1; i < base.length ; i++) {
            int frontNum = base[i-1];
            base[i] = base[i] + base[i-1];
        }
//从数组的尾部往前遍历
        for (int i = len-1; i >= 0 ; i--) {
 //求出每个数在数组中应该的位置
            int temp = arr[i];
            int index = base[temp];
            base[temp]--;
            result[index -1] = temp;

        }
        System.arraycopy(result,0,arr,0,len);
        System.out.println("==============");
    }

}
