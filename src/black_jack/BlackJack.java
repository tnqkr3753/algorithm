package black_jack;

import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		int[] card;
		card = new int[sc.nextInt()];
		num = sc.nextInt();	
		for (int i = 0; i < card.length; i++) {
			card[i] = sc.nextInt();
		}
		sc.close();
		int result = 0;
		for (int i = 0; i < card.length-2; i++) { //카드1
			for (int j = i+1; j < card.length-1; j++) { //카드2
				for (int k = j+1; k < card.length; k++) { //카드3
					int sum = card[i]+card[j]+card[k];
					if(result<sum&&sum<=num) {
						result = sum;
					}
				}
			}
		}
		System.out.println(result);
	}
}
