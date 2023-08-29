import java.util.Scanner;

public class swea_start_이진수표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String bs = Integer.toBinaryString(M);
			int cnt = 0;
			if(bs.length()>=N) {
				for(int i=bs.length()-1; i>=bs.length()-N;i--) {
					if(bs.charAt(i)=='1') cnt++; 
				}
			}
			String ans = "OFF";
			if(cnt>=N) ans = "ON";
			System.out.println(ans);
		}
	}
}
