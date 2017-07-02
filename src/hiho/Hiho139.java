package hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class Hiho139 {
	
	static int count;
	static int snackNum;
	static double[] price;
	static int[] desire;
	static int maxDesire;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		count = Integer.parseInt(line);
		String[] items;
		for (int i = 0; i < count; i++) {
			maxDesire = 0;
			snackNum = Integer.parseInt(sc.nextLine());
			price = new double[snackNum];
			desire = new int[snackNum];
			for (int j = 0; j < snackNum; j++) {
				line = sc.nextLine();
				items = line.split(" ");
				price[j] = Double.parseDouble(items[0]);
				desire[j] = Integer.parseInt(items[1]);
			}
			// pick 1, 2, 3
			for (int j = 1; j <= 3; j++) {
				ArrayList<String> list = nPickM(snackNum, j);
				// analyze every plan
				for (String temp: list) {
					double totalPrice = 0.0;
					int totalDesire = 0;
					for (int k = 0; k < temp.length(); k++) {
						if (temp.charAt(k) == '1') {
							totalPrice += price[k];
							totalDesire += desire[k];
						}
					}
					if (totalPrice % 5 == 0 && totalDesire > maxDesire) maxDesire = totalDesire;
				}
			}
			System.out.println(maxDesire);
		}
		sc.close();
	}
	
	public static ArrayList<String> nPickM (int n, int m) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 1<<n; i++) {
			if (Integer.bitCount(i) == m) {
				String str = Integer.toBinaryString(i);
				while (str.length() < n) str = "0" + str;
				list.add(str);
			}
		}
		return list;
	}

}
