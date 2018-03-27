package backtrack;

import java.util.Scanner;

//dfs
/*
2 1 3 0 0 0 7 0 0
0 0 9 0 0 2 0 0 0
0 7 8 4 0 0 0 0 6
0 9 0 0 8 0 0 0 0
7 0 2 0 4 0 6 0 3
0 0 0 0 7 0 0 5 0
9 0 0 0 0 6 8 7 0
0 0 0 5 0 0 4 0 0
0 0 7 0 0 0 5 6 9
 */

public class Sudoku {
	
	static int[][] sudoku;
	static int line = 9;

	public static void main(String[] args) {
		sudoku = new int[line][line];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < line; i++) {
			String temp = sc.nextLine();
			String[] items = temp.split(" ");
			for (int j = 0; j < line; j++) {
				sudoku[i][j] = Integer.parseInt(items[j]);
			}
		}
		sc.close();
		addNum(sudoku, 0);
	}
	
	public static boolean addNum(int[][] sudoku, int index) {
		if (index == 81) {
			for (int i = 0; i < line; i++) {
				for (int j = 0; j < line; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}
		int m = index / line;
		int n = index % line;
		
		if (sudoku[m][n] != 0) {
			int[][] copy = copySudoku(sudoku);
			return addNum(copy, index+1);
		}
		
		for (int i = 1; i <= 9; i ++) {
			if (isUnique(sudoku, i, m, n)) {
				int[][] copy = copySudoku(sudoku);
				copy[m][n] = i;
				if (addNum(copy, index+1)) return true;
				copy[m][n] = 0;
			}
		}
		return false;
	}
	
	public static int[][] copySudoku(int[][] sudoku) {
		int[][] copy = new int[line][line];
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				copy[i][j] = sudoku[i][j];
			}
		}
		return copy;
	}
	
	public static boolean isUnique(int[][] sudoku, int num, int m, int n) {
		for (int i = 0; i < line; i++) {
			if (sudoku[m][i] == num || sudoku[i][n] == num) return false;
		}
		//检查每个9宫格
		for (int i = m/3*3; i < m/3*3+3; i++) {
			for (int j = n/3*3; j < n/3*3+3; j++) {
				if (sudoku[i][j] == num) return false;
			}
		}
		return true;
	}
	
}
