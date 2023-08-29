package IM대비_문제풀이.원재의_메모리_복구하기_1289;

import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
        	int ans = 0;
        	String mem = sc.next();
        	int idx = 0;
        	if (mem.contains("1")) {
        		ans = 1;
        		idx = mem.indexOf("1");
        	}
        	for (int i = idx; i < mem.length() - 1; i++) {
        		if (mem.charAt(i) != mem.charAt(i + 1)) ans++;
        	}
            
            System.out.println(String.format("#%d %d", t, ans));
        }
         
        sc.close();
    }
 
}