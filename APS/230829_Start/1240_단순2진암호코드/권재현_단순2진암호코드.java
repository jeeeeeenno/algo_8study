package start.단순_2진_암호코드_1240;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(Integer.parseInt("1101", 2));
		list.add(Integer.parseInt("11001", 2));
		list.add(Integer.parseInt("10011", 2));
		list.add(Integer.parseInt("111101", 2));
		list.add(Integer.parseInt("100011", 2));
		list.add(Integer.parseInt("110001", 2));
		list.add(Integer.parseInt("101111", 2));
		list.add(Integer.parseInt("111011", 2));
		list.add(Integer.parseInt("110111", 2));
		list.add(Integer.parseInt("1011", 2));
		
		for (int i = 0; i < 10; i++) {
			map.put(list.get(i), i);
		}
		
		
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(), M = sc.nextInt();
			String code = "";
			for (int n = 0; n < N; n++) {
				String temp = sc.next();
				if (temp.contains("1")) {
					code = temp;
				}
			}
			int idx = M - 1;
			for (int m = 55; m < M; m++) {
				if (code.charAt(m - 1) == '1' && code.charAt(m) == '0') idx = m - 1;
			}
			idx -= 55;
			int[] intCode = new int[8];
			for (int i = 0; i < 8; i++) {
				intCode[i] = Integer.parseInt(code.substring(idx + 7 * i, idx + 7 * (i + 1)), 2);
			}
			
			int evenSum = 0;
			int oddSum = 0;
			int sum = 0;
			for (int i = 0; i < 8; i++) {
				if (i % 2 == 0) oddSum += map.get(intCode[i]);
				else evenSum += map.get(intCode[i]);
				sum += map.get(intCode[i]);
			}
			
			int ans = 0;
			if ((oddSum * 3 + evenSum) % 10 == 0) ans = sum;
			else ans = 0;
			
			System.out.println(String.format("#%d %d", t, ans));
		}
		
		sc.close();
	}

}