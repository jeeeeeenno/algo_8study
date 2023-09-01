package NQueen;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = scanner.nextInt();
			boolean[][] board = new boolean[N][N];
			// 경우의 수 찾기
			int ans = putQueen(board, N, 0, 0);
			// 출력
			System.out.printf("#%d %d\n", test, ans);
		}
		scanner.close();
	}
	
	public static int putQueen(boolean[][] board, int N, int level, int ans) {
		if(level == N) {
			return 1;
		}
		int total = 0;
		for(int i = 0; i < N; i++) {
			if(checkQueen(board, N, level, i)) continue;
			board[level][i] = true;
			total += putQueen(board, N, level+1, ans);
			board[level][i] = false;
		}
		return total;
	}
	
	public static boolean checkQueen(boolean[][] board, int N, int x, int y) {
		for(int l = 1; l <= x; l++) {
			if((board[x-l][y] == true) || (y-l >= 0 && board[x-l][y-l] == true) || (y+l < N && board[x-l][y+l] == true)) return true;
		}
		return false;
	}
}
