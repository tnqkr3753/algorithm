package marathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution so = new Solution();
		String[] p = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] c = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(so.solution(p,c ));
	}

}
class Solution {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        ArrayList<String> al1 = new ArrayList<String>(Arrays.asList(participant));
		ArrayList<String> al2 = new ArrayList<String>(Arrays.asList(completion));
		for (int i = 0; i < al1.size(); i++) {
			String n= al1.get(i);
			System.out.println(n);
			if(al2.contains(n)) {
                al2.remove(al2.indexOf(n));
				continue;
			} else {
				return answer = al1.get(i);
			}
		}
        return "";
    }
}
