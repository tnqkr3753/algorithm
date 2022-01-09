package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek14891 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character>[] gearList = new ArrayList[4];
		
		for (int i = 0; i < 4; i++) {
			gearList[i] = new ArrayList<Character>();
			for (char  chr : br.readLine().toCharArray()) {
				gearList[i].add(chr);
			}
		}
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] tmpArr = new int[2];
			tmpArr[0] = Integer.parseInt(st.nextToken()) -1;
			tmpArr[1] = Integer.parseInt(st.nextToken());
			turnGear(gearList, tmpArr,0);
		}
		int score = 0;
		for (int i = 0; i < gearList.length; i++) {
			score += Math.pow(2, i) *Character.getNumericValue(gearList[i].get(0));
			
		}
		System.out.println(score);
		
	}
	public static void turnGear(List<Character>[] lstArr, int[] input, int direction) {
		int idx = input[0];
		int seq = input[1];
		int prevIdx = idx-1, nextIdx = idx+1;
		List<Character> lst = lstArr[idx];
		if (direction <= 0) {
			if (prevIdx >= 0 && lstArr[prevIdx].get(2) != lst.get(6)) {
				turnGear(lstArr, new int[]{prevIdx, seq*-1}, -1);
			}
		}
		if (direction >= 0) {
			if (nextIdx <= 3 && lstArr[nextIdx].get(6) != lst.get(2) ) {
				turnGear(lstArr, new int[]{nextIdx, seq*-1}, 1);
			}
		}
		gearProcess(lst, seq);
		
	}
	public static void gearProcess(List<Character> lst, int seq) {
		if (seq == -1) {
			char tmp = lst.remove(0);
			lst.add(7, tmp);
		}else {
			char tmp = lst.remove(7);
			lst.add(0,tmp);
		}
	}

}
