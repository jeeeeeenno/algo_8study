package Graph최소비용.하나로_1251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	double weight;
	public Edge(int start, int end, double weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] p = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				p[n] = n;
			}
			int[][] islands = new int[N][2];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					islands[n][i] = Integer.parseInt(st.nextToken());
				}			
			}
			
			double E = Double.parseDouble(br.readLine());
			Edge[] edges = new Edge[N * (N - 1) / 2];
			int n = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					edges[n++] = new Edge(i, j, dist(islands[i], islands[j]));
				}
			}
			
			Arrays.sort(edges, new Comparator<Edge>() {
				public int compare(Edge edge1, Edge edge2) {
					return Double.compare(edge1.weight, edge2.weight);
				}
			});
			
			double ans = 0;
			int cnt = 0;
			while (cnt < N - 1) {
				for (int i = 0; i < N * (N - 1) / 2; i++) {
					if (isUnion(p, edges[i].start, edges[i].end)) continue;
					union(p, edges[i].start, edges[i].end);
					ans += Math.pow(edges[i].weight, 2);
					cnt++;
				}
			}
			
			bw.write(String.format("#%d %d\n", t, Math.round(E * ans)));
			
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static double dist(int[] c1, int[] c2) {
		return Math.sqrt(Math.pow(Math.abs(c1[0] - c2[0]), 2) + Math.pow(Math.abs(c1[1] - c2[1]), 2));
	}
	
	static int find(int[] p, int x) {
		if (p[x] == x) return x;
		return p[x] = find(p, p[x]);
	}
	
	static void union(int[] p, int x, int y) {
		int repX = find(p, x), repY = find(p, y);
		if (repX != repY) p[repY] = repX;
	}
	
	static boolean isUnion(int[] p, int x, int y) {
		int repX = find(p, x), repY = find(p, y);
		return repX == repY;
	}

}
