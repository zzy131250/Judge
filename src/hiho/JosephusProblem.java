package hihocoder;

import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		final int num = Integer.parseInt(line);
		int[] result = new int[num];
		ArrayList<String> lines = new ArrayList<String>();
		for (int i = 0; i < num; i ++) lines.add(sc.nextLine());
		for (int i = 0; i < num; i ++) {
			String[] item = lines.get(i).split(" ");
			int n = Integer.parseInt(item[0]);
			int k = Integer.parseInt(item[1]);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < n; j ++) list.add(j);
			int index = 0;
			int j = 1;
			while (j <= k) {
				if (list.size() == 1) break;
				if (j == k) {
					list.remove(index);
					j = 1;
				} else {
					j ++;
					index ++;
				}
				if (index == list.size()) index = 0;
			}
			result[i] = list.get(0);
		}
		for (int i : result) System.out.println(i);
		sc.close();
	}
	
}
