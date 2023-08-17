package 계산기1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			int len = scanner.nextInt(); // 식의 길이
			String oper = scanner.next();
			int total = 0;
			for(int i = 0; i < len; i++) {
				if(oper.charAt(i) != '+') {
					total += oper.charAt(i)-'0';
				}
			}
			System.out.printf("#%d %d\n", test, total);
		}
		scanner.close();
	}
}
