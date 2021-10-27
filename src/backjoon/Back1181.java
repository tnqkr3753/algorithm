package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Back1181 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr,new Comparator<String>() {
			public int compare(String o1, String o2) {
				int len1 = o1.length(),len2 = o2.length();
				if(len1 == len2) {
					return o1.compareTo(o2);
				}else {
					return len1 - len2;
				}
			};
		});
		String prevString = "";
		for (int i = 0; i < n; i++) {
			String nextString = arr[i];
			if (prevString.equals(nextString)) continue;
			prevString = nextString;
			sb.append(nextString);
			if (i != n-1) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
