package ��ȣ�ǹ�Ʋ�ʵ�;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/��ȣ�ǹ�Ʋ�ʵ�/input (23).txt"));
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// �Է�
			int H = scanner.nextInt(); // ���� ����
			int W = scanner.nextInt(); // ���� �ʺ�
			char[][] map = new char[H][W]; // ��
			int x = 0;
			int y = 0;
			for(int i = 0; i < H; i++) {
				map[i] = scanner.next().toCharArray();
				for(int j = 0; j < W; j++) {
					// ������ ��ġ
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}
			int N = scanner.nextInt(); // �Է��� ����
			char[] command = scanner.next().toCharArray(); // ���
			// ����
			for(int c = 0; c < N; c++) {
				switch(command[c]) {
				case 'U': // ���� ���� ���� -> ������ �̵�
					if(x-1 >= 0 && map[x-1][y] == '.') {
						map[x][y] = '.';
						x--;
					}
					map[x][y] = '^';
					break;
				case 'D': // ���� �Ʒ��� ���� -> ������ �̵�
					if(x+1 < H && map[x+1][y] == '.') {
						map[x][y] = '.';
						x++;
					}
					map[x][y] = 'v';
					break;
				case 'L': // ���� �������� ���� -> ������ �̵�
					if(y-1 >= 0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						y--;
					}
					map[x][y] = '<';
					break;
				case 'R': // ���� ���������� ���� -> ������ �̵�
					if(y+1 < W && map[x][y+1] == '.') {
						map[x][y] = '.';
						y++;
					}
					map[x][y] = '>';
					break;
				case 'S': // �ٶ󺸴� �������� �߻�
					switch(map[x][y]) {
					case '^': // ���� (x--)
						for(int i = 1; i <= x; i++) {
							if(map[x-i][y]=='*') {
								map[x-i][y] = '.';
								break;
							}else if(map[x-i][y]=='#') {
								break;
							}
						}
						break;
					case 'v': // �Ʒ��� (x++)
						for(int i = 1; i < H-x; i++) {
							if(map[x+i][y]=='*') {
								map[x+i][y] = '.';
								break;
							}else if(map[x+i][y]=='#') {
								break;
							}
						}
						break;
					case '<': // �������� (y--)
						for(int i = 1; i <= y; i++) {
							if(map[x][y-i]=='*') {
								map[x][y-i] = '.';
								break;
							}else if(map[x][y-i]=='#') {
								break;
							}
						}
						break;
					case '>': // ���������� (y++)
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
			// ���
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
