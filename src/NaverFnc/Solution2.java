package NaverFnc;

public class Solution2 {

	public static void main(String[] args) {
		int n = 5, jump = 3;
		Solution s = new Solution();
		s.solution(n, jump);
	}
	static class Solution{
		public int[] solution(int n , int jump) {
			int[][] arr = new int[n][n];
			int breakCount = n*n;
			int k = 1,t = 1; //값, 방향변수 
			int x = 0, y = -1; //행열
			int p = n;//반복인덱스
			int jumpCnt = 0,jumpValue = jump-1;
			arr[0][0] = k;
			Loop1 : while (true) {
				if (p<= 0) {
					p = n;
					x = 0;
					y = -1;
					t = 1;
				}
				for (int i = 0; i < p; i++) {
					y += t;
					if (jumpCnt != jumpValue) {
						if(arr[x][y] == 0) jumpCnt++;
					}else {
						if(arr[x][y] == 0){
							k++;
							arr[x][y] = k;
							if(k == breakCount) break Loop1;
							jumpCnt = 0;
						}
						
					}
				}
				p--;
				if (p <= 0) {
					continue;
				}
				for (int i = 0; i < p; i++) {
					x += t;
					if (jumpCnt != jumpValue) {
						if(arr[x][y] == 0) jumpCnt++;
					}else {
						if(arr[x][y] == 0) {
							k++;
							arr[x][y] = k;
							if(k == breakCount) break Loop1;
							jumpCnt = 0;
						}
					}
				}
				t *= -1;
			}
			int[] answer = {x+1,y+1};
			return answer;
		}
		public void printArr(int[][] arr) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]+"/");
				}
				System.out.println();
			}
		}
	}
}
