package 단순2진암호코드;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		String[] cryp = new String[10];
//		cryp[0] = "0001101";
//		cryp[1] = "0011001";
//		cryp[2] = "0010011";
//		cryp[3] = "0111101";
//		cryp[4] = "0100011";
//		cryp[5] = "0110001";
//		cryp[6] = "0101111";
//		cryp[7] = "0111011";
//		cryp[8] = "0110111";
//		cryp[9] = "0001011";
//		int[] cryp = {13, 25, 19, 61, 35, 49, 47, 59, 55, 11};
		int[] cryp = new int[62];
		cryp[13] = 0;
		cryp[25] = 1;
		cryp[19] = 2;
		cryp[61] = 3;
		cryp[35] = 4;
		cryp[49] = 5;
		cryp[47] = 6;
		cryp[59] = 7;
		cryp[55] = 8;
		cryp[11] = 9;
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/단순2진암호코드/input (24).txt"));
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			// 입력
			int N = scanner.nextInt(); // 배열 세로
			int M = scanner.nextInt(); // 배열 가로
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < M; i++) {
				sb.append('0');
			}
			String none = sb.toString();
			String[] arr = new String[N];                                                                                                                                                                                            
			for(int i = 0; i < N; i++) {
				arr[i] = scanner.next();
			}
			// 해석
			char[] line = new char[M];
			for(int i = 0; i < N; i++) {
				if(arr[i].equals(none)) continue;
				else {
					line = arr[i].toCharArray();
					break;
				}
			}
			int[] nums = new int[8];
			int index = 7;
			for(int i = M-1; i >= 0; i--) {
				int num = 0;
				if(line[i] == '1') {
					for(int j = 6; j >= 0; j--) {
						num = num*2 + (line[i-j]-'0');
					}
					nums[index--] = num;
					i -= 6;
				}
			}
			for(int i = 0; i < 8; i++) {
				nums[i] = cryp[nums[i]];
			}
			// 출력
			
			int check = 0;
			int total = 0;
			for(int i = 0; i < 8; i++) {
				total += nums[i];
				if(i%2==0) check += nums[i]*3;
				else check += nums[i];
			}
			int ans = 0;
			if (check%10 == 0) {
				ans = total;
			}
			System.out.println(check);
			System.out.printf("#%d %d\n", test, ans);
		}
		scanner.close();
	}
}
