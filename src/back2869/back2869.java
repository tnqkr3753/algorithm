package back2869;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.BufferedWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long v = Long.parseLong(st.nextToken());
		if((v-a)%(v-b)==0) {
			System.out.println(((int) (((v-a)/(a-b))+1)));
		}else {
			System.out.println((int) (((v-a)/(a-b))+2));
		}
		br.close();
		
		//수학적 계산
//		int result = 1; //마지막날 하루 
//		v-=a; //마지막날 도착하는거 뺌
//		int total = v/(a-b); //총 걸리는 날 나머지 생략
//		if(v - total*(a-b) <= 0 ) { //v가 total보다 작거나 같으면 등반
//			result+=total;
//		}else {
//			result +=total+1;
//		}
//		System.out.println(result);
		
		//이분탐색 모르겠음
//		int low = 0;
//		int result = 0;
//		int height = v;
//		int middle = v/2;
//		int day = a-b;
//		while(true) {
//			result = middle/day;
//			if(v - day*result > a) {//거리가 부족
//				low = middle; //중간까지는 갔다고 생각
//			}else if (v - day*result == a) { //딱맞음
//				break;
//			}else { //v - 중간거리가 a보다 작음 = 줄일 수 있음
//				if(middle + a - v >= day) { //
//					height = middle;
//				}
//				else {
//					break;
//				}
//			}
//			middle = (height+low)/2;
//		}
//		System.out.println(result+1);
		
		
		
		//시간초과
//		while(true) {
//			i++;
//			n+=a;
//			if(n>=v) {
//				System.out.println(i);
//				break;
//			}
//			else {
//				n-=b;
//			}
//		}
	}
}