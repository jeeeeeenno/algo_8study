package Graph최소비용.서로소_집합_3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			int[] p = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				p[n] = n;
			}
			bw.write("#" + t + " ");
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int[] oper = new int[3];
				for (int i = 0; i < 3; i++) {
					oper[i] = Integer.parseInt(st.nextToken());
				}
				if (oper[0] == 0) {
					union(p, oper[1], oper[2]);
				} else {
					bw.write(Integer.toString(isUnion(p, oper[1], oper[2])));
				}
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int find(int[] p, int x) {
		if (p[x] == x) return x;
		return p[x] = find(p, p[x]);
	}
	
	static void union(int[] p, int x, int y) {
		int repX = p[find(p, x)], repY = p[find(p, y)];
		if (repX != repY) p[repY] = repX;
	}
	
	static int isUnion(int[] p, int x, int y) {
		int repX = p[find(p, x)], repY = p[find(p, y)];
		if (repX == repY) return 1;
		return 0;
	}

}
