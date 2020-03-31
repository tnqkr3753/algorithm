package city;

import java.util.ArrayList;
import java.util.Scanner;

public class City_wang { // 실패 처리속도 너무 느림
	static int[][] road = null;
	static int count = 0;
	static ArrayList<Integer> used ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int city = sc.nextInt();
		int roadCount = sc.nextInt();
		road= new int [roadCount][2];
		for (int i = 0; i < roadCount; i++) {
			road[i][0] =sc.nextInt();
			road[i][1] = sc.nextInt();
		}
		used = new ArrayList<Integer>();
		search(1,0);
		System.out.println(count);
	}
	static void search(int now,int prev) {//쓴길 재사용 불가 왔던 길..
			for (int i = 0; i < road.length; i++) {
				if(used.contains(i)) continue;
				if(road[i][0] == now) { //1번에서 출발
					if(prev==road[i][1]) continue;
					used.add(i);
					now =road[i][1];
					if(now==2) {
						count++;
						search(1,0);
					}else search(now,road[i][0]);
				}else {}
			}
		
	}

}
