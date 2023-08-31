package 백만개의정수정렬;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_quickSort {
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			nums[i] = scanner.nextInt();
		}
		// 정렬
		quickSort(nums, 0, nums.length - 1);
		// 출력
		System.out.println(nums[500000]);
		scanner.close();
	}
	
	

	private static void quickSort(int[] nums, int left, int right) {
		int pivot = nums[left];
		int L = left + 1;
		int R = right;
		while(L <= R) {
			while(L <= R && nums[L] <= pivot) L++;
			while(nums[R] > pivot) R--;
			if(L < R) {
				int tmp = nums[L];
				nums[L] = nums[R];
				nums[R] = tmp;
			}
		}
		nums[left] = nums[R];
		nums[R] = pivot;
		if(left < R-1) {
			quickSort(nums, left, R-1);
		}
		if(R+1 < right) {			
			quickSort(nums, R+1, right);
		}
	}
	
}