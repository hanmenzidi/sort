package com.sort.study.lihan;

import com.sort.study.lihan.tree.BiSearchTreeNode;
import com.sort.study.lihan.tree.BiTreeNode;

public class TestBiSearchTree {
    public static void main(String[] args) {
        BiSearchTreeNode node = generate();
        BiSearchTreeNode insert = insertNot(node, 39);
        System.out.println(insert);

    }

    public static  BiSearchTreeNode generate(){
        BiSearchTreeNode a_17 = new  BiSearchTreeNode();
        BiSearchTreeNode a_5 = new  BiSearchTreeNode();
        BiSearchTreeNode a_35 = new  BiSearchTreeNode();
        BiSearchTreeNode a_2 = new  BiSearchTreeNode();
        BiSearchTreeNode a_11 = new  BiSearchTreeNode();
        BiSearchTreeNode a_29 = new  BiSearchTreeNode();
        BiSearchTreeNode a_38 = new  BiSearchTreeNode();
        BiSearchTreeNode a_9 = new  BiSearchTreeNode();
        BiSearchTreeNode a_8 = new  BiSearchTreeNode();

        a_17.setData(17);
        a_5.setData(5);
        a_35.setData(35);
        a_2.setData(2);
        a_11.setData(11);
        a_29.setData(29);
        a_38.setData(38);
        a_9.setData(9);
        a_8.setData(8);

        a_17.setLchld(a_5);
        a_17.setRchld(a_35);

        a_5.setLchld(a_2);
        a_5.setRchld(a_11);

        a_35.setLchld(a_29);
        a_35.setRchld(a_38);

        a_11.setLchld(a_9);

        a_9.setLchld(a_8);

        return a_17;
    }


    //递归插入
    public  static  BiSearchTreeNode insert(BiSearchTreeNode root, int val){
        if ( root == null ){
            BiSearchTreeNode newNode = new BiSearchTreeNode();
            newNode.setData(val);
            return  newNode;
        }

        int rootVal = root.getData();
        if( val < rootVal){
            BiSearchTreeNode node = insert(root.getLchld(),val);
            root.setLchld(node);
        }else{
            BiSearchTreeNode node = insert(root.getRchld(),val);
            root.setRchld(node);
        }
        return root;
    }

    public static  BiSearchTreeNode insertNot(BiSearchTreeNode root, int val){
        BiSearchTreeNode newNode = new BiSearchTreeNode();
        newNode.setData(val);
        if(root == null){
          return  newNode;
        }
        BiSearchTreeNode tmpRoot  = root;
        BiSearchTreeNode beforeNode = root;
        while (root != null){
           BiSearchTreeNode lChild = root.getLchld();
           beforeNode = root;
           if(val > root.getData()){
               root = root.getRchld();
           }else{
               root = lChild;
           }
        }
        if(val > beforeNode.getData()){
            beforeNode.setRchld(newNode);
        }else {
            beforeNode.setLchld(newNode);
        }
        return  tmpRoot;
    }

}
