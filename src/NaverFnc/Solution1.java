package NaverFnc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution1 {

	public static void main(String[] args) {
		String[] arr= {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
		int k = 3;
		Solution solution = new Solution();
		
		int an = solution.solution(arr, k);
		System.out.println(an);
	}
	static class Solution{
		public int solution(String[] id_list, int k ) {
			HashMap<String, Integer> cupMap = new HashMap<String, Integer>();
			int answer = 0;
			
			for (String string : id_list) {
				HashSet<String> idSet = new HashSet<String>();
				StringTokenizer st = new StringTokenizer(string);
				while (st.hasMoreTokens()) {
					idSet.add((String) st.nextToken()) ;
				}
				for (String id : idSet) {
					if (cupMap.containsKey(id)) {
						int prevCount = cupMap.get(id);
						if (prevCount < k) {
							cupMap.replace(id, prevCount+1);
							answer ++;
						}
					}else {
						cupMap.put(id, 1);
						answer ++;
					}
				}
			}
			return answer;
		}
	}
}
