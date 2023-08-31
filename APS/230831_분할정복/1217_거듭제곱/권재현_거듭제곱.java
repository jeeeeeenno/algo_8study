package 분할정복.거듭_제곱_1217;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			t = sc.nextInt();
			int N = sc.nextInt(), M = sc.nextInt();
			System.out.println(String.format("#%d %d", t, power(N, M)));
		}
		
		sc.close();
	}
	
	public static int power(int x, int y) {
		if (y == 1) return x;
		else if (y % 2 == 0) {
			x = power(x, y / 2);
			return x * x;
		}
		else {
			int z = power(x, (y - 1) / 2);
			return z * z * x;
		}
	}

}