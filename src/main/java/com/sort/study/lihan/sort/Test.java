package com.sort.study.lihan.sort;

import com.sort.study.lihan.utils.Utils;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = Utils.generateArrr(20);
        int[] tempdArr = Arrays.copyOf(arr,arr.length);
        Sort.heapSort(arr);
        boolean flag = Utils.isArrOrdered(arr,tempdArr);
        System.out.println(flag);
    }
}
