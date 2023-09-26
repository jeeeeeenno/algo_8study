package �̷�1;

import java.util.Scanner;

public class Solution {
	// ��, ��, ��, ��
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// �Է�
			scanner.next(); // �׽�Ʈ���̽� ��ȣ
			char[][] maze = new char[16][16]; // �̷�
			boolean[][] visit = new boolean[16][16]; // �湮 Ȯ��
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			for(int i = 0; i < 16; i++) { // �̷� ����
				maze[i] = scanner.next().toCharArray();
				for(int j = 0; j < 16; j++) {
					switch(maze[i][j]) {
					case '1': // ���� ���
						visit[i][j] = true;
						break;
					case '2': // ��� ��ġ
						visit[i][j] = true;
						startX = i;
						startY = j;
						break;
					case '3': // ���� ��ġ
						endX = i;
						endY = j;
						break;
					}
				}
			}
			// ���
			if(findGoal(visit, startX, startY, endX, endY)) System.out.printf("#%d 1\n", test);
			else System.out.printf("#%d 0\n", test);
		}
		scanner.close();
	}
	
	public static boolean findGoal(boolean[][] visit, int X, int Y, int endX, int endY) {
		boolean ans = false;
		if(X == endX && Y == endY) ans = true;
		else {
			for(int i = 0; i < 4; i++) { // ���� �ε���
				if(X+dx[i] >= 0 && X+dx[i] < 16 && Y+dy[i] >= 0 && Y+dy[i] < 16 && !visit[X+dx[i]][Y+dy[i]]) {
					visit[X+dx[i]][Y+dy[i]] = true;
					ans = findGoal(visit, X+dx[i], Y+dy[i], endX, endY);
					visit[X+dx[i]][Y+dy[i]] = false;
					if(ans) break;
				}
			}
		}
		return ans;
	}
}
