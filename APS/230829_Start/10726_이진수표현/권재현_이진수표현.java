package start.이진수_표현_10726;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt(), M = sc.nextInt();
			String ans = "";
			if (((M - (Math.pow(2, N) - 1)) % Math.pow(2,  N)) == 0) ans = "ON";
			else ans = "OFF";
			System.out.println(String.format("#%d %s", tc, ans));
		}
		
		sc.close();
	}

}