package 계산기1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/계산기1/input.txt"));
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 0);
		for(int test = 1; test <= 10; test++) {
			// 입력
			int len = scanner.nextInt(); // 길이
			char[] expression = scanner.next().toCharArray(); // 연산식
			// 후위 표현식으로 변경
			ArrayList<Character> postfix = new ArrayList<>(); // 후위 표현식
			Stack<Character> operator = new Stack<>(); // 연산자
			for(int i = 0; i < len; i++) {
				if(expression[i] >= '0' && expression[i] <= '9') { // 피연산자인 경우
					postfix.add(expression[i]);
				}else if(operator.empty()) {
					operator.add(expression[i]);
				}else if(priority.get(expression[i]) >= priority.get(operator.peek())) {
					operator.add(expression[i]);
				}else {
					postfix.add(operator.pop());
				}
			}
			while(!operator.empty()) {
				postfix.add(operator.pop());
			}
			// 계산하기
			Stack<Integer> nums = new Stack<>(); // 피연산자
			for(int i = 0; i < len; i++) {
				if(Character.isDigit(postfix.get(i))) {
					nums.add(postfix.get(i)-'0');
				}else {
					if(postfix.get(i)=='+') {
						int B = nums.pop();
						int A = nums.pop();
						nums.add(A+B);
					}
				}
			}
			// 출력
			System.out.printf("#%d %d\n", test, nums.pop());
		}
		scanner.close();
	}
}
