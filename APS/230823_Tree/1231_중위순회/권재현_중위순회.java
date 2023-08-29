package Tree.중위순회_1231;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] tree = new String[N + 1];
			for (int n = 0; n < N; n++) {
				int idx = sc.nextInt();
				String node = sc.next();
				tree[idx] = node;
				if (idx * 2 <= N) sc.next();
				if (idx * 2 + 1 <= N) sc.next();
			}
			StringBuilder sb = new StringBuilder();
			inOrder(tree, 1, N, sb);
			System.out.println(String.format("#%d %s", t, sb));
		}
		
		sc.close();
	}
	
	public static void inOrder(String[] tree, int idx, int size, StringBuilder sb) {
		if (idx * 2 <= size) inOrder(tree, idx * 2, size, sb);
		sb.append(tree[idx]);
		if (idx * 2 + 1 <= size) inOrder(tree, idx * 2 + 1, size, sb);
		
	}

}