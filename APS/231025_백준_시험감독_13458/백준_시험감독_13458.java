package check;

import java.util.Scanner;

public class ����_���谨��_13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ù��° �� �ޱ� N : ������ ����
		int N = sc.nextInt();

		// ������ ������ŭ�� �迭 ����
		int[] arr = new int[N];

		// �ι��� �� �ޱ� A : �� ������ �����ڼ�
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// ����° �� B C �ޱ� : �� , �ΰ������� �����ڼ�
		int B = sc.nextInt();
		int C = sc.nextInt();

		// cntB cntC sum ����
		int cntB = 0;
		//����(1,000,000)�� ���� long���� �������. 
		//int�� �ߴٰ� Ʋ����. 
		long cntC = 0;
		long sum = 0;

		// �� ������
		for (int i = 0; i < N; i++) {
			arr[i] -= B;
			cntB++;
		}

		// �� ������
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