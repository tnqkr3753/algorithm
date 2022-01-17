package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		List<Integer> prmNumberList = new ArrayList<Integer>();
		
		LOOP1 : for (int i = m>1?m:2; i <= n; i++) {
			for (Integer integer : prmNumberList) {
				if (i%integer == 0) {
					if (integer != i) {
						continue LOOP1;
					}
				}
			};
			prmNumberList.add(i);
			
		}
		StringBuilder sb = new StringBuilder();
		int size = prmNumberList.size()-1;
		for (int i = 0; i <= size; i++) {
			sb.append(prmNumberList.get(i));
			if (i != size) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
