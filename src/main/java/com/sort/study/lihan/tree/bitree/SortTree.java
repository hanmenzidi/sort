package com.sort.study.lihan.tree.bitree;

/**
 * @Author: lihan
 * @Date : 2022/1/5- 01
 * @DESCRIPTION: com.sort.study.lihan.tree.bitree
 * @version: 1.0
 */
public class SortTree {
    public static void main(String[] args) {

    }

    public static BiTreeNode findHead(BiTreeNode root){
        if (root ==null){
            return root;
        }
        return null;
    }

    public static Info getInfo (BiTreeNode root){
       if (root == null){
           return new Info(true, Integer.MIN_VALUE);
       }
       Info leftInfo = getInfo(root.lchld);
       Info rightInfo = getInfo(root.rchld);
       Info info = new Info();
       boolean flag = leftInfo.flag && rightInfo.flag;
       if (leftInfo.val > root.data || rightInfo.val < root.data){
           flag = false;
       }
       info.flag = flag;
       info.val = root.data;
       return  info;

    }

    static class Info{
        boolean flag = true;
        int val;
        BiTreeNode root;
        int count;

        public Info(boolean flag, int val) {
            this.flag = flag;
            this.val = val;
        }

        public Info() {
        }
    }
}
