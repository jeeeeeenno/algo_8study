package check;

import java.util.Scanner;

public class ����_�ֻ���������_14499 {
	public static int n;
	public static int m;
	public static int x;
	public static int y;
	public static int k;

	// �� �� �� �� --> 1 2 3 4
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { 1, -1, 0, 0 };

	// �ֻ���
	public static int[] dice = { 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// map�� ���� ũ�� n ����ũ�� m
		n = sc.nextInt();
		m = sc.nextInt();
		// map �ֻ��� ��ǥ x y
		x = sc.nextInt();
		y = sc.nextInt();

		// ����� ���� k
		k = sc.nextInt();

		// map �迭
		int[][] map = new int[n][m];

		// map�� input �ֱ�
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map[r][c] = sc.nextInt();
			}
		} // for rc

		
		for (int i = 0; i < k; i++) {
			// dx dy index�� 0 1 2 3 �̴ϱ�.
			int dir = sc.nextInt() - 1;
			x = x + dx[dir];
			y = y + dy[dir];

			// ���� ����
			if (x < 0 || x >= n || y < 0 || y >= m) {
				x -= dx[dir];
				y -= dy[dir];
				continue;
			}

			// ���� �����?
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
			// map �� 0 �̸� �ٴڸ� ����
			if (map[x][y] == 0) {
				map[x][y] = dice[1];

				// map �� 0 �ƴϸ� �ٴڸ� ������ ����
				// map �� = 0 ����
			} else {
				dice[1] = map[x][y];
				map[x][y] = 0;
			}

			System.out.println(dice[0]);
		} // for i

	}// main

	public static void East() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int tmp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = tmp;
	}

	public static void West() {
		// �� -> �� -> �� -> �� -> ��
		int tmp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = tmp;
	}

	public static void North() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int tmp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = tmp;
	}

	public static void South() {
		// �� -> �� -> �ٴ� -> �� -> ��
		int tmp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = tmp;
	}
}
