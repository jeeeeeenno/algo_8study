package ������;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // �׽�Ʈ ���̽� ��
		for(int test = 1; test <= T; test++) {
			// �Է�
			int N = scanner.nextInt(); // ������ ����
			int M = scanner.nextInt(); // ������ ����
			int[][] arr = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				arr[x][y] = 1;
				arr[y][x] = 1;
			}
			// ��� ���� Ž��
			int maxRoute= 0;
			int[] ans = new int[N+1];
			for(int i = 1; i <= N; i++) {
				// ���� ���� �� ��� ���� Ž��
				int[] visited = new int[N+1];
				visited[i] = 1;
				ans[i] = routeSearch(arr,visited, ans[i], i, 1);
				maxRoute = maxRoute > ans[i] ? maxRoute : ans[i];
			}
			// ���
			System.out.printf("#%d %d\n", test, maxRoute);
		}
	}
	
	// ��� Ž���ϱ�
	public static int routeSearch(int[][] arr, int[] vis, int cnt, int V, int lev) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[V][i] == 1 && vis[i] == 0) {
				vis[i] = 1;
				cnt = routeSearch(arr, vis, cnt, i, lev+1);
				vis[i] = 0;
			}
		}
		cnt = cnt > lev ? cnt : lev;
		return cnt;
	}
}
