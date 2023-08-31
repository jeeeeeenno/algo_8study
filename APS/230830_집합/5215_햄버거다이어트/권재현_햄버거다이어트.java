package 집합.햄버거_다이어트_5215;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), L = sc.nextInt();
			int[][] ingr = new int[N][2];
			for (int n = 0; n < N; n++) {
				ingr[n][0] = sc.nextInt();
				ingr[n][1] = sc.nextInt();
			}
			
			int scoreSum;
			int calSum;
			int maxScore = 0;
			for (int i = 0; i < (1 << N); i++) {
				scoreSum = 0;
				calSum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						scoreSum += ingr[j][0];
						calSum += ingr[j][1];
					}
				}
				if (calSum <= L && maxScore < scoreSum) maxScore = scoreSum; 
			}
			
			
			System.out.println(String.format("#%d %d", t, maxScore));
		}
		
		sc.close();
	}
}