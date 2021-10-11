package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2750 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n]; 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		new Sorter(arr).bubbleSort().printArr();
		
	}
}
class Sorter{
	int[] arr;
	
	
	public Sorter(int[] arg) {
		this.arr = arg;
	}
	public Sorter bubbleSort() {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-i; j++) {
				if (arr[j-1] > arr[j]) {
					swap(j-1, j);
				}
			}
		}
		return this;
	}
	public void printArr() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i != arr.length-1) sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	private void swap(int x, int y) {
		int tmpA = this.arr[x];
		arr[x] = arr[y];
		arr[y] = tmpA;
	}
}
