package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back2751 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n]; 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		new Sorter2(arr).mergeSort(0, n-1).printArr();
	}

}
class Sorter2{
	int[] arr;
	int[] sortedArr;
	
	public Sorter2(int[] arg) {
		this.arr = arg;
		this.sortedArr = new int[this.arr.length];
	}
	public Sorter2 mergeSort(int left, int right) {
		int mid ;
		if (left < right) {
			mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
		return this;
	}
	public void printArr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.arr.length; i++) {
			sb.append(this.arr[i]);
			if (i != this.arr.length-1) sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	private void merge(int left, int mid, int right) {
		int tmp_idx = left;
		int i = left, j= mid+1;
		while (i <= mid && j<=right) {
			if(this.arr[i]<= this.arr[j]) this.sortedArr[tmp_idx++] = this.arr[i++];
			else this.sortedArr[tmp_idx++] = this.arr[j++];
		}
		
		if (i > mid) {
			for (int k = j; k <= right; k++) {
				this.sortedArr[tmp_idx++] = this.arr[k];
			}
		}
		else {
			for (int k = i; k <= mid; k++) {
				this.sortedArr[tmp_idx++] = this.arr[k];
			}
		}
		for (int l = left; l <= right; l++) {
			this.arr[l] = this.sortedArr[l];
		}
	}
}
