package check;

import java.util.Scanner;

public class 백준_주사위굴리기_14499 {
	public static int n;
	public static int m;
	public static int x;
	public static int y;
	public static int k;

	// 동 서 북 남 --> 1 2 3 4
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { 1, -1, 0, 0 };

	// 주사위
	public static int[] dice = { 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// map의 세로 크기 n 가로크기 m
		n = sc.nextInt();
		m = sc.nextInt();
		// map 주사위 좌표 x y
		x = sc.nextInt();
		y = sc.nextInt();

		// 명령의 개수 k
		k = sc.nextInt();

		// map 배열
		int[][] map = new int[n][m];

		// map에 input 넣기
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map[r][c] = sc.nextInt();
			}
		} // for rc

		
		for (int i = 0; i < k; i++) {
			// dx dy index가 0 1 2 3 이니까.
			int dir = sc.nextInt() - 1;
			x = x + dx[dir];
			y = y + dy[dir];

			// 조건 충족
			if (x < 0 || x >= n || y < 0 || y >= m) {
				x -= dx[dir];
				y -= dy[dir];
				continue;
			}

			// 어디로 갈까요?
			switch (dir) {
			case 0:
				East();
				break;
			case 1:
				West();
				break;
			case 2:
				North();
				break;

			case 3:
				South();
				break;
			}

			// Bottom COPY
			// map 값 0 이면 바닥면 복사
			if (map[x][y] == 0) {
				map[x][y] = dice[1];

				// map 값 0 아니면 바닥면 지도값 복사
				// map 값 = 0 복사
			} else {
				dice[1] = map[x][y];
				map[x][y] = 0;
			}

			System.out.println(dice[0]);
		} // for i

	}// main

	public static void East() {
		// 위 -> 오 -> 바닥 -> 왼 -> 위
		int tmp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = tmp;
	}

	public static void West() {
		// 위 -> 왼 -> 바 -> 오 -> 위
		int tmp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = tmp;
	}

	public static void North() {
		// 위 -> 뒤 -> 바닥 -> 앞 -> 위
		int tmp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = tmp;
	}

	public static void South() {
		// 위 -> 앞 -> 바닥 -> 뒤 -> 위
		int tmp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = tmp;
	}
}
