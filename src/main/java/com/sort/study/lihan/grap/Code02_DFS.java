package com.sort.study.lihan.grap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
//记录的是当前深度优先的路径
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
//可以退回到当前节点的前一个节点
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}
	
	public static  void mydfs (Node node){
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		Node curNode;
		while (!set.isEmpty()){
			curNode = stack.pop();
			System.out.println(curNode.value);
			ArrayList<Node> nexts = curNode.nexts;
			for(Node temp : nexts){
				if(set.contains(temp)){
					continue;
				}
				set.add(temp);
				stack.add(temp);
			}

		}
	}
	

}
