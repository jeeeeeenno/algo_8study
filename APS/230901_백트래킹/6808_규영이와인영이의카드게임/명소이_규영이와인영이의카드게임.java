package 규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int test = 1; test <= T; test++) {
			int total = 1;
			boolean[] cards = new boolean[19];
			int[] G = new int[9]; // 규영 카드
			int[] I = new int[9]; // 인영 카드
			// 입력
			for (int i = 0; i < 9; i++) {
				G[i] = scanner.nextInt();
				cards[G[i]] = true;
				total *= i + 1; // 9!
			}
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (cards[i] == false) {
					I[index++] = i;
				}
			}
			boolean[] visited = new boolean[9];
			// 계산
			int ans = cardCheck(G, I, visited, 0, 0, 0);
			// 출력
			System.out.printf("#%d %d %d\n", test, ans, total - ans);
		}
		scanner.close();
	}

	public static int cardCheck(int[] G, int[] I, boolean[] visited, int index, int total, int ans) {
		if (index == 9) {
			if (total > 85)
				ans++;
			return ans;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (G[index] > I[i]) {
					total += G[index] + I[i];
				}
				ans = cardCheck(G, I, visited, index + 1, total, ans);
				if (G[index] > I[i]) {
					total -= G[index] + I[i];
				}
				visited[i] = false;
			}
		}
		return ans;
	}
}
