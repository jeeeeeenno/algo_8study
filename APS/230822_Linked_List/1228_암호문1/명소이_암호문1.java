package 암호문1;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// 입력
			int N = sc.nextInt(); // 원본 암호문의 길이
			LinkedList<Integer> cipher = new LinkedList<>();// 원본 암호문
			for(int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}
			int M = sc.nextInt();// 명령어의 개수
			for(int i = 0; i < M; i++) {
				sc.next(); // '|'
				int x = sc.nextInt(); // 위치
				int y = sc.nextInt(); // 숫자 갯수
				for(int j = 0; j < y; j++) {
					int s = sc.nextInt(); // 숫자
					cipher.add(x++, s);
				}
			}
			// 출력
			System.out.printf("#%d ", test);
			for(int i = 0; i < 10; i++) {
				System.out.printf("%d ", cipher.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}