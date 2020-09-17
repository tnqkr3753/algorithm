package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution3 {
	HashMap hash = new HashMap();
	public static void main(String[] args) {
		Solution3 s3 = new Solution3();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(s3.solution(info, query));
	}
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        init(hash, 0);
        //데이터 입력
        for (int i = 0; i < info.length; i++) {
        	String[] data = new String[5];
			StringTokenizer st = new StringTokenizer(info[i]);
			for (int j = 0; j < data.length; j++) {
				data[j] = st.nextToken();
			}
			addInfo(data,hash,0);
		}
        //데이터 찾기
        for (int i = 0; i < query.length; i++) {
			StringTokenizer st = new StringTokenizer(query[i]);
			String[] wanted = new String[5];
			for (int j = 0; j < wanted.length; j++) {
				String tmp = st.nextToken();
				if(tmp.equals("and")) {
					j--;
					continue;
				}
				wanted[j] = tmp;
			}
			int result = search(wanted, hash, 0);
			answer[i] = result;
		}
        System.out.println(hash);
        return answer;
    }
    public void addInfo(String[] data,Object obj,int level) { //데이터 입력
    	String first = data[level];
    	if(level < 4) {
    		HashMap map = (HashMap)obj;
    		if(map.keySet().contains(first)) {
    			addInfo(data,map.get(first),level+1);
    		}else {
    			addInfo(data,map.get("-"),level+1);
    		}
    	}else { // 점수
    		ArrayList<Integer> score = (ArrayList<Integer>)obj;
    		score.add(Integer.parseInt(first));
    		Collections.sort(score);
    	}
    }
    public void init(HashMap map,int level) { //데이터 초기설정
    	ArrayList<String> val = new ArrayList<String>();
    	if(level <3) {
    	switch (level) {
			case 0:
				val.add("java");
				val.add("python");
				val.add("cpp");
				break;
			case 1:
				val.add("backend");
				val.add("frontend");
				break;
			case 2:
				val.add("junior");
				val.add("senior");
				break;
			default:
				break;
		}
	    	for (int i = 0; i < val.size(); i++) {
	    		String value = val.get(i);
				map.put(value, new HashMap());
				init((HashMap)map.get(value),level+1);
			}
    	}else {
    		val.add("chicken");
			val.add("pizza");
    		for (int i = 0; i < val.size(); i++) {
				map.put(val.get(i), new ArrayList());
			}
    	}
    }
    public int search(String[] data,Object obj,int level) {
    	int result = 0;
    	String first = data[level];
    	if(level<4) {
    		HashMap map = (HashMap)obj;
    		if(first.equals("-")) {
    			for (Object obj2 : map.keySet()) {
    				result +=search(data,map.get((String)obj2),level+1);
				}
    		}
    		else{
    			result +=search(data,map.get(first),level+1);
    		}
    	}else {
    		ArrayList<Integer> arr = (ArrayList<Integer>)obj;
    			result = compInt(arr, Integer.parseInt(first));
    	}
    	return result;
    }
    //값 비교
    public int compInt(ArrayList<Integer> arr,int target) {
    	int mid=0;
    	int start = 0;
    	int end = arr.size()-1;
    	while(end>=start) {
    		mid = (start + end)/2;
    		if(target<=arr.get(mid)) {
    			end = mid-1;
    			if (start==end) {
	    			
	    		}else {
	    			
	    		}
    		}else {
    			start = mid+1;
    		}
    	}
    	return arr.size()-start;
    }
}
