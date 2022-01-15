package com.sort.study.lihan.dabiao;

public class Code02_EatGrass {

	// 如果n份草，最终先手赢，返回"先手"
	// 如果n份草，最终后手赢，返回"后手"
	public static String whoWin(int n) {
		if (n < 5) {
			return n == 0 || n == 2 ? "后手" : "先手";
		}
		// 进到这个过程里来，当前的先手，先选
		int want = 1;
		while (want <= n) {
			if (whoWin(n - want).equals("后手")) {
				return "先手";
			}
			if (want <= (n / 4)) {
				want *= 4;
			} else {
				break;
			}
		}
		return "后手";
	}

	public static String winner1(int n) {
		if (n < 5) {
			return (n == 0 || n == 2) ? "后手" : "先手";
		}
// n》=5是，当前先手决定吃的草
		int base = 1;
//当前是先手在选
		while (base <= n) {
//当前一共n份，先手吃掉n份，n-base份留给后手，
//母过程先手在子过程是后手
			if (winner1(n - base).equals("后手")) {
				return "先手";
			}
			if (base > n / 4) { // 防止base*4之后溢出，也就说下面不用尝试了
				break;
			}
			base *= 4; //1,4,16，一依次去尝试
		}
		return "后手";
	}

	public static String winner2(int n) {
		if (n % 5 == 0 || n % 5 == 2) {
			return "后手";
		} else {
			return "先手";
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 50; i++) {
			System.out.println(i + " : " + winner1(i));
		}
	}

}
