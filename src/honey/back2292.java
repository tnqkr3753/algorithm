package honey;

import java.util.Scanner;

public class back2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 1;
		for (int i = 0; i<n; i++) {
			sum += i*6;
			if(n<=sum) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
