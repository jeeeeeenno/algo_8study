package 백트래킹.규영이와_인영이의_카드게임_6808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
	public static List<Integer> deck;
	public static int N = 9;
	public static List<Integer> deck2;
	public static List<Integer> result;
	public static int a;
	public static int b;
	public static int win;
	public static int lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			deck = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				deck.add(sc.nextInt());
			}
			deck2 = new ArrayList<>();
			IntStream.rangeClosed(1, 18).forEach(deck2::add);
			deck.forEach(deck2::remove);
			win = 0;
			lose = 0;
			result = new ArrayList<>(Collections.nCopies(N, 0));
			perm(0, 0);
			System.out.println(String.format("#%d %d %d", t, win, lose));
		}
		
		sc.close();
	}
	
	public static void perm(int idx, int visited) {
		if (idx == N) {
			a = 0;
			b = 0;
			for (int i = 0; i < 9; i++) {
				if (deck.get(i) > result.get(i)) {
					a += deck.get(i) + result.get(i);
				} else {
					b += deck.get(i) + result.get(i);
				}
			}
			if (a > b) win++;
			else lose++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) > 0) continue;
			result.set(idx, deck2.get(i));
			perm(idx + 1, visited | (1 << i));
		}

	}

}