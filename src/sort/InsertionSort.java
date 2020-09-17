package sort;

public class InsertionSort extends Sort {

	@Override
	void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i-1; j >=0&&temp<arr[j]; j--) {
				swap(arr, j, j+1);
			}
		}
	}

}
