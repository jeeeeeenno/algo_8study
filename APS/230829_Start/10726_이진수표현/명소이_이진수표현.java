package 이진수표현;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			 int N = scanner.nextInt();
			 int M = scanner.nextInt();
			 int com = 0;
			 int num = 0;
			 for(int i = 0; i < N; i++) {
				 num = num*2 + 1;
			 }
			 System.out.printf("#%d %s\n", test, (M&num) == num ? "ON" : "OFF");
		}
	}
}
