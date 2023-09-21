package 서로소집합;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // 테스트 케이스 개수
		for (int test = 1; test <= T; test++) {
			int N = scanner.nextInt(); // 집합의 개수
			int M = scanner.nextInt(); // 연산의 개수
			int[] sets = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				sets[i] = i; // 집합 연결 관계 초기화
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				int c = scanner.nextInt(); // 연산 종류
				int a = scanner.nextInt(); // 원소1
				int b = scanner.nextInt(); // 원소2
				switch (c) {
				case 0: // 결합
					union(sets, a, b);
					break;
				case 1: // 포함 여부 확인
					sb.append(isContain(sets, a, b));
					break;
				}
			}
			System.out.printf("#%d %s\n", test, sb);
		}
		scanner.close();
	}

	public static void union(int[] sets, int a, int b) {
		int aP = findSet(sets, a);
		int bP = findSet(sets, b);
		if (aP < bP) {
			sets[bP] = aP;
		} else {
			sets[aP] = bP;
		}
	}

	public static int isContain(int[] sets, int a, int b) {
		if (sets[findSet(sets, a)] == sets[findSet(sets, b)])
			return 1; // 같은 집합에 속해있는 경우
		else
			return 0;// 같은 집합에 속해있지 않은 경우
	}

	public static int findSet(int[] sets, int a) {
		if (sets[a] != a) {
			sets[a] = findSet(sets, sets[a]);
		}
		return sets[a];
	}
}
