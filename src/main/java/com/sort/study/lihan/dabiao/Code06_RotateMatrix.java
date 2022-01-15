package com.sort.study.lihan.dabiao;

public class Code06_RotateMatrix {

	public static void rotate(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;
		while (a < c) {
			rotateEdge(matrix, a++, b++, c--, d--);
		}
	}

	public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
		int tmp = 0;
//如果一行4个元素，第一组消耗2个，剩下的每组消耗1个
//当前小组的第一个元素[a][b+i]  第二个元素[a+i][d]  第三个元素[c][d-i] 第四个元素[c-i][b]
		for (int i = 0; i < d - b; i++) {
			tmp = m[a][b + i];
			m[a][b + i] = m[c - i][b];
			m[c - i][b] = m[c][d - i];
			m[c][d - i] = m[a + i][d];
			m[a + i][d] = tmp;
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}

}
