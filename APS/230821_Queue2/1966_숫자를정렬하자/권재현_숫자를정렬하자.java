package Queue2.숫자를_정렬하자_1966;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			PriorityQueue<Integer> pQueue = new PriorityQueue<>();
			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				pQueue.add(sc.nextInt());
			}
//			System.out.println(pQueue.toString());
			System.out.printf("#%d", t);
			for (int n = 0; n < N; n++) {
				System.out.printf(" %d", pQueue.poll());
			}
			System.out.println();
		}
		
		sc.close();
	}

}
