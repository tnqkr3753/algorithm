package hanoi_tower;

import java.util.Scanner;
////////////////////절대모르겠음!! 재귀쪽!
public class hanoiTower {
	static int[] tower ;
	static int count;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int pan = sc.nextInt();
		carry(pan,1,3,2,false);
		System.out.println(count);
		carry(pan,1,3,2,true);
		
		
	}
	//절대모르겠음
	static void carry(int pan,int start,int to,int temp,boolean a) {
		if(a) {
			count++;
			if(pan==1) {
				System.out.println(start+ " "+ to);
				return;
			}
			else {
				carry(pan-1,start,temp,to,true);
				System.out.println(start+ " "+ to);
				carry(pan-1,temp,to,start,true);
			}
		}
		else {
			count++;
			if(pan==1) {
				return;
			}
			else {
				carry(pan-1,start,temp,to,false);
				carry(pan-1,temp,to,start,false);
			}
		}
		
	}
}