package check;

import java.util.Scanner;

public class 백준_시험감독_13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 첫번째 줄 받기 N : 시험장 개수
		int N = sc.nextInt();

		// 시험장 개수만큼의 배열 생성
		int[] arr = new int[N];

		// 두번쨰 줄 받기 A : 각 시험장 응시자수
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 세번째 줄 B C 받기 : 총 , 부감독관이 감시자수
		int B = sc.nextInt();
		int C = sc.nextInt();

		// cntB cntC sum 생성
		int cntB = 0;
		//조건(1,000,000)에 의해 long으로 해줘야함. 
		//int로 했다가 틀렸음. 
		long cntC = 0;
		long sum = 0;

		// 총 감독관
		for (int i = 0; i < N; i++) {
			arr[i] -= B;
			cntB++;
		}

		// 부 감동관
		for (int i = 0; i < N; i++) {
			if (arr[i] > 0) {
				if (arr[i] % C == 0) {
					cntC += (arr[i] / C);
				} else if (arr[i] % C != 0) {
					cntC += (arr[i] / C) + 1;
				}
			}
		}

		sum = (cntB + cntC);
		System.out.println(sum);

	}
}