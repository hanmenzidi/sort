package com.sort.study.lihan.tree;

import java.util.ArrayList;
import java.util.List;

public class TestBiSearchTree {
    public static void main(String[] args) {
        BiSearchTreeNode node = generate();
        BiSearchTreeNode insert = delete(node,35);
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

    public static BiSearchTreeNode query(BiSearchTreeNode root, int val){
        if( root == null || root.getData() ==val){
            return root;
        }
        if(val < root.getData()){
           return query(root.getLchld(),val);
        }else{
            return query(root.getRchld(),val);
        }
    }

    public static BiSearchTreeNode delete(BiSearchTreeNode root, int val) {
        BiSearchTreeNode pNode = root;
        BiSearchTreeNode curNode = root;
        BiSearchTreeNode targetNode = null;
        int curVal = curNode.getData();

//找出要删除的节点和父节点
        while (true) {
            if (curNode == null) {
                return root;
            }
            curVal = curNode.getData();
            if (val < curNode.getData()) {
                pNode = curNode;
                curNode = curNode.getLchld();
                continue;
            }
            if (val > curNode.getData()) {
                pNode = curNode;
                curNode = curNode.getRchld();
                continue;
            }
            if (val == curNode.getData()) {
                targetNode = curNode;
                break;
            }

        }
        //要删除的节点有两个子节点
        if( targetNode.getLchld()!=null && targetNode.getRchld()!= null){
            List<BiSearchTreeNode> minRightNode = getMinRightNode(targetNode);
            int data = minRightNode.get(1).getData();
            targetNode.setData(data);
            pNode = minRightNode.get(0);
            targetNode = minRightNode.get(1);
            root = doDeleteNode(root,pNode,targetNode);
            return root;
        }
        root = doDeleteNode(root,pNode,targetNode);
        return root;

    }
//第一位是父节点，第二位是要删除的节点
    public static List<BiSearchTreeNode> getMinRightNode(BiSearchTreeNode root){
        List<BiSearchTreeNode> result = new ArrayList<>();
        result.add(root);
        while (root.getLchld() != null){
            result.set(0,root);
            root = root.getLchld();
        }
        result.add(root);
        return  result;
    }

/**
 * @Description 删除节点的方法
 * @Author lihan
 * @Date 2021/12/8
 * @Param
 * @param pNode
 * @param targetNode
 * @return com.sort.study.lihan.tree.BiSearchTreeNode
 **/
    public static BiSearchTreeNode doDeleteNode(BiSearchTreeNode root,BiSearchTreeNode pNode, BiSearchTreeNode targetNode){

        //targetNode有左子节点
        if(targetNode.getLchld()!=null){
            root = leftChildDelete(root,pNode,targetNode);
            return root;
        }
        //targetNode有右子节点
        if(targetNode.getRchld()!= null){

            root = rightChildDelete(root, pNode, targetNode);
            return root;
        }
        //targetNode没有字节点
        root = noChildDelete(root,pNode,targetNode);
        //targetNode只有一个子节点或者没有子节点
        return root;
    }


/**
 * @Description targetNode没有子节点，直接删除
 * @Author lihan
 * @Date 2021/12/8
 * @Param root 根节点
 * @param pNode targetNode的父节点
 * @param targetNode 要删除的节点
 * @return com.sort.study.lihan.tree.BiSearchTreeNode
 **/
    public static BiSearchTreeNode noChildDelete(BiSearchTreeNode root,BiSearchTreeNode pNode, BiSearchTreeNode targetNode){
        if(root == targetNode){
            root = null;
            return root;
        }
        if ( pNode.getLchld() == targetNode){
            pNode.setLchld(null);
        }else{
            pNode.setRchld(null);
        }
        return root;

    }
    /**
     * @Description targetNode只有一个左节点节点
     * @Author lihan
     * @Date 2021/12/8
     * @Param
     * @param pNode
     * @param targetNode
     * @return com.sort.study.lihan.tree.BiSearchTreeNode
     **/

    public static BiSearchTreeNode leftChildDelete(BiSearchTreeNode root,BiSearchTreeNode pNode, BiSearchTreeNode targetNode){
        BiSearchTreeNode cNode4Target =  targetNode.getLchld();
        targetNode.setLchld(null);
       if(root == targetNode){
           root = cNode4Target;
           return root;
       }
        if(pNode.getRchld() == targetNode){
           pNode.setRchld(cNode4Target);
           return root;
       }
       pNode.setLchld(cNode4Target);
        return root;
    }

/**
 * @Description targetNode只有一个右子节点
 * @Author lihan 
 * @Date 2021/12/8
 * @Param 
 * @param pNode
 * @param targetNode
 * @return com.sort.study.lihan.tree.BiSearchTreeNode
 **/

    public static BiSearchTreeNode rightChildDelete(BiSearchTreeNode root,BiSearchTreeNode pNode, BiSearchTreeNode targetNode){
        BiSearchTreeNode cNode4Target = targetNode.getRchld();
        targetNode.setRchld(null);
        if(root == targetNode){
            root = cNode4Target;
            return root;
        }
        if(pNode.getLchld() ==targetNode){
            pNode.setLchld(cNode4Target);
            return root;
        }
        pNode.setRchld(cNode4Target);
        return root;
    }

}
