package frog_jump;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Frogjump {
	static int[] rock;
	static int canJump;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int cycle = sc.nextInt();
		for (int i = 0; i < cycle; i++) {
			int rockTotal = sc.nextInt(); //돌들의 총 개수
			int [] rockNum = new int[rockTotal]; //돌들의 위치 배열 토큰갯수만큼
			int max = 0; //가장끝에있는 돌
			for (int j = 0; j < rockNum.length; j++) {
				rockNum[j] = sc.nextInt(); //돌들의 위치 입력
				if(rockNum[j]>max) max = rockNum[j]; //가장 끝에 있는돌 구하기
			}
			canJump = sc.nextInt(); //점프가능한 거리
			rock = new int [max+1]; //돌 배열의 최대거리 (개구리 처음위치 포함)
			rock[0] = 2; //2는 개구리가 있는 자리
			for (int j = 0; j < rockNum.length; j++) { 
				rock[rockNum[j]] = 1; //돌이 있는 자리에 1 넣기
			}
			count = 0; //개구리 점프횟수
			int space = 0; //개구리 인덱스
			boolean back = false;
			int result = jump(space,back);
			System.out.println("Case#" + i);
			System.out.println(result);
		}
	}
	static int jump(int space,boolean back) {
		int canrock = 0;
		if (space+canJump>=rock.length-1) { // 위치+점프가능거리가 돌 배열을넘을때
			for (int i = space+1; i < rock.length; i++) { // 지금위치+1부터 지금위치 + 움직일수 있는 거리 
				if(rock[i]==1) {   //만약 그사이에 돌이 있다면
					canrock = i; //canrock에 돌 인덱스 저장
				}
			}
		}else {
			for (int i = space+1; i <= space+canJump; i++) {
				if(rock[i]==1) {
					canrock = i;
				}
			}
		}
		if (canrock >0) {
			back = false;
			space = canrock;
			count ++;
			if(space == rock.length-1) {
				return count;
			}else return jump(space,back);
		}
		else {
			return -1;
		}
	}
}
