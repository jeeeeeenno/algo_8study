package silsub;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			Queue<Integer> que = new LinkedList<>();
			int N = sc.nextInt();
			Integer[] arr = new Integer[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			for(int x:arr) {
				que.add(x);
			}
			System.out.print("#"+t+" ");
			for(int i:que) System.out.print(i+" ");
			System.out.println();
		}
}
}
