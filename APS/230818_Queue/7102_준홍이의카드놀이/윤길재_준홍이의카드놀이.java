package silsub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 윤길재_준홍이의카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			Queue<Integer> q = new LinkedList<Integer>();
			List<Integer> ans = new ArrayList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] nArr = new int[N];
			int[] mArr = new int[M];
			Arrays.setAll(nArr, num -> (num+1));
			Arrays.setAll(mArr, num -> (num+1));
			
			for(int i:nArr) {
				for(int j:mArr) {
					q.add(i+j);
				}
			}
			
			int[] cnt = new int[q.size()];
			for(int i=0; i<cnt.length;i++) {
				cnt[q.poll()]++;
			}
			int max = Arrays.stream(cnt).max().getAsInt();
			
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i]==max) ans.add(i);
			}
			System.out.print("#"+t);
			for(int x:ans) System.out.print(" "+x);
			System.out.println();
		}
	}
}