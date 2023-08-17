package 거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			scanner.next(); // 테스트 번호 버림
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int ans = power(N, M-1);
			System.out.printf("#%d %d\n", test, ans);
		}
		scanner.close();
	}
	
	public static int power(int n, int m) {
		if(m != 0) {
			n *= power(n, m-1);
		}
		return n;
	}
}
