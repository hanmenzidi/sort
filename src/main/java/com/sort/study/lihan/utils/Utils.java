package com.sort.study.lihan.utils;

import com.sort.study.lihan.tree.bitree.BiTreeNode;

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

    public static  boolean isArrOrdered(int[] arr,int[] origArr){
        int len = arr.length;
         Arrays.sort(origArr);
        for (int i = 0; i < len; i++) {
            if( origArr[i] != arr[i]){
                return  false;
            }
        }
        return true;

    }

    public static BiTreeNode generateBiTreeNode(){
        BiTreeNode node1 = new BiTreeNode();
        node1.setData('1');
        BiTreeNode node2 = new BiTreeNode();
        node2.setData('2');
        BiTreeNode node3 = new BiTreeNode();
        node3.setData('3');
        BiTreeNode node4 = new BiTreeNode();
        node4.setData('4');
        BiTreeNode node5 = new BiTreeNode();
        node5.setData('5');
        BiTreeNode node6 = new BiTreeNode();
        node6.setData('6');
        BiTreeNode node7 = new BiTreeNode();
        node7.setData('7');
        BiTreeNode node8 = new BiTreeNode();
        node7.setData('8');
        BiTreeNode node9 = new BiTreeNode();
        node7.setData('9');

        node1.setLchld(node2);
        node1.setRchld(node3);

        node2.setLchld(node4);
        node2.setRchld(node5);

        node3.setLchld(node6);
        node3.setRchld(node7);

        return node1;
    }

    public static BiTreeNode serialGenrateBiTreeNode(){
        BiTreeNode node1 = new BiTreeNode();
        BiTreeNode node2 = new BiTreeNode();
        BiTreeNode node3 = new BiTreeNode();
        node1.setData('1');
        node2.setData('1');
        node3.setData('1');
        node1.setLchld(node2);
        node2.setRchld(node3);

        return  node1;
    }

    public static BiTreeNode serialGenrateBiTreeNode4Cell(){
        BiTreeNode node1 = new BiTreeNode();
        BiTreeNode node2 = new BiTreeNode();
        BiTreeNode node3 = new BiTreeNode();
        BiTreeNode node4 = new BiTreeNode();
        BiTreeNode node5 = new BiTreeNode();
        BiTreeNode node6 = new BiTreeNode();
        BiTreeNode node7 = new BiTreeNode();
        BiTreeNode node8 = new BiTreeNode();
        node1.setData('1');
        node2.setData('2');
        node3.setData('3');
        node4.setData('4');
        node5.setData('5');
        node6.setData('6');
        node7.setData('7');
        node8.setData('8');
        node1.setLchld(node2);
        node1.setRchld(node3);
        node2.setRchld(node4);
        node3.setLchld(node5);
        node3.setRchld(node6);
        node5.setLchld(node7);
        node5.setRchld(node8);

        return  node1;
    }
}
