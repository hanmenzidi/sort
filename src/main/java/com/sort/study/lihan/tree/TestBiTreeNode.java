package com.sort.study.lihan.tree;

import java.util.Stack;

public class TestBiTreeNode {
    public static void main(String[] args) {
        BiTreeNode e = new BiTreeNode();
        BiTreeNode a = new BiTreeNode();
        BiTreeNode g = new BiTreeNode();
        BiTreeNode c = new BiTreeNode();
        BiTreeNode f = new BiTreeNode();
        BiTreeNode b= new BiTreeNode();
        BiTreeNode d = new BiTreeNode();
        e.setData('e');
        a.setData('a');
        g.setData('g');
        c.setData('c');
        f.setData('f');
        b.setData('b');
        d.setData('d');

        e.setLchld(a);
        e.setRchld(g);

        a.setRchld(c);
        g.setRchld(f);

        c.setLchld(b);
        c.setRchld(d);

     // in_order(e);
      // pre_order(e);
        post_order(e);



    }

    //前序遍历=== e a c b d g f
    public static  void pre_order(BiTreeNode root){
        if (root != null){
            System.out.println(root.getData());
            pre_order(root.getLchld());
            pre_order(root.getRchld());
        }

    }

    //中序遍历 a b c d e g f
    public static void in_order(BiTreeNode root){
        if(root != null){
            in_order(root.getLchld());
            System.out.println(root.getData());
            in_order(root.getRchld());

        }

    }

    //后序遍历 b d ca f g e
    public static  void post_order(BiTreeNode root){
        if(root != null){
            post_order(root.getLchld());
            post_order(root.getRchld());
            System.out.println(root.getData());

        }

    }

    //层次遍历 e a g c f b d
    public static void  level_order(BiTreeNode root){


    }



}
