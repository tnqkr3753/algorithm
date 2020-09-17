package sort;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] arr = getArr(1000000, 1000000);
//		int[] arr = {1,10,5,8,7,6,4,3,2,9};
		System.out.println("non-sort");
		arrPrint(arr);
		/*
		 * SelectionSort
		 */
//		int[] arr1 = arr;
//		SelectionSort ss = new SelectionSort();
//		long selectionTime = ss.getTime(arr1);
//		System.out.println("sorted");
//		System.out.println("sort 시간차(m) : "+selectionTime);
//		arrPrint(arr1);
		/*
		 * DoubleSelectionSort
		 */
//		int[] arr2 = arr;
//		DoubleSelectionSort dss = new DoubleSelectionSort();
//		long doubleSelectionTime = dss.getTime(arr2);
//		System.out.println("doubleSorted");
//		System.out.println("doublesort 시간차(m) : "+doubleSelectionTime);
//		arrPrint(arr2);
		/*
		 * BubbleSort (Fail -> timeOver)
		 */
//		int[] arr3 = arr;
//		BubbleSort bs = new BubbleSort();
//		long bubbleTime = bs.getTime(arr3);
//		System.out.println("BubbleSort");
//		System.out.println("BubbleSort 시간차(m) : "+ bubbleTime);
//		arrPrint(arr3);
		/*
		 * InsertionSort (4818)
		 */
//		int[] arr4 = arr;
//		InsertionSort is = new InsertionSort();
//		long insertionTime = is.getTime(arr4);
//		System.out.println("InsertionSort");
//		System.out.println("InsertionSort 시간차(m) : " +  insertionTime);
//		arrPrint(arr4);
		/*
		 * QuickSort
		 */
		int[] arr5 = arr;
		QuickSort qs = new QuickSort();
		long quickTime = qs.getTime(arr5);
		System.out.println("QuickSort");
		System.out.println("QuickSort 시간차(m) : "+ quickTime);
		arrPrint(arr5);
	}
	public static void arrPrint(int[] arr) {
		for (int i = 0; i < arr.length && i<1000; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public static int[] getArr(int size,int range) {
		int[] result = new int[size];
		Random random = new Random();
		for (int i = 0; i < result.length; i++) {
			result[i] = random.nextInt(range);
		}
		return result;
	}

}
