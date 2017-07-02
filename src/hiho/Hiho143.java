package hiho;

import java.util.Scanner;

public class Hiho143 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		String[] items;
		line = sc.nextLine();
		line = sc.nextLine();
		items = line.split(" ");
		int[] nums = new int[items.length];
		for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(items[i]);
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			boolean ordered = true;
			for (int j = i; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[j] > nums[k]) ordered = false;
				}
			}
			if (ordered) {
				index = i;
				break;
			}
		}
		for (int i = 0; i < index; i++) System.out.print(nums[i] + " ");
		sc.close();
	}
	
}
