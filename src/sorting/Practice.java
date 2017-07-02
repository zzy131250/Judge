package sorting;

public class Practice {

	public static void main(String[] args) {
		int[] list = new int[5];
		list[0] = 4;
		list[1] = 2;
		list[2] = 0;
		list[3] = -1;
		list[4] = 5;
//		System.out.println(findKthSmall(list, 0, list.length-1, 4));
		partitionNegetivePositive(list);
	}
	
	//基于快排找出第k小的元素，不够完善
	public static int findKthSmall(int[] list, int low, int high, int k) {
		int pivotPos = partition(list, low, high);
		if (pivotPos == k) return list[pivotPos];
		else if (pivotPos < k) return findKthSmall(list, pivotPos+1, high, high-k);
		else return findKthSmall(list, low, pivotPos-1, k);
	}
	
	public static int partition(int[] list, int low, int high) {
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
	
	//将数组排成负数，0，正数的形式
	public static void partitionNegetivePositive(int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == 0) {
				list[i] = list[0];
				list[0] = 0;
			}
		}
		partition(list, 0, list.length-1);
		for (int temp: list) System.out.print(temp);
	}
	
}
