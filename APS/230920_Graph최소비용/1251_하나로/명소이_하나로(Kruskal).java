package 하나로_KRUSKAL;

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
		int T = scanner.nextInt(); // 테스트 케이스 개수
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = scanner.nextInt(); // 섬의 개수
			int[][] island = new int[N][2];
			for(int i = 0; i < 2; i++) { // 섬의 위치
				for(int j = 0; j < N; j++) {
					island[j][i] = scanner.nextInt();
				}
			}
			double E = scanner.nextDouble(); // 환경 부담 세율
			// 간선 배열 생성
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
			// 계산
			Arrays.sort(Edges, new Comparator<Node>() {
				@Override
				public int compare(Node a, Node b) {
					return (int) (a.L - b.L);
				}
			}); // 오름차순 정렬
			
			int[] sets = new int[N];
			int count = 0;
			for(int i = 0; i < N; i++) sets[i] = i; // 집합 연결 관계 초기화
			double ans = 0;
			for(int i = 0; i < N*(N-1)/2; i++) {
				if(count == N-1) break; // 간선을 모두 연결함
				if(findSet(sets, Edges[i].A) == findSet(sets, Edges[i].B)) continue; // 사이클이 생기는 경우
				ans += Edges[i].L;
				union(sets, Edges[i].A, Edges[i].B);
				count++;
			}
			// 출력
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
