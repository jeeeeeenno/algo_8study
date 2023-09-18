package Graph.보물상자_비밀번호_5658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), K = sc.nextInt();
			int l = N / 4;
			String str = sc.next();
			str += str.substring(0, l - 1);
			List<Integer> num = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int code = Integer.parseInt(str.substring(i, i + l), 16);
				if (!num.contains(code)) num.add(code);
			}
			Collections.sort(num, Collections.reverseOrder());
			System.out.println(String.format("#%d %d", t, num.get(K - 1)));
		
		}
		
		sc.close();
	}

}
