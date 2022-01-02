package com.sort.study.lihan.tree.bitree;

import com.sort.study.lihan.utils.Utils;
import lombok.val;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lihan
 * @Date : 2022/1/2- 01
 * @DESCRIPTION: com.sort.study.lihan.tree.bitree
 * @version: 1.0
 */
public class TestSerial {
    public static void main(String[] args) {

        BiTreeNode root = Utils.serialGenrateBiTreeNode();
        Queue<String> result = preSerial(root);
        System.out.println(result);
        BiTreeNode newRoot = zcpreSerial(result);
        System.out.println("运行结束");
    }

    public static Queue<String> preSerial(BiTreeNode root){
        Queue<String> queue = new LinkedList<>();
        pre(root,queue);
        return queue;
    }

    public static void pre(BiTreeNode root, Queue<String>queue){
        if(root == null){
            queue.add(null);
            return;
        }
        queue.add(String.valueOf(root.getData()));

        pre(root.getLchld(),queue);
        pre(root.getRchld(),queue);

    }

    public static BiTreeNode buildByPre(Queue<String> queue){
        if(queue == null || queue.isEmpty()){
            return null;
        }
        BiTreeNode root = new BiTreeNode();
        String val = queue.poll();
        if(val == null){
            return null;
        }
        root.setData(val.charAt(0));
        doBuildPre(root,queue,false);
        return root;
    }
    /**
     * @Description
     * @Author lihan
     * @Date 2022/1/2
     * @Param root 当前子树的根节点
     *  @Param flag 表示是否填充右子树
 * @param queue
     * @return void
     **/
    public static void doBuildPre(BiTreeNode root,Queue<String> queue, boolean flag){
        if (queue.isEmpty()){
            return;
        }
        String val = queue.poll();
        //表示下一次是否填充右子树
        if(val == null){
            doBuildPre(root,queue,true);
        }else{
            BiTreeNode  node = new BiTreeNode();
            node.setData(val.charAt(0));
            if(flag){
                root.setRchld(node);
            }else {
                root.setLchld(node);
            }
            doBuildPre(node,queue,false);

        }

    }

    public static BiTreeNode zcpreSerial(Queue<String> queue){
        if(queue== null || queue.isEmpty()){
            return null;
        }
        BiTreeNode root = zcDoPreSerial(queue);
        return root;
    }

    public static BiTreeNode zcDoPreSerial(Queue<String> queue){
        String val = queue.poll();
        if (val == null){
            return null;
        }
        BiTreeNode root = new BiTreeNode();
        root.setData(val.charAt(0));

       root.setLchld(zcDoPreSerial(queue));
        root.setRchld(zcDoPreSerial(queue));
        return root;
    }
}
