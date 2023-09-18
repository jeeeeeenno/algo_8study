package �׷����ǻﰢ��;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // �׽�Ʈ ���̽� ����
		for(int test = 1; test <= T; test++) {
			// �Է�
			int N = scanner.nextInt(); // ���� ����
			int M = scanner.nextInt(); // ���� ����
			int[][] arr = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				int x = scanner.nextInt(); // ù ��° ����
				int y = scanner.nextInt(); // �� ��° ����
				arr[x][y] = 1;
				arr[y][x] = 1;
			}
			// �ﰢ�� ���� ���ϱ�
			int count = 0;
			for(int i = 1; i <= N; i++) { // ����
				for(int j = i+1; j <= N; j++) { // ����
					if(arr[i][j] == 0) continue;
					for(int k = j+1; k <= N; k++) {
						if(arr[j][k] == 0) continue;
						if(arr[k][i] == 1) count++;
					}
				}
			}
			
			// ���
			System.out.printf("#%d %d\n", test, count);
		}
	}
}