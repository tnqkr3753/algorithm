package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> l = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			l.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(l);
		int totalTime = 0;
		for (int i = 0; i < n; i++) {
			totalTime += l.get(i)* (n-i);
		}
		System.out.println(totalTime);
	}
}
