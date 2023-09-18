package Graph.그래프의_삼각형_6057;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt();
			int[][] graph = new int[N + 1][N + 1];
			for (int m = 0; m < M; m++) {
				int x = sc.nextInt(), y = sc.nextInt();
				graph[x][y] = graph[y][x] = 1;
			}
			int cnt = 0;
			for (int i = 1; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k <= N; k++) {
						if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] ==1) {
							cnt++;
						}
					}
				}
			}
			System.out.println(String.format("#%d %d", t, cnt));
		
		}
		
		sc.close();
	}

}
