package Queue.준홍이의_카드놀이_7102;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t);
			int d = Math.abs(N - M);
			int l = Math.max(N,  M);
			for (int i = d; i >= 0; i--) {
				sb.append(" " + (l + 1 - i));
			}
			System.out.println(sb);
			
		}
		
		sc.close();
	}

}