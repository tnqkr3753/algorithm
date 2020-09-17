package sort;

public class BubbleSort extends Sort{

	@Override
	void sort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-i; j++) {
				if(arr[j-1]>arr[j]) {
					swap(arr, j-1, j);
				}
			}
		}
	}
}
