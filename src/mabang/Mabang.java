package mabang;

import java.util.Scanner;

public class Mabang {
	static int[][] bang = null ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		bang = new int[input][input];
		int x = 0;
		int y = (input/2);
		for (int i = 0; i < Math.pow(input, 2); i++) {
			bang[x][y] = i+1;
			if((i+1)%input==0) x++;
			else { 
				x = mabang(x,input);
				y = mabang(y,input);
			}
		}
		for (int i = 0; i < bang.length; i++) {
			for (int j = 0; j < bang[i].length; j++) {
				System.out.print(bang[i][j] + " ");
			}
			System.out.println();
		}
	}
	static int mabang(int x,int input) {
		if(x==0) return bang.length-1;
		else return x-1;
	}

}
