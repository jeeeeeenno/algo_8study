package Graph최소비용.창용_마을_무리의_개수_7465;

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
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
				int max = Math.max(x,  y), min = Math.min(x, y); 
				p[find(p, max)] = find(p, min);
			}
			int[] rep = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				rep[find(p, n)] = 1;
			}
			int cnt = 0;
			for (int n = 1; n <= N; n++) {
				if (rep[n] == 1) cnt++;
			}
			
			bw.write(String.format("#%d %d\n", t, cnt));
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int find(int[] p, int x) {
		if (p[x] == x) return x;
		else {
			int rep = find(p, p[x]);
			p[x] = rep;
			return rep;
		}
	}

}
