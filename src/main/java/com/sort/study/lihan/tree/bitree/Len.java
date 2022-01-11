package com.sort.study.lihan.tree.bitree;

import com.sort.study.lihan.tree.DoubleNode;

/**
 * @Author: lihan
 * @Date : 2022/1/5- 01
 * @DESCRIPTION: com.sort.study.lihan.tree.bitree
 * @version: 1.0
 */
public class Len {
    public static void main(String[] args) {

    }

    public  static Info maxLen(DoubleNode root){
        if (root == null){
            return  new Info();
        }
        Info leftInfo = maxLen(root.left);
        Info rightInfo = maxLen(root.right);


        Info info = new Info();
        info.height = 1 + Math.max(leftInfo.height,rightInfo.height);
        int distance = Math.max(leftInfo.len,rightInfo.len);
        distance = Math.max(distance,leftInfo.height + rightInfo.len +1);
        info.len = distance;
        return  info;
    }

   static class Info{
       int len;
       int height;
    }

    public static  int height(DoubleNode root){
        if(root == null){
            return  -1;
        }
        int leftHeight = height(root.left);
        int rigHeight = height(root.right);
        int height = Math.max(leftHeight,rigHeight)+1;
        return  height;


    }
}
