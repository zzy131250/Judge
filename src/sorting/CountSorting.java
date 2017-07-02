package sorting;

//计数排序
public class CountSorting {
	
	public static void main(String[] args) {
		int[] list = new int[5];
		list[0] = 4;
		list[1] = 2;
		list[2] = 3;
		list[3] = -1;
		list[4] = 5;
		countSorting(list);
	}
	
	public static void countSorting(int[] list) {
		int[] count = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[j] < list[i]) count[i]++;
			}
		}
		int[] sorted = new int[list.length];
		for (int i = 0; i < sorted.length; i++) sorted[count[i]] = list[i];
		for (int temp: sorted) System.out.print(temp);
	}
	
}
