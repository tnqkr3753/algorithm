package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] prmNumberList = new boolean[n+1];
		Arrays.fill(prmNumberList, Boolean.FALSE);
		prmNumberList[1] = true;
		for (int i = 2 ; i <= Math.sqrt(n); i++) {
			for (int j = m; j <= n; j++) {
				if (!prmNumberList[j]) {
					if  (i == j) continue;
					else if (j % i == 0) {
						prmNumberList[j] = true;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = m; i <= n; i++) {
			if (!prmNumberList[i]) {
				sb.append(i);
				if (i != n) sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
