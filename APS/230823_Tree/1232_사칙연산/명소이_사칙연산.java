package 사칙연산;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class node{
	String data;
	int L;
	int R;
}

public class Solution {
	public static double calculate (node[] tree, node cur) {
		if(cur.L == 0) return Integer.parseInt(cur.data);
		double left = calculate(tree, tree[cur.L]);
		double right = calculate(tree,tree[cur.R]);
		if(cur.data.charAt(0)=='+') {
			return left+right;
		}else if(cur.data.charAt(0)=='-') {
			return left-right;
		}else if(cur.data.charAt(0)=='*') {
			return left*right;
		}else if(cur.data.charAt(0)=='/') {
			return left/right;
		}
		return 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("./src/사칙연산/input.txt"));
		for(int test = 1; test <= 10; test++) {
			// 입력
			int N = sc.nextInt();
			sc.nextLine();
			node[] tree = new node[N+1];
			tree[0] = new node();
			for(int n = 1; n <= N; n++) {
				tree[n] = new node();
				String[] str = sc.nextLine().split(" ");
				switch(str.length) {
				case 4:
					tree[n].R = Integer.parseInt(str[3]);
				case 3:
					tree[n].L = Integer.parseInt(str[2]);
				case 2:
					tree[n].data = str[1];
				}
			}
			// 계산
			double ans = calculate(tree, tree[1]);
			// 출력
			System.out.printf("#%d %d\n", test, (int)ans);
		}
		sc.close();
	}
}
