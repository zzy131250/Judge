package hiho;

import java.util.Scanner;

public class Hiho145 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		String[] items;
		line = sc.nextLine();
		int time = Integer.parseInt(line);
		for (int i = 0; i < time; i++) {
			int level;
			int chance;
			int rightPoint;
			int wrongPoint;
			line = sc.nextLine();
			items = line.split(" ");
			level = Integer.parseInt(items[0]);
			chance = Integer.parseInt(items[1]);
			rightPoint = Integer.parseInt(items[2]);
			wrongPoint = Integer.parseInt(items[3]);
			int[] levelPoint = new int[level];
			line = sc.nextLine();
			items = line.split(line);
			for (int j = 0; j < level; j++) levelPoint[j] = Integer.parseInt(items[j]);
			
		}
		sc.close();
	}
	
}
