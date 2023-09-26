package �۾�����;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// �Է�
			int V = scanner.nextInt(); // ������ ����
			int E = scanner.nextInt(); // ������ ����
			int[] degree = new int[V+1];
			ArrayList<Integer>[] arr = new ArrayList[V+1];
			for(int i = 0; i <= V; i++) arr[i] = new ArrayList<>();
			for(int i = 0; i < E; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				degree[b]++;
				arr[a].add(b);
			}
			// ���
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visit = new boolean[V+1];
			int[] ans = solvingTasks(V, degree, arr, queue, visit);
			// ���
			System.out.printf("#%d ", test);
			for(int x : ans) {
				System.out.printf("%d ", x);
			}
			System.out.println();
		}
		scanner.close();
	}
	
	public static int[] solvingTasks(int V, int[] degree, ArrayList<Integer>[] arr, Queue<Integer> queue, boolean[] visit) {
		int[] ans = new int[V];
		int index = 0;
		for(int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) {
				queue.add(i);
				visit[i] = true;
			}
		}
		while(!queue.isEmpty()) {
			int a = queue.poll();
			ans[index++] = a;
			for(int x : arr[a]) {
				degree[x]--;
				if(degree[x] == 0) {
					queue.add(x);
					visit[x] = true;
				}
			}
		}
		return ans;
	}
}
