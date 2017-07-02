package sorting;

public class MergeSorting {

	public static void main(String[] args) {
		int[] list = new int[7];
		list[0] = 0;
		list[1] = 2;
		list[2] = 4;
		list[3] = -1;
		list[4] = 5;
		list[5] = -2;
		list[6] = 6;
		mergeSorting(list, 0, list.length-1);
		for (int temp: list) System.out.print(temp);
	}
	
	public static void mergeSorting(int[] list, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSorting(list, low, mid);
			mergeSorting(list, mid+1, high);
			merge(list, low, mid, high);
		}
	}
	
	public static void merge(int[] list, int low, int mid, int high) {
		int[] tmpList = new int[list.length];
		for (int i = 0; i < list.length; i++) tmpList[i] = list[i];
		int i, j, k;
		for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
			if (tmpList[i] <= tmpList[j]) list[k] = tmpList[i++];
			else list[k] = tmpList[j++];
		}
		while (i <= mid) list[k++] = tmpList[i++];
		while (j <= high) list[k++] = tmpList[j++];
	}
	
}
