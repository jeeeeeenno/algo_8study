import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][M];
			for(int i=0; i<N; i++) {
				char[] temp = sc.next().toCharArray();
				for(int j=0; j<M; j++) {
					arr[i][j] = temp[j]-'0';
				}
			}
			int startI = 0;
			for(int i=0; i<N; i++) {
				int cnt = 0;
				for(int j=0; j<M; j++) {
					cnt+=arr[i][j];
				}
				if(cnt>0) {
					startI = i;
					break;
				}
			}
			Queue<Integer> queue = new LinkedList<>();
			ArrayList<Integer> nArr = new ArrayList<Integer>();
			ArrayList<String> numArr = new ArrayList<String>();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int i=startI; i<=startI;i++) {
				for(int j=M-1;j>=0; j--) {
					if(arr[i][j]==1) {
						for(int k=j; k>j-56; k--) {
							nArr.add(arr[i][k]);
						}
						break;
					}
				}
			}
			
			Collections.reverse(nArr);
			for(int i=0; i<56; i+=7) {
				String temp = "";
				temp += String.valueOf(nArr.get(i)); 
				temp += String.valueOf(nArr.get(i+1)); 
				temp += String.valueOf(nArr.get(i+2)); 
				temp += String.valueOf(nArr.get(i+3)); 
				temp += String.valueOf(nArr.get(i+4)); 
				temp += String.valueOf(nArr.get(i+5)); 
				temp += String.valueOf(nArr.get(i+6)); 
				numArr.add(temp);
				
				temp = "";
				
			}

			
			for(int i=0;i<numArr.size();i++) {
				String tmp = "";
				for(int j=0; j<7;j++) {
					tmp += numArr.get(i).charAt(j);
				}
				if(tmp.equals("0001101")) nums.add(0);
				else if(tmp.equals("0011001")) nums.add(1);
				else if(tmp.equals("0010011")) nums.add(2);
				else if(tmp.equals("0111101")) nums.add(3);
				else if(tmp.equals("0100011")) nums.add(4);
				else if(tmp.equals("0110001")) nums.add(5);
				else if(tmp.equals("0101111")) nums.add(6);
				else if(tmp.equals("0111011")) nums.add(7);
				else if(tmp.equals("0110111")) nums.add(8);
				else if(tmp.equals("0001011")) nums.add(9);
			}
			int ans = 0;
			int res = 0;
			nums.add(0, 0);
			for(int i=1; i<nums.size();i++) {
				res+=nums.get(i);
				if(i%2==1) ans += nums.get(i)*3;
				else ans += nums.get(i);
			}
			if(ans%10==0) System.out.println("#"+tc+" "+res);
			else {
				ans = 0;
				System.out.println("#"+tc+" "+ans);
				
			}
		}
	}
}
