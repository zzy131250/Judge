package sorting;

public class SelectSorting {

	public static void main(String[] args) {
		int[] list = new int[7];
		list[0] = 0;
		list[1] = 2;
		list[2] = 4;
		list[3] = -1;
		list[4] = 5;
		list[5] = -2;
		list[6] = 6;
//		simpleSelectSorting(list);
		heapSorting(list, list.length-1);
	}
	
	//简单选择排序
	public static void simpleSelectSorting(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int min = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[j] < list[min]) min = j;
			}
			int temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
		for (int temp: list) System.out.print(temp);
	}
	
	//堆排序,从1开始记元素
	public static void heapSorting(int[] list, int len) {
		buildMaxHeap(list, len);
		for (int i = len; i > 1; i--) {
			int temp = list[i];
			list[i] = list[1];
			list[1] = temp;
			adjustDown(list, 1, i-1);   //调整剩余子树
		}
		for (int i = 1; i < list.length; i++) System.out.print(list[i]);
	}
	
	public static void buildMaxHeap(int[] list, int len) {
		for (int i = len / 2; i > 0; i--) adjustDown(list, i, len);
		for (int i = 1; i < list.length; i++) System.out.print(list[i]);
		System.out.println();
	}
	
	//向下调整，用于删除
	public static void adjustDown(int[] list, int k, int len) {
		list[0] = list[k];
		for (int i = 2*k; i <= len; i *= 2) {
			if (i < len && list[i] < list[i+1]) i++;
			if (list[0] >= list[i]) break;
			else {
				list[k] = list[i];
				k = i;     //修改k值，以便继续向下筛选
			}
		}
		list[k] = list[0];
	}
	
	//向上调整，用于插入
	public static void adjustUp(int[] list, int k) {
		list[0] = list[k];
		for (int i = k / 2; i >= 1; i /= 2) {
			if (list[0] > list[i]) {
				list[k] = list[i];
				k = i;
			}
		}
		list[k] = list[0];
	}
	
}
