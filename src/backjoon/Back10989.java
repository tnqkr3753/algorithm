package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back10989 {

	public static void main(String[] args) throws Exception {
		int[] arr = read();
		new Back10989.Sorter(arr);
	}
	public static int[] read() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		return arr;
	}
	static class Sorter{
		int[] countArr = new int[10001];
		public Sorter(int[] arr) {
			countSort(arr);
			printer(arr.length-1);
		}
		private void countSort(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				countArr[arr[i]]++;
			}
		}
		private void printer(int idx) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < countArr.length; i++) {
				for (int j = 0; j < countArr[i]; j++) {
					sb.append(i).append('\n');
				}
			}
			System.out.println(sb.toString().strip());
		}
	}

}

