package 부분수열의합;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			int[] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = scanner.nextInt();
			}
			// 경우의 수 찾기
			int count = 0;
			for(int i = 0; i < (1<<nums.length); i++) {
				int sum = 0;
				for(int j = 0; j < nums.length; j++) {
					if((i & (1<<j)) > 0) {
						sum += nums[j];
					}
				}
				if(sum==K) {
					count++;
				}
			}
			// 출력
			System.out.printf("#%d %d\n", test, count);
		}
		scanner.close();
	}
}
