package sorting;

public class ExchangeSorting {

	public static void main(String[] args) {
		int[] list = new int[5];
		list[0] = 4;
		list[1] = 2;
		list[2] = 3;
		list[3] = 1;
		list[4] = 5;
//		bubbleSorting(list);
		quickSortingRecursive(list, 0, list.length-1);
		for (int temp: list) System.out.print(temp);
//		doubleBubbleSorting(list);
	}
	
	//冒泡排序，每次排出最小值
	public static void bubbleSorting(int[] list) {
		for (int i = 0; i < list.length; i++) {
			boolean flag = false;
			for (int j = list.length-1; j > i; j--) {
				if (list[i] > list[j]) {
					flag = true;
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
			if (!flag) return;
		}
		for (int temp: list) System.out.print(temp);
	}
	
	//快速排序递归算法
	public static void quickSortingRecursive(int[] list, int low, int high) {
		if (low < high) {
			int pivotPos = partition(list, low, high);
			quickSortingRecursive(list, low, pivotPos-1);
			quickSortingRecursive(list, pivotPos+1, high);
		}
	}
	
	//一趟排序
	private static int partition(int[] list, int low, int high) {
		int pivot = list[low];
		while (low < high) {
			while (low < high && list[high] >= pivot) high--;
			list[low] = list[high];
			while (low < high && list[low] <= pivot) low++;
			list[high] = list[low];
		}
		list[low] = pivot;
		return low;
	}
	
	//双向冒泡排序
	public static void doubleBubbleSorting(int[] list) {
		int low = 0;
		int high = list.length-1;
		boolean flag = true;
		while (low < high && flag) {
			flag = false;
			for (int i = low; i < high; i++) {
				if (list[i] > list[i+1]) {
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					flag = true;
				}
			}
			high--;
			for (int i = high; i > low; i--) {
				if (list[i] < list[i-1]) {
					int temp = list[i];
					list[i] = list[i-1];
					list[i-1] = temp;
					flag = true;
				}
			}
			low++;
		}
		for (int temp: list) System.out.print(temp);
	}
	
}
