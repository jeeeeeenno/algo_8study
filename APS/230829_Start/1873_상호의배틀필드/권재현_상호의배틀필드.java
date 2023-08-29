package start.상호의_배틀필드_1873;

import java.util.Scanner;

class Tank {
	int r;
	int c;
	char dir;
}

class Map {
	char[][] map;
	Map() {	}
	Map(int H, int W) {
		this.map = new char[H][W];
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt(), W = sc.nextInt();
			Map map = new Map(H, W);
			for (int h = 0; h < H; h++) {
				map.map[h] = sc.next().toCharArray();
			}

			Tank tank = new Tank();
			pos: for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					tank.r = h;
					tank.c = w;
					switch (map.map[h][w]) {
					case '^':
						tank.dir = 'U';
						break pos;
					case 'v':
						tank.dir = 'D';
						break pos;
					case '<':
						tank.dir = 'L';
						break pos;
					case '>':
						tank.dir = 'R';
						break pos;
					}
				}
			}

			int N = sc.nextInt();
			String cmd = sc.next();
			for (int i = 0; i < N; i++) {
				char c = cmd.charAt(i);
				if (c == 'S')
					shoot(tank.r, tank.c, tank.dir, map);
				else {
					move(tank.r, tank.c, c, map, tank);
					tank.dir = c;
				}
				
			}
			System.out.printf("#%d ", t);
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					System.out.print(map.map[h][w]);
				}
				System.out.println();
			}
		}
		sc.close();
	}

	static void move(int r, int c, char dir, Map map, Tank tank) {
		switch (dir) {
		case 'U':
			if (0 <= r - 1 && map.map[r - 1][c] == '.') {
				map.map[r - 1][c] = '^';
				map.map[r][c] = '.';
				tank.r = r - 1;

			} else
				map.map[r][c] = '^';
			break;
		case 'D':
			if (r + 1 < map.map.length && map.map[r + 1][c] == '.') {
				map.map[r + 1][c] = 'v';
				map.map[r][c] = '.';
				tank.r = r + 1;
			} else
				map.map[r][c] = 'v';
			break;
		case 'L':
			if (0 <= c - 1 && map.map[r][c - 1] == '.') {
				map.map[r][c - 1] = '<';
				map.map[r][c] = '.';
				tank.c = c - 1;
			} else
				map.map[r][c] = '<';
			break;
		case 'R':
			if (c + 1 < map.map[0].length && map.map[r][c + 1] == '.') {
				map.map[r][c + 1] = '>';
				map.map[r][c] = '.';
				tank.c = c + 1;
			} else
				map.map[r][c] = '>';
			break;
		}

	}

	static void shoot(int r, int c, char dir, Map map) {
		int nr;
		int nc;
		switch (dir) {
		case 'U':
			nr = r - 1;
			while (0 <= nr) {
				if (map.map[nr][c] == '*') {
					map.map[nr][c] = '.';
					break;
				} else if (map.map[nr][c] == '#')
					break;
				nr--;
			}
			break;
		case 'D':
			nr = r + 1;
			while (nr < map.map.length) {
				if (map.map[nr][c] == '*') {
					map.map[nr][c] = '.';
					break;
				} else if (map.map[nr][c] == '#')
					break;
				nr++;
			}
			break;
		case 'L':
			nc = c - 1;
			while (0 <= nc) {
				if (map.map[r][nc] == '*') {
					map.map[r][nc] = '.';
					break;
				} else if (map.map[r][nc] == '#')
					break;
				nc--;
			}
			break;
		case 'R':
			nc = c + 1;
			while (nc < map.map[0].length) {
				if (map.map[r][nc] == '*') {
					map.map[r][nc] = '.';
					break;
				} else if (map.map[r][nc] == '#')
					break;
				nc++;
			}
			break;
		}
	}

}