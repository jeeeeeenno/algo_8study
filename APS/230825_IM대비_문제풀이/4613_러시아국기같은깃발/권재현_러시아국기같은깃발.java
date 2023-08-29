package IM대비_문제풀이.러시아_국기_같은_깃발_4613;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt();
			char[][] map = new char[N][];
			for (int n = 0; n < N; n++) {
				map[n] = sc.next().toCharArray();
			}
			
			int minCnt = N * M;
			for (int i = 1; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int cnt = 0;
					for (int r = 0; r < i; r++) {
						for (int c = 0; c < M; c++) {
							if (map[r][c] != 'W') cnt++;
						}
					}
					for (int r = i; r < j; r++) {
						for (int c = 0; c < M; c++) {
							if (map[r][c] != 'B') cnt++;
						}
					}
					for (int r = j; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (map[r][c] != 'R') cnt++;
						}
					}
					
					if (cnt < minCnt) minCnt = cnt;
				}
			}
			
			System.out.println(String.format("#%d %d", t, minCnt));
			
		}
		
		sc.close();
	}

}