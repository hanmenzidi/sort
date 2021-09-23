package com.sort.study.lihan;

import java.sql.Array;
import java.util.Arrays;

public class MergeSort {
 //注意数组的奇偶数问题
    static  int[] arr= {1,4,7,8,3,6,9};
    public static int[] merge(){
        int startA = 0;
        int endA = 3;
        int startB= 4;
        int endB = 6;
        int len = arr.length;
        int index =0;
        int[] result = new int[len];
        for(int i=startA,j= startB;;){
            if(arr[i] < arr[j]){
                result[index] = arr[i];
                i++;
                index++;
                if(i > endA){
                    for(;j<=endB; j++,index++){
                        result[index] = arr[j];
                    }
                    break;
                }

            }else {
                result[index] = arr[j];
                j++;
                index++;
                if(j> endB){
                    for(;i<=endA; i++,index++){
                        result[index] = arr[i];
                    }
                    break;
                }

        }

        }

        return result;
    }

    public static void main(String[] args) {
       //merge4ma(arr,1,4,5);
        sort4ma(arr , 0,arr.length-1);

        print(arr);



    }

    public static void print(int[] arr){
        Arrays.stream(arr).forEach(o->{
            System.out.print(o+",");
        });
    }

    public static  void merge4ma(int[]arr, int leftPtr, int rightPtr, int rightBoud){
        int reIndex = leftPtr;
        int index = 0;
        int[] temp = new int[rightBoud - leftPtr +1];
        int mid = rightPtr;
        while (leftPtr < mid && rightPtr <= rightBoud){
 //为什么要加=号，因为相等的话，去前面数组的值，排序稳定
          /* if(arr[indexA] <=arr[indexB]){
                temp[index++] = arr[indexA++];
            }else{
                temp[index] = arr[indexB];
                index++;
                indexB++;
            }*/
            temp[index++] = arr[leftPtr]<= arr[rightPtr] ? arr[leftPtr++] :arr[rightPtr++];
        }
        //类比自己写的代码，可以减少if的判断语句
        while (leftPtr < mid){
            temp[index] = arr[leftPtr];
            index++;
            leftPtr++;
        }
        //代码简化
        while (rightPtr <= rightBoud)temp[index++] = arr[rightPtr++];

        //重新赋值回原数组
        for(int i=0; i<temp.length; )arr[reIndex++] = temp[i++];



    }

    public static  void sort4ma(int[] arr ,int left,int right){
        //只有一个元素
        if(left == right) return;

        //分成两半,(left+right)/2的问题,可能int越界
        int mid = left + (right-left)/2;

        //左边排序
        sort4ma(arr,left,mid);

        //右边排序
        sort4ma(arr,mid+1,right);

        //合并
        merge4ma(arr,left,mid+1,right);


    }
}

