package exhaustion;

import java.util.Scanner;

/**
 * 遍历方格
 */
public class TraceBoard {
	
	int count = 0;
	
	public void moveOne(int line, int column, int x, int y) {
		if (x+1 == line && y+1 == column) count += 1;
		if (x+1 < line) moveOne(line, column, x+1, y);
		if (y+1 < column) moveOne(line, column, x, y+1);
	}
	
	public void traceBoard(int line, int column) {
		moveOne(line, column, 0, 0);
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] items = line.split(" ");
		TraceBoard t = new TraceBoard();
		t.traceBoard(Integer.parseInt(items[1])+1, Integer.parseInt(items[0])+1);
	}
	
}
