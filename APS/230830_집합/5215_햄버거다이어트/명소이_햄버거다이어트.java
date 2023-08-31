package 햄버거다이어트;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = scanner.nextInt(); // 재료의 수
			int L = scanner.nextInt(); // 제한 칼로리
			int[] cal = new int[N];
			int[] score = new int[N];
			for (int i = 0; i < N; i++) {
				score[i] = scanner.nextInt();
				cal[i] = scanner.nextInt();
			}
			int ans = 0;
			for (int i = 0; i < (1 << N); i++) {
				int totalCal = 0;
				int totalScore = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						totalCal += cal[j];
						totalScore += score[j];
					}
				}
				if (totalCal <= L) {
					ans = ans > totalScore ? ans : totalScore;
				}
			}
			System.out.printf("#%d %d\n", test, ans);
		}
		scanner.close();
	}
}
