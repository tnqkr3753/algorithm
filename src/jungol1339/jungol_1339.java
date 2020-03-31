package jungol1339;

import java.util.Scanner;

public class jungol_1339 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		while((n<1|n>100)|n%2==0) {
			System.out.println("INPUT ERROR");
			System.exit(0);
		}
		int ha = n/2;
		boolean rev = false;
		for (int i = 0; i < n; i++) {
			if(!rev) {
				if(i==ha) rev = true;
				for (int j = 0; j < i+1; j++) {
					int a= ('A'+(((ha)-j)*((ha)-j)+i-j));
					while(a>'Z') a-=26;
					System.out.print((char)a + " ");
				}
			}else
				
				for (int j =0 ; j <n-i; j++) {
					int a= (char)('A'+(((ha)-j)*((ha)-j)+i-j));
					while(a>'Z') a-=26;
					System.out.print((char)a + " ");
				}
			System.out.println();
		}
	}
	
}
