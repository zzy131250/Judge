package hiho;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
	int x;
	int y;
}

//仅考虑了平行线的最小间距
public class Hiho142 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		String[] items;
		int times;
		line = sc.nextLine();
		times = Integer.parseInt(line);
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			line = sc.nextLine();
			items = line.split(" ");
			int point_num = Integer.parseInt(items[0]);
			int size = Integer.parseInt(items[1]);
			ArrayList<Point> points = new ArrayList<>();
			for (int j = 0; j < point_num; j++) {
				line = sc.nextLine();
				items = line.split(" ");
				Point point = new Point();
				point.x = Integer.parseInt(items[0]);
				point.y = Integer.parseInt(items[1]);
				points.add(point);
			}
			if (canClean(size, points)) result.add("Yes");
			else result.add("No");
		}
		for (String temp: result) System.out.println(temp);
		sc.close();
	}
	
	public static boolean canClean(int size, ArrayList<Point> points) {
		int minX;
		int minY;
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < points.size(); i++) {
			nums.add(points.get(i).x);
		}
		minX = calMinPositive(nums);
		nums.clear();
		for (int i = 0; i < points.size(); i++) {
			nums.add(points.get(i).y);
		}
		minY = calMinPositive(nums);
		return (minX >= size && minY >= size);
	}
	
	public static int calMinPositive(ArrayList<Integer> nums) {
		int minP = 0;
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i+1; j < nums.size(); j++) {
				int diff = nums.get(i) - nums.get(j);
				if (diff < 0) diff = -diff;
				if (minP == 0) minP = diff;
				else {
					if (diff != 0 && diff < minP) minP = diff;
				}
			}
		}
		return minP;
	}
	
}
