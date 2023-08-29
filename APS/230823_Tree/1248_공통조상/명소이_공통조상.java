package 공통조상;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Node{
	int P;
	int L;
	int R;
}

public class Solution {
	
	public static ArrayList<Integer> findP(Node[] tree, int ch) {
		ArrayList<Integer> p = new ArrayList<>();
		if(tree[ch].P != 0) {
			p = findP(tree, tree[ch].P);
			p.add(tree[ch].P);
		}
		return p;
	}
	
	public static int checkSize(Node[] tree, Node p) {
		int size = 0;
		if(p.L != 0) {
			size = checkSize(tree, tree[p.L]) + 1;
		}if(p.R !=0) {
			size += checkSize(tree, tree[p.R]) + 1;
		}
		return size;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/공통조상/input.txt"));
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int V = scanner.nextInt(); // 정점의 개수
			int E = scanner.nextInt(); // 간선의 개수
			int a = scanner.nextInt(); // 정점1의 번호
			int b = scanner.nextInt(); // 정점2의 번호
			Node[] tree = new Node[V+1];
			for(int i = 0; i <= V; i++) {
				tree[i] = new Node();
			}
			for(int i = 1; i <= E; i++) {
				int p = scanner.nextInt();
				int ch = scanner.nextInt();
				if(tree[p].L == 0) {
					tree[p].L = ch;
					tree[ch].P = p;
				}else {
					tree[p].R = ch;
					tree[ch].P = p;
				}
			}
			// 공통 조상 찾기
			ArrayList<Integer> aP = findP(tree, a);
			ArrayList<Integer> bP = findP(tree, b);
			int an = 0;
			for(int i = 0; i < aP.size(); i++) {
				if(aP.get(i).equals(bP.get(i))) {
					an = aP.get(i);
				}else {
					break;
				}
			}
			// 서브트리 크기 구하기
			int size = checkSize(tree, tree[an]) + 1;
			// 출력
			System.out.printf("#%d %d %d\n", test, an, size); // 공통 조상의 번호와 서브트리의 크기
		}
		scanner.close();
	}
}
