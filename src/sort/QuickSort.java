package sort;

public class QuickSort extends Sort {
	@Override
	void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	private void quickSort(int[] arr, int start, int end) {
		if(start >= end) return;
		int mid = partition(arr, start, end);
		quickSort(arr, start, mid-1);
		quickSort(arr, mid, end);
	}
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while(start<=end) {
			while(arr[start]<pivot) start ++;
			while(arr[end]>pivot) end--;
			if(start <= end) {
				swap(arr, start, end);
				start ++;
				end--;
			}
		}
		return start;
	}

}
