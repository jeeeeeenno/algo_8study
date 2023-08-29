package ��������;

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
		Scanner scanner = new Scanner(new File("./src/��������/input.txt"));
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// �Է�
			int V = scanner.nextInt(); // ������ ����
			int E = scanner.nextInt(); // ������ ����
			int a = scanner.nextInt(); // ����1�� ��ȣ
			int b = scanner.nextInt(); // ����2�� ��ȣ
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
			// ���� ���� ã��
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
			// ����Ʈ�� ũ�� ���ϱ�
			int size = checkSize(tree, tree[an]) + 1;
			// ���
			System.out.printf("#%d %d %d\n", test, an, size); // ���� ������ ��ȣ�� ����Ʈ���� ũ��
		}
		scanner.close();
	}
}
