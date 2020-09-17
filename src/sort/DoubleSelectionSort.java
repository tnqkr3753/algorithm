package sort;

public class DoubleSelectionSort extends Sort {

	@Override
	void sort(int[] arr) {
		for (int i = 0,end = arr.length-1-i; i<end; i++) {
			int min = arr[i];
			int max = arr[end];
			int maxIndex = end;
			int minIndex = i;
			for (int j = i+1; j < end; j++) {
				if(min>arr[j]) {
					min = arr[j];
					minIndex = j;
				}
				if(max<arr[j]) {
					max = arr[j];
					maxIndex=j;
				}
			}
			swap(arr, i, minIndex);
			swap(arr, end, maxIndex);
		}
	}

}
