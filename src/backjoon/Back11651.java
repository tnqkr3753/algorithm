package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Back11651 {

	public static void main(String[] args) throws Exception {
		int[][] arr = read();
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int[] is = arr[i];
			sb.append(is[0]);
			sb.append(" ");
			sb.append(is[1]);
			if (i != len-1) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	public static int[][] read() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] tmpArr= br.readLine().split(" ");
			for (int j = 0; j < tmpArr.length; j++) {
				arr[i][j] = Integer.parseInt(tmpArr[j]);
			}
		}
		return arr;
	}
}
