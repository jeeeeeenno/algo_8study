package silsub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 윤길재_퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			Queue<String> q = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			Queue<String> ans = new LinkedList<String>();
			int N = sc.nextInt();
			String[] input = new String[N];
			for(int i=0; i<N;i++) {
				input[i] = sc.next();
			}
			if(N%2==0) {
				for(int i=0; i<N; i++) {
					if(i<N/2) q.add(input[i]);
					else q2.add(input[i]);
				}
			}else {
				for(int i=0; i<N; i++) {
					if(i<N/2+1) q.add(input[i]);
					else q2.add(input[i]);
				}
			}
			while(!q.isEmpty()&&!q2.isEmpty()) {
				ans.offer(q.poll());
				ans.offer(q2.poll());
			}
			if(N%2==1) ans.offer(q.poll());
			
			System.out.print("#"+t);
			for(String x: ans) {
				System.out.print(" "+x);
			}
			System.out.println();
		}
	}
}