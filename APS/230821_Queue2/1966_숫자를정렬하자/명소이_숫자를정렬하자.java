package 숫자를정렬하자;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner(new File("./src/숫자를정렬하자/input.txt"));
		int T = scanner.nextInt();
		for(int test = 1; test <= T; test++) {
			int N = scanner.nextInt();
			int[] nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = scanner.nextInt();
			}
			// 정렬
			for(int targetIndex = 1; targetIndex < N; targetIndex++) {
				int target = nums[targetIndex];
				for(int i = targetIndex-1; i >= 0; i--) {
					if(nums[i+1] < nums[i]) {
						nums[i+1] = nums[i];
						nums[i] = target;
					}
				}
			}
			// 출력
			System.out.printf("#%d ", test);
			for(int i = 0; i < N; i++) {
				System.out.printf("%d ", nums[i]);
			}
			System.out.println();
		}
		scanner.close();
	}
}