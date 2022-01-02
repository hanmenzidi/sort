package com.sort.study.lihan.tree;

import com.sort.study.lihan.tree.AVLNode;

/**
 * @Author: lihan
 * @Date : 2021/12/14- 12
 * @DESCRIPTION: com.sort.study.lihan
 * @version: 1.0
 */
public class AVLTree {
    public AVLTree(int[] arr){

    }

  public AVLNode rotat_left(AVLNode root, AVLNode p, AVLNode c){
        AVLNode lChild4c = c.lChild;
        p.rChild = lChild4c;
        if(lChild4c != null){
            lChild4c.parent  = p;
        }

        AVLNode p4p = p.parent;
        p.parent = c;
        c.parent = p4p;
        c.lChild = p;
        if(p4p != null){
            p4p.rChild = c;
        }
        p.bf =0;
        c.bf =0;

        return root;
  }
  public AVLNode rotat_right(AVLNode root, AVLNode p, AVLNode c){
      AVLNode rChild4c = c.rChild;
      p.lChild = rChild4c;
      if(rChild4c != null){
          rChild4c.parent = p;
      }
      c.rChild = p;
      AVLNode p4p = p.parent;
      p.parent = c;
      c.parent = p4p;
      if(p4p != null){
          p4p.lChild = c;
      }
      p.bf = 0;
      c.bf =0;
      return root;
  }
}
