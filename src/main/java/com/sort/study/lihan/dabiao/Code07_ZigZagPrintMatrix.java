package com.sort.study.lihan.dabiao;

public class Code07_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int Ar = 0; //a的行号
		int Ac = 0; //a的列号
		int Br = 0;
		int Bc = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false; //是不是从右上往走下打印
		while (Ar != endR + 1) {
			printLevel(matrix, Ar, Ac, Br, Bc, fromUp);
//顺序不能换，因为Ar依赖当前Ac
			Ar = Ac == endC ? Ar + 1 : Ar; //a没到最后一列，右移
			Ac = Ac == endC ? Ac : Ac + 1;
//同上
			Bc = Br == endR ? Bc + 1 : Bc;//b没到最后一行，下移
			Br = Br == endR ? Br : Br + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
