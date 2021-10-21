package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.stream.Stream;

public class Back1427 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Stream.of(br.readLine().split(""))
//			.mapToInt(Integer::parseInt)
//			.boxed()
//			.sorted(Collections.reverseOrder())
//			.forEach(System.out::print);
		String n = br.readLine();
		int len = n.length();
		int[] arr = new int[len],tmpArr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Character.getNumericValue(n.charAt(i));
		}
		mergeSort(arr, tmpArr, 0, len-1);
		StringBuilder sb = new StringBuilder();
		for (int i = len-1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}
	private static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
		int tmp_idx = left;
		int i = left, j= mid+1;
		while (i <= mid && j<=right) {
			if(arr[i]<= arr[j]) tmpArr[tmp_idx++] = arr[i++];
			else tmpArr[tmp_idx++] = arr[j++];
		}
		
		if (i > mid) {
			for (int k = j; k <= right; k++) {
				tmpArr[tmp_idx++] = arr[k];
			}
		}
		else {
			for (int k = i; k <= mid; k++) {
				tmpArr[tmp_idx++] = arr[k];
			}
		}
		for (int l = left; l <= right; l++) {
			arr[l] = tmpArr[l];
		}
	}
	public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
		int mid ;
		if (left < right) {
			mid = (left+right)/2;
			mergeSort(arr,tmpArr,left, mid);
			mergeSort(arr,tmpArr,mid+1, right);
			merge(arr,tmpArr,left, mid, right);
		}
	}
}
