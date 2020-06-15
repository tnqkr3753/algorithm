package sugar;

import java.util.Scanner;

public class back2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int result=-1;
			for (int b = a/5; b >= 0; b--) {
				if((a-b*5)%3==0) {
					result = b+((a-b*5)/3);
					break;
				}
			}
		System.out.println(result);
	}

}
