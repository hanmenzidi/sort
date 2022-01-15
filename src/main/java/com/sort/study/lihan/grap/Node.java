package com.sort.study.lihan.grap;


import java.util.ArrayList;

// 点结构的描述
public class Node {
	public int value; //点名
	public int in; // 入度
	public int out; //出度
	public ArrayList<Node> nexts;  //直接邻居，以当前节点出去的
	public ArrayList<Edge> edges; //从他出发的边

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
