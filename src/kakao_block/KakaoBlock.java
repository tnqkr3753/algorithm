package kakao_block;

import java.util.Scanner;
import java.util.StringTokenizer;

public class KakaoBlock {
		static char[][] board;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("높이와 넓이 입력");
		board = new char[sc.nextInt()][sc.nextInt()];
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			String tok = st.nextToken();
			for (int k = 0; k < board[i].length; k++) {
				board[i][k] = tok.charAt(k);
			}
		}
		//정상
		//TODO 가로로 같은거 두개 있는지 확인
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length-1; j++) {
				if(board[i][j]==board[i][j+1]) { //옆 두개가 같으면
					search(i,j);
				}
			}
		}
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	static boolean search(int x,int y) {
		
		if(board[x+1][y]==board[x][y]) {
			if(board[x+1][y+1]==board[x][y+1]) {
				return true;
			}else return false;
		}else return false;
	}
}
