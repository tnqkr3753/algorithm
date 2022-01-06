package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] calArr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		int total = 0;
		int tmpSum = 0;
		boolean isMinus = false;
		for (char c : calArr) {
			if (isMinus) {
				if (c == '+' ) {
					tmpSum -= Integer.parseInt(sb.toString());
					sb.setLength(0);
				}else if (c == '-') {
					tmpSum -= Integer.parseInt(sb.toString());
					sb.setLength(0);
					total+= tmpSum;
					tmpSum = 0;
				}else {
					sb.append(c);
				}
			}else {
				if (c == '+' ) {
					tmpSum += Integer.parseInt(sb.toString());
					sb.setLength(0);
				}else if (c == '-') {
					tmpSum += Integer.parseInt(sb.toString());
					sb.setLength(0);
					total += tmpSum;
					isMinus = true;
					tmpSum = 0;
				}else {
					sb.append(c);
				}
			}
		}
		if (isMinus) {
			tmpSum -=Integer.parseInt(sb.toString());
		}else {
			tmpSum += Integer.parseInt(sb.toString());
		}
		total += tmpSum;
		System.out.println(total);
	}

}
