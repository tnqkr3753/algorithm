package kakao;


public class Solution1 {
	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		System.out.println(s1.solution("...!@BaT#*..y.abcdefghijklm"));
	}
	public String solution(String new_id) {
		String answer = "";
		String match="[^a-z0-9-_.]";
        //1단계
        answer = new_id.toLowerCase();
        //2단계
        answer = answer.replaceAll(match,"");
        //3단계
        StringBuilder sb = new StringBuilder();
        char[] tempArr = answer.toCharArray();
        for (int i = 0; i < tempArr.length; i++) {
			if(tempArr[i] == '.') {
				if(i+1>=tempArr.length-1||tempArr[i+1]!='.') {
					sb.append(tempArr[i]);
				}
			}else {
				sb.append(tempArr[i]);
			}
		}
        //4단계
        if(sb.charAt(0)=='.') sb.deleteCharAt(0);
        if(sb.length()!=0&&sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        //5단계
        if(sb.length()==0) {
        	sb.append('a');
        }
        //6단계
        if(sb.length()>=16) {
        	sb.delete(15, sb.length());
        }
        if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        //7단계
        if(sb.length()<=2) {
        	char tmp = sb.charAt(sb.length()-1);
        	for (int i = sb.length(); i < 3; i++) {
				sb.append(tmp);
			}
        }
        answer = sb.toString();
        return answer;
	}
}
