package 분할정복.백만_개의_정수_정렬_14229;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static int N = 10;
	public static int M = 5;
	

	public static int[] sortedArr = new int[N];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[N];

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		mergeSort(A, 0, N - 1);
		bw.write(Integer.toString(A[M]));

		br.close();
		bw.close();
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int L = left, R = mid + 1, idx = left;
		while (L <= mid && R <= right) {
			if (arr[L] < arr[R])
				sortedArr[idx++] = arr[L++];
			else
				sortedArr[idx++] = arr[R++];
		}
		if (L <= mid)
			for (int i = L; i <= mid; i++)
				sortedArr[idx++] = arr[i];
		else
			for (int i = R; i <= right; i++)
				sortedArr[idx++] = arr[i];

		for (int i = left; i <= right; i++)
			arr[i] = sortedArr[i];
	}
	
}