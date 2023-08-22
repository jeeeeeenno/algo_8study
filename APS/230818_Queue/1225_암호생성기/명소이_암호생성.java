
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// 입력
			sc.next();
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			// 암호 생성
			int d = 0; // 감소
			while(queue.peek() != 0) {
				int tmp = queue.remove();
				tmp = tmp-d-1 > 0 ? tmp-d-1 : 0;
				queue.add(tmp);
				d = (d+1)%5;
				if(tmp == 0) {
					break;
				}
			}
			// 출력
			System.out.printf("#%d ", test);
			for(int i = 0; i < 8; i++) {
				System.out.printf("%d ", queue.remove());
			}
			System.out.println();
		}
		sc.close();
	}
}
