package testSihyeon1101;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
		System.out.println(solution(arr));
	}
	public static int solution(int[] prices) {
		int maxP = 0;
		int minP = 1000001;
		int maxMinus = 0;
		for (int i = 0; i < prices.length; i++) {
			int minus = maxP-minP;
			int tmp = prices[i];
			if(tmp <= minP) {
				minP = tmp;
				maxP = 0;
			}
			if(tmp >= maxP) maxP = tmp;
			if(maxMinus<minus) {
				maxMinus = minus;
			}
			
		}
		//finish
		if(maxMinus<=0) return 0;
		return maxMinus;
	}

}
