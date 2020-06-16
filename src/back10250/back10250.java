package back10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cycle = Integer.parseInt(br.readLine());
		int[] a = new int[cycle];
		int[] b = new int[cycle];
		int[] c = new int[cycle];
		for (int i = 0; i < cycle; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			
		}
		for (int i = 0; i < cycle;i++ ) {
			int h = a[i];
			int w = b[i];
			int n = c[i];
			String row = ""+(n%h);
			int col = (n/h+1);
			System.out.println(row+String.format("%02d", col));
		}
		br.close();

	}
}
