package 미로1;

import java.util.Scanner;

public class Solution {
	// 오, 하, 좌, 상
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// 입력
			scanner.next(); // 테스트케이스 번호
			char[][] maze = new char[16][16]; // 미로
			boolean[][] visit = new boolean[16][16]; // 방문 확인
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			for(int i = 0; i < 16; i++) { // 미로 정보
				maze[i] = scanner.next().toCharArray();
				for(int j = 0; j < 16; j++) {
					switch(maze[i][j]) {
					case '1': // 벽인 경우
						visit[i][j] = true;
						break;
					case '2': // 출발 위치
						visit[i][j] = true;
						startX = i;
						startY = j;
						break;
					case '3': // 도착 위치
						endX = i;
						endY = j;
						break;
					}
				}
			}
			// 출력
			if(findGoal(visit, startX, startY, endX, endY)) System.out.printf("#%d 1\n", test);
			else System.out.printf("#%d 0\n", test);
		}
		scanner.close();
	}
	
	public static boolean findGoal(boolean[][] visit, int X, int Y, int endX, int endY) {
		boolean ans = false;
		if(X == endX && Y == endY) ans = true;
		else {
			for(int i = 0; i < 4; i++) { // 방향 인덱스
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
