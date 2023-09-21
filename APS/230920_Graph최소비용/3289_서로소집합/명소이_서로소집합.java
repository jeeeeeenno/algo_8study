package ���μ�����;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // �׽�Ʈ ���̽� ����
		for (int test = 1; test <= T; test++) {
			int N = scanner.nextInt(); // ������ ����
			int M = scanner.nextInt(); // ������ ����
			int[] sets = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				sets[i] = i; // ���� ���� ���� �ʱ�ȭ
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				int c = scanner.nextInt(); // ���� ����
				int a = scanner.nextInt(); // ����1
				int b = scanner.nextInt(); // ����2
				switch (c) {
				case 0: // ����
					union(sets, a, b);
					break;
				case 1: // ���� ���� Ȯ��
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
			return 1; // ���� ���տ� �����ִ� ���
		else
			return 0;// ���� ���տ� �������� ���� ���
	}

	public static int findSet(int[] sets, int a) {
		if (sets[a] != a) {
			sets[a] = findSet(sets, sets[a]);
		}
		return sets[a];
	}
}
