package com.sort.study.lihan.grap;

public class GraphGenerator {

	// matrix 所有的边
	// N*3 的矩阵
	// [weight, from节点上面的值，to节点上面的值]
	// 
	// [ 5 , 0 , 7]
	// [ 3 , 0,  1]
	// 
	public static Graph createGraph(int[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			 // 拿到每一条边， matrix[i] 
			int weight = matrix[i][0];
			int from = matrix[i][1];
			int to = matrix[i][2];
//如果没有这两个点
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
//总能拿出来
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);

			Edge newEdge = new Edge(weight, fromNode, toNode);
//起始节点的出度，nexts，和边
			fromNode.nexts.add(toNode);
			fromNode.out++;
			fromNode.edges.add(newEdge);
//终止节点的入度
			toNode.in++;
//图的边
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
