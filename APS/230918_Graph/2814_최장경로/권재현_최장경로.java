package Graph.최장_경로_2814;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int value;
	List<Integer> adjList;

	Node(int value) {
		this.value = value;
		this.adjList = new ArrayList<Integer>();
	}
}

public class Solution {
	static int cnt;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 1;
			int N = sc.nextInt(), M = sc.nextInt();
			if (N == 1)
				ans = 1;
			else {
				Node[] nodeList = new Node[N];
				for (int n = 0; n < N; n++) {
					nodeList[n] = new Node(n + 1);
				}
				for (int m = 0; m < M; m++) {
					int x = sc.nextInt(), y = sc.nextInt();
					if (!nodeList[x - 1].adjList.contains(y)) {
						nodeList[x - 1].adjList.add(y);
					}
					if (!nodeList[y - 1].adjList.contains(x)) {
						nodeList[y - 1].adjList.add(x);
					}
				}
				ans = 1;
				for (int i = 1; i < N; i++) {
					cnt = 1;
					boolean[] visited = new boolean[N];
					recur(visited, nodeList, i);
				}
			}
			System.out.println(String.format("#%d %d", t, ans));
		}

		sc.close();
	}

	static void recur(boolean[] visited, Node[] nodeList, int x) {
		visited[x - 1] = true;
		for (int y : nodeList[x - 1].adjList) {
			if (!visited[y - 1]) {
				visited[y - 1] = true;
				cnt++;
				recur(visited, nodeList, y);
				visited[y - 1] = false;
				cnt--;
			}
		}
		if (cnt > ans) ans = cnt;
	}

}
