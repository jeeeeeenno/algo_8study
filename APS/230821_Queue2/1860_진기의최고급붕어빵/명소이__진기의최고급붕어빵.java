package 진기의최고급붕어빵;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("./src/진기의최고급붕어빵/input.txt"));
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = sc.nextInt(); // 자격을 얻은 사람 수
			int M = sc.nextInt(); // 붕어빵을 만드는 시간(초)
			int K = sc.nextInt(); // M초 동안 만드는 붕어빵 개수
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for(int i = 0; i < N; i++) {
				queue.add(sc.nextInt());
			}
			// 계산
			int p = queue.size();
			for(int i = 0; i < p; i++) {
				int ppl = queue.peek();
				int b = ppl/M * K - i;
				if(b < 1) break;
				queue.poll();
			}
			// 출력
			if(queue.size() > 0) {
				System.out.printf("#%d Impossible\n", test);
			}else {
				System.out.printf("#%d Possible\n", test);
			}
		}
		sc.close();
	}
}
