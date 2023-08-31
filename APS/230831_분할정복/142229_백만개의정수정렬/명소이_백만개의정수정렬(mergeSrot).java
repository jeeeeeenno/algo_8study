package �鸸������������;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_mergeSort {
	public static void main(String[] args) {
		// �Է�
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[1000000];
		for(int i = 0; i < 1000000; i++) {
			nums[i] = scanner.nextInt();
		}
		// ����
		mergeSort(nums, 0, nums.length-1);
		// ���
		System.out.println(nums[500000]);
		scanner.close();
	}
	
	public static void mergeSort(int[] nums, int left, int right) {
		if(left >= right) return;
		int[] tmp = new int[right-left+1];
		int mid = (left + right)/2;
		mergeSort(nums, left, mid); // ���� ����
		mergeSort(nums, mid+1, right); // ������ ����
		merge(nums, tmp, left, mid, right); // ����
	}
	
	public static void merge(int[] nums, int[] tmp, int left, int mid, int right) {
		int l = left;
		int r = mid+1;
		int index = 0;
		while(l <= mid || r <= right) {
			if(r > right || (l <= mid && nums[l] < nums[r])) {
				tmp[index++] = nums[l++];
			}else {
				tmp[index++] = nums[r++];
			}
		}
		// ���� �迭 ����
		for(int i = left; i <= right; i++) {
			nums[i] = tmp[i-left];
		}
	}
}
