import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = sc.nextInt()+1;
			Queue<String> deck1 = new LinkedList<>();
			Queue<String> deck2 = new LinkedList<>();
			for(int i = 0; i < N/2; i++) {
				deck1.add(sc.next());
			}
			for(int i = N/2; i < N-1; i++) {
				deck2.add(sc.next());
			}
			// 셔플
			Queue<String> cards = new LinkedList<>();
			while(true) {
				if(deck1.isEmpty())break;
				cards.add(deck1.remove());
				if(deck2.isEmpty()) break;
				cards.add(deck2.remove());
				
			}
			// 출력
			System.out.printf("#%d ", test);
			for(int i = 0; i < cards.size(); i++) {
				String tmp = cards.remove();
				System.out.printf("%s ", tmp);
				cards.add(tmp);
			}
			System.out.println();
		}
		sc.close();
	}
}
