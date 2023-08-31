package 요리사;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner(new File("./src/요리사/sample_input (8).txt"));
		int T = scanner.nextInt();
		for (int test = 1; test <= T; test++) {
			// 입력
			int N = scanner.nextInt();
			int[][] S = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = scanner.nextInt();
				}
			}
			// 맛
			int minDiff = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << N); i++) {
				boolean[] ingr = new boolean[N]; // false
				if (Integer.bitCount(i) == N / 2) {
					for (int j = 0; j < N; j++) {
						if ((i & (1 << j)) > 0) {
							ingr[j] = true;
						}
					}
					// ture인 재료로 만든 음식 맛
					int foodA = 0;
					int foodB = 0;
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < N; c++) {
							if (ingr[r] && ingr[c]) {
								foodA += S[r][c];
							}
							if (!ingr[r] && !ingr[c]) {
								foodB += S[r][c];
							}
						}
					}
					// 맛의 차이가 최소이면 저장
					minDiff = Math.min(minDiff, Math.abs(foodA - foodB));
				}
			}
			// 출력
			System.out.printf("#%d %d\n", test, minDiff);
		}
		scanner.close();
	}
}
