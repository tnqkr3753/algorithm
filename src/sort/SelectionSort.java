package sort;

public class SelectionSort extends Sort {
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			int min= arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if(min>arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			swap(arr, i, index);
		}
	}
}
