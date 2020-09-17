package sort;

abstract class Sort {
	long beforeTime;
	long afterTime;
	abstract void sort(int[] arr);
	public long getTime(int[] arr) {
		beforeTime = System.currentTimeMillis();
		sort(arr);
		afterTime = System.currentTimeMillis();
		return (afterTime-beforeTime)/100;
	}
	protected void swap(int[] arr,int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
