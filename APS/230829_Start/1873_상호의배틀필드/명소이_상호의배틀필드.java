package 상호의배틀필드;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/상호의배틀필드/input (23).txt"));
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int H = scanner.nextInt(); // 맵의 높이
			int W = scanner.nextInt(); // 맵의 너비
			char[][] map = new char[H][W]; // 맵
			int x = 0;
			int y = 0;
			for(int i = 0; i < H; i++) {
				map[i] = scanner.next().toCharArray();
				for(int j = 0; j < W; j++) {
					// 전차의 위치
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}
			int N = scanner.nextInt(); // 입력의 개수
			char[] command = scanner.next().toCharArray(); // 명령
			// 수행
			for(int c = 0; c < N; c++) {
				switch(command[c]) {
				case 'U': // 방향 위로 변경 -> 평지면 이동
					if(x-1 >= 0 && map[x-1][y] == '.') {
						map[x][y] = '.';
						x--;
					}
					map[x][y] = '^';
					break;
				case 'D': // 방향 아래로 변경 -> 평지면 이동
					if(x+1 < H && map[x+1][y] == '.') {
						map[x][y] = '.';
						x++;
					}
					map[x][y] = 'v';
					break;
				case 'L': // 방향 왼쪽으로 변경 -> 평지면 이동
					if(y-1 >= 0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						y--;
					}
					map[x][y] = '<';
					break;
				case 'R': // 방향 오른쪽으로 변경 -> 평지면 이동
					if(y+1 < W && map[x][y+1] == '.') {
						map[x][y] = '.';
						y++;
					}
					map[x][y] = '>';
					break;
				case 'S': // 바라보는 방향으로 발사
					switch(map[x][y]) {
					case '^': // 위로 (x--)
						for(int i = 1; i <= x; i++) {
							if(map[x-i][y]=='*') {
								map[x-i][y] = '.';
								break;
							}else if(map[x-i][y]=='#') {
								break;
							}
						}
						break;
					case 'v': // 아래로 (x++)
						for(int i = 1; i < H-x; i++) {
							if(map[x+i][y]=='*') {
								map[x+i][y] = '.';
								break;
							}else if(map[x+i][y]=='#') {
								break;
							}
						}
						break;
					case '<': // 왼쪽으로 (y--)
						for(int i = 1; i <= y; i++) {
							if(map[x][y-i]=='*') {
								map[x][y-i] = '.';
								break;
							}else if(map[x][y-i]=='#') {
								break;
							}
						}
						break;
					case '>': // 오른쪽으로 (y++)
						for(int i = 1; i < W-y; i++) {
							if(map[x][y+i]=='*') {
								map[x][y+i] = '.';
								break;
							}else if(map[x][y+i]=='#') {
								break;
							}
						}
						break;
					}
					break;
				}
			}
			// 출력
			System.out.printf("#%d ", test);
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.printf("%c", map[i][j]);
				}
				System.out.println();
			}
		}
		scanner.close();
	}
}
