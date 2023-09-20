package 그래프의삼각형;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // 테스트 케이스 개수
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = scanner.nextInt(); // 정점 개수
			int M = scanner.nextInt(); // 간선 개수
			int[][] arr = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				int x = scanner.nextInt(); // 첫 번째 정점
				int y = scanner.nextInt(); // 두 번째 정점
				arr[x][y] = 1;
				arr[y][x] = 1;
			}
			// 삼각형 개수 구하기
			int count = 0;
			for(int i = 1; i <= N; i++) { // 시작
				for(int j = i+1; j <= N; j++) { // 다음
					if(arr[i][j] == 0) continue;
					for(int k = j+1; k <= N; k++) {
						if(arr[j][k] == 0) continue;
						if(arr[k][i] == 1) count++;
					}
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", test, count);
		}
	}
}