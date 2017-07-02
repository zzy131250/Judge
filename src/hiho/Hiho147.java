package hiho;

import java.util.Scanner;

public class Hiho147 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		String[] items;
		line = sc.nextLine();
		int count = Integer.parseInt(line);
		int[][] grades = new int[count][5];
		for (int i = 0; i < count; i++) {
			line = sc.nextLine();
			items = line.split(" ");
			for (int j = 0; j < items.length; j++) grades[i][j] = Integer.parseInt(items[j]);
		}
		for (int i = 0; i < count; i++) {
			int number = 0;
			for (int j = 0; j < count; j++) {
				boolean isBetter = true;
				for (int k = 0; k < 5; k++) {
					if (grades[i][k] < grades[j][k]) {
						isBetter = false;
						break;
					}
				}
				if (isBetter) number ++;
			}
			System.out.println(--number);
		}
		sc.close();
	}
	
}
