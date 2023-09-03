package 백트래킹.N_Queen_2806;

import java.util.Scanner;

public class Solution {
	public static int N;
	public static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ans = 0;
			int[] pos = new int[N];
			recur(0, pos);
			
			System.out.println(String.format("#%d %d", t, ans));
			
		}
		
		sc.close();
	}
	
	public static void recur(int r, int[] pos) {
		if (r == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (check(r, i, pos)) {
				pos[r] = i;
				recur(r + 1, pos);
			}
		}
		return;
	}
	
	public static boolean check(int r, int c, int[] pos) {
		for (int i = 0; i < r; i++) {
			if(pos[i] == c || i - r == pos[i] - c || i - r == c - pos[i])
				return false;
		}
		return true;
	}

}