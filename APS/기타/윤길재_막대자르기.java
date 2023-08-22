package silsub;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 윤길재_막대자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			Stack<Character> stack = new Stack<>();
			String str = sc.next();
			int cnt = 0;
			int ans = 0;
		
			for(int i=0; i<str.length();i++) {
				if(str.charAt(i)=='(') stack.push('(');
				else {
					stack.pop();
					if(str.charAt(i-1)=='(')ans += stack.size();
					else ans++;
				}
			}
			
			
			System.out.println("#" + t + " "+ans);
		}
	}
}