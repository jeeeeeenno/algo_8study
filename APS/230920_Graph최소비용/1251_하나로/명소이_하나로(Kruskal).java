package �ϳ���_KRUSKAL;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Node{
	int A;
	int B;
	double L;
}

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // �׽�Ʈ ���̽� ����
		for(int test = 1; test <= T; test++) {
			// �Է�
			int N = scanner.nextInt(); // ���� ����
			int[][] island = new int[N][2];
			for(int i = 0; i < 2; i++) { // ���� ��ġ
				for(int j = 0; j < N; j++) {
					island[j][i] = scanner.nextInt();
				}
			}
			double E = scanner.nextDouble(); // ȯ�� �δ� ����
			// ���� �迭 ����
			Node[] Edges = new Node[N*(N-1)/2];
			int index = 0;
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					Edges[index] = new Node();
					Edges[index].A = i;
					Edges[index].B = j;
					Edges[index].L = Math.pow(island[i][0]-island[j][0], 2) + Math.pow(island[i][1]-island[j][1], 2);
					index++;
				}
			}
			// ���
			Arrays.sort(Edges, new Comparator<Node>() {
				@Override
				public int compare(Node a, Node b) {
					return (int) (a.L - b.L);
				}
			}); // �������� ����
			
			int[] sets = new int[N];
			int count = 0;
			for(int i = 0; i < N; i++) sets[i] = i; // ���� ���� ���� �ʱ�ȭ
			double ans = 0;
			for(int i = 0; i < N*(N-1)/2; i++) {
				if(count == N-1) break; // ������ ��� ������
				if(findSet(sets, Edges[i].A) == findSet(sets, Edges[i].B)) continue; // ����Ŭ�� ����� ���
				ans += Edges[i].L;
				union(sets, Edges[i].A, Edges[i].B);
				count++;
			}
			// ���
			System.out.printf("#%d %.0f\n" , test, ans*E);
		}
		scanner.close();
	}
	
	public static void union(int[] sets, int a, int b) {
		int aP = findSet(sets, a);
		int bP = findSet(sets, b);
		if(aP < bP) {
			sets[bP] = aP;
		}else {
			sets[aP] = bP;
		}
	}
	
	public static int findSet(int[] sets, int a) {
		if(sets[a] != a) {
			sets[a] = findSet(sets, sets[a]);
		}
		return sets[a];
	}
}
