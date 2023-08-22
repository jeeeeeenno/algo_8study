package Queue2.진기의_최고급_붕어빵_1860;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
			int bun = 0;
			boolean flag = true;
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for (int i = 0; i < N; i++) {
				int sec = arr[i];
				bun = ((Integer) (sec / M)) * K - i;
				if (bun < 1) {
					flag = false;
					break;
				}				
			}
			
			String flagStr = "";
			if (flag) flagStr = "P";
			else flagStr = "Imp";
			String ans = "ossible";
			System.out.println(String.format("#%d %s%s", t, flagStr , ans));
		}
		sc.close();
	}
	
}