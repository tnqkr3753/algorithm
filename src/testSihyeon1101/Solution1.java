package testSihyeon1101;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
		System.out.println(solution(arr,n));
	}
	public static boolean solution(int[] arr, int n) {
		boolean answer = false;
		Arrays.sort(arr);
		int firstIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>=n) {
				firstIdx = i;
				break;
			}
		}
		for (int i = 0; i < firstIdx; i++) {
			int minus = n-arr[firstIdx];
			if(minus<=0) {
				firstIdx--;
				i--;
				if(i>firstIdx) {
					break;
				}
			}else {
				if(arr[i]==minus) {
					return true;
				}else if (arr[i]>minus) {
					firstIdx--;
					i--;
					if(i>=firstIdx) {
						break;
					}
				}
			}
		}
		return answer;
	}
}
