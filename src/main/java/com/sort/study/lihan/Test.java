package com.sort.study.lihan;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = Utils.generateArrr(20);
        Sort.quickSort(arr);
        boolean flag = Utils.isArrOrdered(arr);
        System.out.println(flag);
    }
}
