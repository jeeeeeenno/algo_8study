package 암호문3;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("./src/암호문3/input.txt"));
		for(int test = 1; test <= 10; test++) {
			// 입력
			int N = sc.nextInt(); // 원본 암호문 개수
			LinkedList<Integer> cipher = new LinkedList<>(); // 원본 암호문
			for(int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}
			int M = sc.nextInt(); // 명령어 개수
			// 암호 수정
			for(int i = 0; i < M; i++) {
				String command = sc.next();
				switch(command) {
					case "I": // 삽입
					{
						int x = sc.nextInt(); // 삽입 위치
						int y = sc.nextInt(); // 삽입 개수
						for(int j = 0; j < y; j++) {
							int s = sc.nextInt();
							cipher.add(x++, s);
						}
						break;
					}
					case "D": // 삭제
					{
						int x = sc.nextInt(); // 삭제 위치
						int y = sc.nextInt(); // 삭제 개수
						for(int j = 0; j < y; j++) {
							cipher.remove(x);
						}
						break;
					}
					case "A": // 추가
					{
						int y = sc.nextInt(); // 추가 개수
						for(int j = 0; j < y; j++) {
							int s = sc.nextInt();
							cipher.add(s);
						}
						break;
					}
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
