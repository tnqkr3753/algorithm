package NaverFnc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
		String [] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
		Solution s = new Solution();
		String[] answer= s.solution(logs);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	static class Solution{
		public String[] solution(String[] logs) {
			HashMap<String, String> map = new HashMap<String, String>();
			HashSet<String> answerSet = new HashSet<String>();
	        for (String string : logs) {
				String[] row = string.split(" ");
				if (map.containsKey(row[1])) {
					if(map.get(row[1]).split(";")[0].equals(row[2])) {
						answerSet.add(row[0]);
						answerSet.add(map.get(row[1]).split(";")[1]);
					}
				}else {
					map.put(row[1], row[2]+";"+row[0]);
				}
			}
	        List<String> arr = new ArrayList<>(answerSet);
	        Collections.sort(arr);
	        String[] answer = arr.toArray(new String[arr.size()]);
	        return answer;
	    }
	}

}
