package Linked_List.암호문1_1228;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			SinglyLinkedList sll = new SinglyLinkedList(N);
			Node[] crypt = new Node[N];
			for (int n = 0; n < N; n++) {
				crypt[n] = new Node(sc.nextInt());
			}
			sll.head.link = crypt[0];
			for (int n = 0; n < N - 1; n++) {
				crypt[n].link = crypt[n + 1];
			}
			int C = sc.nextInt();
			for (int c = 0; c < C; c++) {
				String cmd = sc.next();			
				int x = sc.nextInt(), y = sc.nextInt();
				Node[] ins = new Node[y];
				for (int i = 0; i < y; i++) {
					ins[i] = new Node(sc.nextInt());
				}
				for (int i = 0; i < y - 1; i++) {
					ins[i].link = ins[i + 1];
				}
				Node cur = sll.head;
				
				for (int i = 0; i < x; i++) {
					cur = cur.link;
				}
				ins[y - 1].link = cur.link;
				cur.link = ins[0];
			}
			Node cur = sll.head.link;
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.printf(" %d", cur.data);
				cur = cur.link;
			}
			System.out.println();
			
		}
		
		
		sc.close();
	}

}

class Node {
	public int data;
	public Node link;
	public Node() {}
	public Node(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	public Node head = new Node();
	public int size = 0;
	public SinglyLinkedList() {}
	public SinglyLinkedList(int size) {
		this.size = size;
	}
}