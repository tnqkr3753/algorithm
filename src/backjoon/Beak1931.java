package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Beak1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<Meeting> mList = new ArrayList<Meeting>();
		for (int i = 0; i < n; i++) {
			mList.add(new Meeting(br.readLine().split(" ")));
		}
		Collections.sort(mList);
		int meetingCount = 0;
		int endPoint = 0;
		for (Meeting meeting : mList) {
			if (endPoint <= meeting.startTime) {
				endPoint = meeting.endTime;
				meetingCount++;
				
			}
		}
		System.out.println(meetingCount);
	}
	static class Meeting implements Comparable<Meeting>{
		int startTime;
		int endTime;
		public Meeting(String[] arr) {
			this.startTime = Integer.parseInt(arr[0]);
			this.endTime = Integer.parseInt(arr[1]);
		}
		@Override
		public int compareTo(Meeting o) {
			if (this.endTime == o.endTime) {
				return this.startTime - o.startTime;
			}else {
				return this.endTime - o.endTime;
			}
		}
	}

}
