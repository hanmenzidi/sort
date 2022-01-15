package com.sort.study.lihan.bingchaset;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code05_UnionFind {

	public static class Node<V> {
		V value;

		public Node(V v) {
			value = v;
		}
	}

	public static class UnionFind<V> {
		//v -》 节点
		public HashMap<V, Node<V>> nodes;
		//节点的父节点
		public HashMap<Node<V>, Node<V>> parents;
		//只有一个点是代表点的情况下，才会有记录
		public HashMap<Node<V>, Integer> sizeMap;
//初始化过程
		public UnionFind(List<V> values) {
			nodes = new HashMap<>();
			parents = new HashMap<>();
			sizeMap = new HashMap<>();
			for (V cur : values) {
				Node<V> node = new Node<>(cur);
				nodes.put(cur, node);//包装
				parents.put(node, node);//刚开始父节点是自己
				sizeMap.put(node, 1);
			}
		}
//算法的瓶颈
		// 给你一个节点，请你往上到不能再往上，把代表返回
		public Node<V> findFather(Node<V> cur) {
			Stack<Node<V>> path = new Stack<>();
//把沿途路径记录下来，最后沿途路径直接指向代表点
			while (cur != parents.get(cur)) {
				path.push(cur);
				cur = parents.get(cur);
			}
//链扁平化，进行优化
			while (!path.isEmpty()) {
				parents.put(path.pop(), cur);
			}
			return cur;
		}

		public boolean isSameSet(V a, V b) {
			if(!nodes.containsKey(a) || !nodes.containsKey(b)){
				return false;
			}
			return findFather(nodes.get(a)) == findFather(nodes.get(b));
		}

		public void union(V a, V b) {
			if(!nodes.containsKey(a) || !nodes.containsKey(b)){
				return ;
			}
			Node<V> aHead = findFather(nodes.get(a));
			Node<V> bHead = findFather(nodes.get(b));
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
				Node<V> small = big == aHead ? bHead : aHead;
				parents.put(small, big);//小集合把父亲改为ahead
				sizeMap.put(big, aSetSize + bSetSize);
				sizeMap.remove(small);
			}
		}

		public int sets() {
			return sizeMap.size();
		}

	}
}
