package Queue1.퍼펙트_셔플_3499;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] deck = new String[N];
			for (int i = 0; i < N; i++) {
				deck[i] = sc.next();
			}
			System.out.printf("#%d ", t);
			int half = (N + 1) / 2;
			for (int j = 0; j < half; j++) {
				System.out.printf("%s ", deck[j]);
				if (half + j < N) System.out.printf("%s ", deck[half + j]);
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static String input = "\r\n" + 
			"3\r\n" + 
			"6\r\n" + 
			"A B C D E F\r\n" + 
			"4\r\n" + 
			"JACK QUEEN KING ACE\r\n" + 
			"5\r\n" + 
			"ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";

}
