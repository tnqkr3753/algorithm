package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] distanceArr = new int[n-1];
		long[] priceArr = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < distanceArr.length; i++) {
			distanceArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < priceArr.length; i++) {
			priceArr[i] = Integer.parseInt(st.nextToken());
		}
		long result = 0L;
		long minPrice = priceArr[0];
		for (int i = 0; i < distanceArr.length;i++) {
			if (minPrice > priceArr[i]) {
				minPrice = priceArr[i];
			}
			result += minPrice * distanceArr[i];
		}
		System.out.println(result);
	}

}
