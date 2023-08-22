import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int ans = 0;
			int[] sum = new int[N+M+1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					sum[i+j]++;
					ans = ans > sum[i+j] ? ans : sum[i+j];
				}
			}
			System.out.printf("#%d ", test);
			for(int i = 1; i <= N+M; i++) {
				if(sum[i] == ans) {
					System.out.printf("%d ", i);
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}
