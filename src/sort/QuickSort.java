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
/*
 * https://www.daleseo.com/sort-quick/
 * 코드가 이해가 어려울 수도 있기 때문에 간단히 알고리즘을 설명하겠습니다. 메인 함수인 quick_sort()는 크게 sort()와 partition() 2개의 내부 함수로 나눠집니다. sort() 함수는 재귀 함수이며 정렬 범위를 시작 인덱스와 끝 인덱스로 인자로 받습니다. (둘다 inclusive) partition() 함수는 정렬 범위를 인자로 받으며 다음 로직을 따라서 좌우측의 값들을 정렬하고 분할 기준점의 인덱스를 리턴합니다. 이 분할 기준점(mid)는 sort()를 재귀적으로 호출할 때 우측 리스트의 시작 인덱스로 사용됩니다.

리스트의 정 가운데 있는 값을 pivot 값을 선택합니다.
시작 인덱스(low)는 계속 증가 시키고, 끝 인덱스(high)는 계속 감소 시키기위한 while 루프를 두 인덱스가 서로 교차해서 지나칠 때까지 반복시킵니다.

시작 인덱스(low)가 가리키는 값과 pivot 값을 비교해서 더 작은 경우 반복해서 시작 인덱스 값을 증가시킵니다. (pivot 값보다 큰데 좌측에 있는 값을 찾기 위해)
끝 인덱스(high)가 가리키는 값과 pivot 값을 비교해서 더 작은 경우 반복해서 끝 인덱스 값을 감소시킵니다. (pivot 값보다 작은데 우측에 있는 값을 찾기 위해)
두 인덱스가 아직 서로 교차해서 지나치치 않았다면 시작 인덱스(low)가 가리키는 값과 끝 인덱스(high)가 가리키는 값을 상호 교대(swap) 시킵니다. (잘못된 위치에 있는 두 값의 위치를 바꾸기 위해)
상호 교대 후, 다음 값을 가리키기 위해 두 인덱스를 각자 진행 방향으로 한 칸씩 이동 시킵니다.
두 인덱스가 서로 교차해서 지나치게 되어 while 루프를 빠져나왔다면 다음 재귀 호출의 분할 기준점이될 시작 인덱스를 리턴합니다.
 * */
