import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int N;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int testcase = 1; testcase <= 10; testcase++) {
			sc.nextInt();
			N = sc.nextInt();
			int M = sc.nextInt();

			System.out.println("#" + testcase + " " + pow(M));
		}
	}

	public static int pow(int M) {
		if (M == 1)
			return N;
		return N * pow(M - 1);
	}
}