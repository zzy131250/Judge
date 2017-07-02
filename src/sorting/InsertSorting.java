package sorting;

public class InsertSorting {

	public static void main(String[] args) {
		int[] list = new int[5];
		list[0] = 4;
		list[1] = 2;
		list[2] = 1;
		list[3] = 3;
		list[4] = 5;
//		directInsertSorting(list);
//		halfInsertSorting(list);
		shellSorting(list);
	}
	
	//直接插入排序
	public static void directInsertSorting(int[] list) {
		for (int i = 1; i < list.length; i++) {
			if (list[i] < list[i-1]) {
				int temp = list[i];
				int j;
				for (j = i-1; j >= 0 && temp < list[j]; j--) {  //逐个比较前面的元素
					list[j+1] = list[j];
				}
				list[j+1] = temp;
			}
		}
		printList(list);
	}
	
	//折半插入排序
	public static void halfInsertSorting(int[] list) {
		int low, mid, high;
		for (int i = 1; i < list.length; i++) {
			int temp = list[i];
			low = 0;
			high = i-1;
			while (low <= high){
				mid = (low + high) / 2;
				if (list[mid] < temp) low = mid+1;   //选取后半部分
				else high = mid-1;
			}
			for (int j = i-1; j >= high+1; j--) list[j+1] = list[j];
			list[high+1] = temp;
		}
		printList(list);
	}
	
	//希尔排序
	public static void shellSorting(int[] list) {
		for (int step = list.length / 2; step >=1; step /= 2) {
			for (int i = step; i < list.length; i += step) {   //内部使用直接插入排序
				if (list[i] < list[i-step]) {
					int temp = list[i];
					int j;
					for (j = i-step; j >= 0 && temp < list[j]; j -= step) list[j+step] = list[j];
					list[j+step] = temp;
				}
			}
		}
		printList(list);
	}
	
	public static void printList(int[] list) {
		for (int temp: list) System.out.print(temp);
		System.out.println();
	}
	
}
