package °ÅµìÁ¦°ö;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// ÀÔ·Â
			scanner.next();
			int N = scanner.nextInt(); // ÀÇ
			int M = scanner.nextInt(); // Á¦°ö
			// °è»ê
			int ans = 0;
			ans = pow(N, M);
			// Ãâ·Â
			System.out.printf("#%d %d\n", test, ans);
		}
		scanner.close();
	}
	
	public static int pow(int N, int M) {
		if(M == 0) return 1;
		return N * pow(N, M-1);
	}
}
