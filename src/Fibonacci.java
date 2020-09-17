
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibo(6));
		System.out.println(sigma(1001));
	}
	public static int fibo(int col) {
		/* 모비젠에서 짠 코드
		int result = 0;
		if (col<1) return 0;
		else if (col==1) result++;
		else if (col==2) result++;
		else {
			result += fibo(col-1)+fibo(col-2);
		}
		return result;
		*/
		/*
		 * 제일 짧은 코드
		 */
		if (col<=1) return col;
		else return fibo(col-1)+fibo(col-2);
	}
	/*
	 * 시그마
	 */
	public static int sigma(int end) {
		return (end*(end+1)/2);
	}
}
