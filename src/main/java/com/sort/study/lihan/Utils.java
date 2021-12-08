package com.sort.study.lihan;

import java.util.Arrays;
import java.util.Collections;

public class Utils {
    private Utils(){

    }

    public  static int[] generateArrr(int len){
        if( len <0 )return new int[0];

        int[] result = new int[len];
        for (int i = 0; i <len ; i++) {
            int temp = (int)(Math.random()*100);
            result[i] = temp;

        }
        return result;
    }

    public static  boolean isArrOrdered(int[] arr){
        int len = arr.length;
        int[] tempArr ;
        tempArr = Arrays.copyOf(arr,len);
         Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            if( tempArr[i] != arr[i]){
                return  false;
            }
        }
        return true;

    }
}
