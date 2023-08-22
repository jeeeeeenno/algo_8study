package silsub;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 윤길재_진기의최고급붕어빵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			Queue<Integer> que = new LinkedList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=0; i<N; i++) {
				que.add(arr[i]);
			}
			String ans = "Impossible";
			int cnt = 0;
			while (!que.isEmpty()) {
				int chk = que.peek() / M * K;
				if (chk-cnt>=1) {
					cnt++;
					que.poll();
				} else {
					break;
				}
			}
			if (que.isEmpty())
				ans = "Possible";
			System.out.println("#" + t + " " + ans);
		}

	}
}