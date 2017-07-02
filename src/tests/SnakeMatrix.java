package tests;

import java.util.Scanner;

public class SnakeMatrix {
	
	static int[][] matrix;
	static int directX = 0;
	static int directY = 1;
	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		num = Integer.parseInt(n);
		int i = 1;
		int x = 0;
		int y = 0;
		matrix = new int[num][num];
		while (i <= num * num) {
			System.out.println("(" + x + ", " + y + ")");
			checkPos(x, y);
			matrix[x][y] = i;
			x += directX;
			y += directY;
			i++;
		}
	}
	
	public static void checkPos(int x, int y) {
		if (x + directX == num || y + directY == num) {
			changeDirect();
			return;
		}
		if (y + directY < 0) {
			changeDirect();
			return;
		}
		if (matrix[x+directX][y+directY] != 0) changeDirect();
	}
	
	public static void changeDirect() {
		if (directX == 0 && directY == 1) {
			directX = 1;
			directY = 0;
		} else if (directX == 1 && directY == 0) {
			directX = 0;
			directY = -1;
		} else if (directX == 0 && directY == -1) {
			directX = -1;
			directY = 0;
		} else {
			directX = 0;
			directY = 1;
		}
	}
	
}
