package â�븶�������ǰ���;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // �׽�Ʈ ���̽� ����
		for(int test = 1; test <= T; test++) {
			int N = scanner.nextInt(); // ���� ��� ��
			int M = scanner.nextInt(); // ���� �ƴ� ��� ��
			int[] sets = new int[N];
			for(int i = 0; i < N; i++) sets[i] = i; // ���� ���� ���� �ʱ�ȭ
			for(int i = 0; i < M; i++) {
				int a = scanner.nextInt()-1;
				int b = scanner.nextInt()-1;
				 union(sets, a, b);
			}
			for(int i = 0; i < N; i++) {
				 findSet(sets, i);
			}
			// sets ���� ���� ���� ���ϱ�
			HashSet<Integer> groups = new HashSet<>();
			for(int i = 0; i < N; i++) {
				groups.add(sets[i]);
			}
			// ���
			System.out.printf("#%d %d\n", test, groups.size());
		}
	}
	
	public static void union(int[] sets, int a, int b) {
		int aP = findSet(sets, a);
		int bP = findSet(sets, b);
		if(aP > bP) sets[aP] = bP;
		else sets[bP] = aP;
	}
	
	public static int findSet(int[] sets, int a) {
		if(sets[a] != a) sets[a] = findSet(sets, sets[a]);
		return sets[a];
	}
}
