package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution2 {
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] answer = new Solution2().solution(orders, course);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ansList = new ArrayList<String>();
        for (int i = 0; i < course.length; i++) {
			int size = course[i];
			HashMap<String, Integer> hash = new HashMap<String, Integer>();
			for (int j = 0; j < orders.length; j++) {
				if(orders[j].length()>=size) {
					char[] tmpArr =orders[j].toCharArray();
					Arrays.sort(tmpArr);
					boolean[] isUse = new boolean[tmpArr.length];
					hash = combination(hash,tmpArr, tmpArr.length, size, 0, isUse);
				}
			}
			int max = -1;
			for(Integer in : hash.values()) {
				if(in>=2 && in>max) {
					max = in;
				}
			}
			
			if(max != -1) {
				for (String string : hash.keySet()) {
					if(hash.get(string)==max) {
						ansList.add(string);
					}
				}
			}
		}
        Collections.sort(ansList);
        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);
        return answer;
    }
    public HashMap<String, Integer> combination(HashMap<String, Integer> hash,
    		char[] arr,int len, int size, int index, boolean[] isUse) {
    	if(size ==0) { //구해야할 개수가 없을 때
    		String result = matchArray(arr, isUse);
    		if(hash.containsKey(result)) {
				hash.put(result, hash.get(result)+1);
			}else {
				hash.put(result, 1);
			}
    	}else if(len==size) { //남은길이와 구해야할 개수가 같을 때
    		for (int i = 0; i < len; i++) {
				isUse[index+i]=true;
			}
    		String result = matchArray(arr, isUse); 
    		if(hash.containsKey(result)) {
				hash.put(result, hash.get(result)+1);
			}else {
				hash.put(result, 1);
			}
    		for (int i = 0; i < len; i++) {
				isUse[index+i]=false;
			}
    	}else { //일반경우
    		isUse[index] = true;
    		combination(hash,arr, len-1, size-1, index+1, isUse);
    		isUse[index] = false;
    		combination(hash,arr, len-1, size, index+1, isUse);
    	}
    	return hash;
    }
    public String matchArray(char[] arr, boolean[] isUse) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < isUse.length; i++) {
			if(isUse[i]) {
				sb.append(arr[i]);
			}
		}
    	return sb.toString();
    }
}
