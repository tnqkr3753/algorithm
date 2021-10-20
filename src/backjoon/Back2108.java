package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back2108 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BackObj2108 bo = new BackObj2108(read());
		bo.process().printer();
	}
	public static int[] read() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		return arr;
	}
}
class BackObj2108{
	int[] arr;
	int[] result = new int[4];
	int[] countArr;
	public BackObj2108(int[] arr) {
		this.arr = arr;
		countArr = new int[8001];
	}
	public void printer() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb.toString().strip());
	}
	public BackObj2108 process() {
		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i] + 4000]++;
		}
		int modeIdx = 0;
		int modeValue = 0;
		int sum = 0;
		int maxValue = Arrays.stream(countArr).max().getAsInt();
		int arrIdx = 0;
		for (int i = 0; i < countArr.length; i++) {
			int trueValue = i - 4000;
			for (int j = 0; j < countArr[i]; j++) {
				arr[arrIdx++] = trueValue;
				sum += trueValue;
			}
			if (maxValue == countArr[i]) {
				if (modeIdx ++ <= 1) {
					modeValue = trueValue;
				}
			}
		}
		result[0] = Math.round((float)sum / arr.length);
		result[1] = arr[arr.length/2];
		result[2] = modeValue;
		result[3] = arr[arr.length-1] - arr[0];
		return this;
	}
}
