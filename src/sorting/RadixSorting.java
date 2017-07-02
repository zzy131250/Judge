package sorting;

public class RadixSorting {

	public static void main(String[] args) {
		int[] list = new int[5];
		list[0] = 4;
		list[1] = 2;
		list[2] = 1;
		list[3] = 3;
		list[4] = 5;
		radixSorting(list);
	}
	
	public static void radixSorting(int[] list) {
		int count = 0;
		for (int temp: list) {
			int length = Integer.toString(temp).length();
			if (length > count) count = length;
		}
		for (int i = 1; i <= count; i++) {
			for (int j = 1; j < list.length; j++) {
				//各个数位的排序采用直接插入排序
				int temp = list[j];
				int indexNum = getNumByIndex(list[j], i);
				int k;
				for (k = j-1; k >= 0 && indexNum < getNumByIndex(list[k], i); k--) list[k+1] = list[k];
				list[k+1] = temp;
			}
		}
		for (int temp: list) System.out.print(temp);
	}
	
	//根据位置返回数字，个位为1
	public static int getNumByIndex(int num, int index) {
		String numStr = Integer.toString(num);
		if (index > numStr.length()) return 0;
		else return Integer.parseInt(numStr.substring(numStr.length()-index, numStr.length()-index+1));
	}
	
}
