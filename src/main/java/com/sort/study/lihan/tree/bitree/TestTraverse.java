package com.sort.study.lihan.tree.bitree;

import com.sort.study.lihan.utils.Utils;

import java.nio.file.NotLinkException;
import java.util.*;

/**
 * @Author: lihan
 * @Date : 2022/1/1- 01
 * @DESCRIPTION: com.sort.study.lihan.tree.bitree
 * @version: 1.0
 */
public class TestTraverse {
    public static void main(String[] args) {
        BiTreeNode node = Utils.generateBiTreeNode();
      /* System.out.println("先序遍历");
        pre(node);
        System.out.println( );
       noRecursionPre(node);*/
      /*  System.out.println("中序遍历");
        in(node);
        System.out.println();
        noRecursionIn(node);*/

    System.out.println("后序遍历");
        post(node);
        System.out.println( );
        noRecursionPost3(node);

       /* System.out.println("层次遍历");
        cell(node);*/
      /* int result = maxWidth2(node);
        System.out.println("最大宽度："+ result);*/
    }

    public static void pre(BiTreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.getData()+",");
        pre(root.getLchld());
        pre(root.getRchld());

    }


    public  static  void noRecursionPre(BiTreeNode root){
        if(root == null){
            return;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(root);
        BiTreeNode curNode;
        while (!stack.isEmpty()){
            curNode = stack.pop();
            System.out.print( curNode.getData()+",");
            if(curNode.getRchld()!= null){
                stack.push(curNode.getRchld());
            }
            if(curNode.getLchld() != null){
                stack.push(curNode.getLchld());
            }

        }
    }

    public static void in(BiTreeNode root){
        if(root == null){
            return;
        }
        in(root.getLchld());
        System.out.print(root.getData()+",");
        in(root.getRchld());
    }

    public static void noRecursionIn(BiTreeNode root){
        if(root == null){
            return;
        }
        Stack<BiTreeNode> stack = new Stack<>();
       while (!stack.isEmpty() || root != null){
           if(root != null){
               stack.push(root);
               root = root.getLchld();
           }else {
               root = stack.pop();
               System.out.print(root.getData()+",");
               root = root.getRchld();
           }
       }
    }

    public static void noRecursionIn2(BiTreeNode root){
        if (root == null){
            return;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(root);
        BiTreeNode curNode;
        while (!stack.isEmpty()){
            curNode = stack.peek();
            if (curNode.getLchld()!= null){
                stack.push(curNode);
                continue;
            }
            System.out.print(curNode.getData()+',');
            if (curNode.getRchld() != null){
                stack.push(curNode.getRchld());
            }
            stack.pop();
        }
    }
    public static void post (BiTreeNode root){
        if(root == null){
            return;
        }
        post(root.getLchld());
        post(root.getRchld());
        System.out.print(root.getData()+",");
    }




    public  static  void noRecursionPost1(BiTreeNode root){
        if(root == null){
            return;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        Stack<BiTreeNode> stackTemp = new Stack<>();
        stack.push(root);
        BiTreeNode curNode;
        while (!stack.isEmpty()){
            curNode = stack.pop();
            stackTemp.push(curNode);
            if(curNode.getLchld() != null){
                stack.push(curNode.getLchld());
            }
            if(curNode.getRchld()!= null){
                stack.push(curNode.getRchld());
            }


        }

        while (!stackTemp.isEmpty()){
            curNode = stackTemp.pop();
            System.out.print(curNode.getData()+", ");
        }

    }

    public  static  void noRecursionPost3(BiTreeNode root){
        if (root == null){
            return;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(root);
        BiTreeNode curNode = root;
        BiTreeNode lastPrintNode = null;
        BiTreeNode leftNode= null;
        while (!stack.isEmpty()){
            curNode = stack.peek();
            leftNode = curNode.getLchld();
            if (leftNode != null  && curNode.getLchld() != lastPrintNode && curNode.getRchld() != lastPrintNode ){
                stack.push(leftNode);
                continue;
            }
            if (curNode.getRchld() != null && lastPrintNode == curNode.getLchld()){
                stack.push(curNode.getRchld());
                continue;
            }

//后序的打印叶子节点
            if ((leftNode == null && curNode.getRchld() == null) || lastPrintNode == curNode.getRchld()){
                System.out.print(curNode.getData()+",");
                lastPrintNode = curNode;
                stack.pop();
                continue;
            }

        }
    }
    //不使用额外空间
    public static void noRecursionPost2(BiTreeNode root){
        if(root == null){
            return;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(root);
//当前节点
        BiTreeNode curNode = null;
//上一次弹出的节点，初始值为root，不代表该节点弹出
//遍历到左子树的最左节点后，才有实际意义
        BiTreeNode lastPopNode = root;
        while (!stack.isEmpty()){
            curNode = stack.peek();
//压入左子树
//只有第一次到达这个节点的时候才会压入左子树
//lastPopNode != curNode.getLchld(),第二次达到curNode
//lastPopNode != curNode.getRchld(，第三次达到curNode
            if(curNode.getLchld() != null && lastPopNode != curNode.getLchld() && lastPopNode != curNode.getRchld()){
                stack.push(curNode.getLchld());
//之前弹出的节点是当前节点的左节点，开始压入右子树
            }else if( curNode.getRchld() != null && lastPopNode != curNode.getRchld()){
                stack.push(curNode.getRchld());
            }else {
//当前节点为叶子节点，之前一个弹出的节点是当前节点的右节点
                System.out.print( stack.pop().getData() +",");
                lastPopNode= curNode;
            }
        }
    }
//使用队列
    public static void cell(BiTreeNode root){
        if(root == null){
            return;
        }
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BiTreeNode curNode;
        while (!queue.isEmpty()){
            curNode = queue.poll();
            System.out.print(curNode.getData()+",");
            if(curNode.getLchld() != null){
                queue.add(curNode.getLchld());
            }
            if(curNode.getRchld()!= null){
                queue.add(curNode.getRchld());
            }

        }
    }

    public static int maxWidth(BiTreeNode root){
        if(root == null){
            return 0;
        }
        int maxWidth =0;
//存储每个节点所在层级
        Map<BiTreeNode,Integer> cellMap = new HashMap<>();
//当前所在层级
        int curCell = 1;
//当前节点所在层级
        int nodeCell;
//当前层级的节点总数
        int curCellNodes = 0;
//当前节点
        BiTreeNode curNode ;
        Queue<BiTreeNode> queue = new LinkedList<>();
        cellMap.put(root,1);
        queue.add(root);
        while (!queue.isEmpty()){
            curNode = queue.poll();
            if(curNode.getLchld() != null){
                queue.add(curNode.getLchld());
                cellMap.put(curNode.getLchld(),curCell+1);
            }
            if(curNode.getRchld() != null){
                queue.add(curNode.getRchld());
                cellMap.put(curNode.getRchld(),curCell+1);
            }

            nodeCell = cellMap.get(curNode);
            if(nodeCell == curCell){
                curCellNodes++;
                continue;
            }

                maxWidth = Math.max(maxWidth,curCellNodes);
                curCellNodes = 1;
                curCell = nodeCell;


        }
        maxWidth = Math.max(maxWidth,curCellNodes);

        return maxWidth;

    }

    public static  int maxWidth2(BiTreeNode root)
    {
        if(root == null){
            return 0;
        }
        Queue<BiTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BiTreeNode curCellEnd = root;
        BiTreeNode nextCellEnd = null;
        BiTreeNode curNode;
        int curCellNodes = 0;
        int maxWidth = 0;
        while (!queue.isEmpty()){
            curNode = queue.poll();
            if(curNode.getLchld() != null){
                queue.add(curNode.getLchld());
                nextCellEnd = curNode.getLchld();
            }
            if(curNode.getRchld() !=  null){
                queue.add(curNode.getRchld());
                nextCellEnd = curNode.getRchld();
            }
            if(curNode != curCellEnd){
                curCellNodes++;
            }else{
                curCellEnd = nextCellEnd;
                maxWidth = Math.max(maxWidth,curCellNodes);
                curCellNodes = 1;

            }
        }
        return maxWidth;
    }
}
