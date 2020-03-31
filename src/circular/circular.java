package circular;

import java.util.Scanner;
public class circular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cycle = sc.nextInt();
		int[] num = new int [cycle];
		boolean can =false;
		for (int i = 0; i < cycle; i++) {
			int su = sc.nextInt();
			num[i]=su;
		}
		for (int i = 0; i < num.length; i++) {
			can = false;
			LOOP2 : for (int j = 2; j <= 64; j++) {
				int num2 = num[i],num3 = num[i];
				int count = 0;
				boolean flag = true;
				while(flag) {
					num2/=j;
					count++;
					if(num2==0) flag = false;
				}
				flag= true;
				int [] nam= new int [count];
				while(flag) {
					nam[count-1]=num3%j;
					num3/=j;
					count--;
					if(num3==0) flag = false;
				}
				for (int k = 0; k < nam.length; k++) {
					if(!Integer.toString(nam[k]).equals(Integer.toString(nam[nam.length-1-k]))) {
						continue LOOP2;
					}
				}
				can = true;
				break;
			}
			if(can) System.out.println(1);
			else System.out.println(0);
		}
	}
}
