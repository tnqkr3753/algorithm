package dungch;

import java.util.Scanner;

public class Dungch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int[][] phy = new int[sc.nextInt()][2];
		for (int i = 0; i < phy.length; i++) {
			phy[i][0] =sc.nextInt();
			phy[i][1] = sc.nextInt();
		}
		int[] rank = new int [phy.length];
		for (int i = 0; i < rank.length; i++) {
			rank[i] ++;
			for (int j = 0; j < rank.length; j++) {
				if(j==i) continue;
				if(phy[i][0]<phy[j][0]) {
					if(phy[i][1]<phy[j][1]) rank[i]++;
				}
			}
		}
		for (int i = 0; i < rank.length; i++) {
			System.out.print(rank[i] + " ");
		}
		
	}

}
