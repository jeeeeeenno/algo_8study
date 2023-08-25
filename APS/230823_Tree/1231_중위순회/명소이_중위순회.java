package 중위순회;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class node{
	int V;
	char data;
	int L;
	int R;
}

public class Solution {
	public static StringBuilder findChar(node[] tree, node cur) {
		StringBuilder sb = new StringBuilder();
		if(cur.L != 0) {
			sb.append(findChar(tree, tree[cur.L]));
			
		}
		sb.append(cur.data);
		if(cur.R != 0) {
			sb.append(findChar(tree, tree[cur.R]));
		}
		return sb;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/중위순회/input.txt"));
		for(int test = 1; test <=10; test++) {
			// 입력
			int N = scanner.nextInt();
			scanner.nextLine();
			node[] tree = new node[N+1];
			for(int i = 1; i <= N; i++) {
				tree[i] = new node();
				String[] line = scanner.nextLine().split(" ");
				switch(line.length) {
				case 4:
				{
					int tmp = 0;
					for(int c = 0; c < line[3].length(); c++) {
						tmp = tmp*10 + (line[3].charAt(c)- '0');
					}
					tree[i].R = tmp;
				}
				case 3:
				{
					int tmp = 0;
					for(int c = 0; c < line[2].length(); c++) {
						tmp = tmp*10 + (line[2].charAt(c) - '0');
					}
					tree[i].L = tmp;
				}
				case 2:
					tree[i].data = line[1].charAt(0);
					{
						int tmp = 0;
						for(int c = 0; c < line[0].length(); c++) {
							tmp = tmp*10 + (line[0].charAt(c) - '0');
						}
						tree[i].V  = tmp;
					}
				}
			}
			// 단어 조합
			StringBuilder sb = findChar(tree, tree[1]);
			// 출력
			System.out.printf("#%d %s\n", test, sb);
		}
		scanner.close();
	}
}
