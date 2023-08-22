package Stack2.거듭_제곱_1217;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			sc.nextInt();
			int N = sc.nextInt(), M = sc.nextInt();
			int ans = pow(N, M);
			System.out.println(String.format("#%d %d", t, ans));
		}
		
		sc.close();
	}
	
	public static int pow(int n, int m) {
		if (m == 1) {
			return n;
		}
		return n * pow(n, m - 1);
	}
	
	
	public static String input = "1\r\n" + 
			"9 8\r\n" + 
			"2\r\n" + 
			"2 8\r\n" + 
			"3\r\n" + 
			"6 5\r\n" + 
			"4\r\n" + 
			"10 7\r\n" + 
			"5\r\n" + 
			"6 7\r\n" + 
			"6\r\n" + 
			"7 2\r\n" + 
			"7\r\n" + 
			"9 8\r\n" + 
			"8\r\n" + 
			"3 2\r\n" + 
			"9\r\n" + 
			"4 8\r\n" + 
			"10\r\n" + 
			"8 6";

}
