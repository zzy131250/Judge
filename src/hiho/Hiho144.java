package hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class Hiho144 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		String[] items;
		line = sc.nextLine();
		items = line.split(" ");
		int N = Integer.parseInt(items[0]);
		int M = Integer.parseInt(items[1]);
		ArrayList<Integer> appN = new ArrayList<>();
		ArrayList<Integer> appM = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) appN.add(i);
		}
		for (int i = 1; i <= M; i++) {
			if (M % i == 0) appM.add(i);
		}
		int count = 0;
		for (int i = 0; i < appN.size(); i++) {
			for (int j = 0; j < appM.size(); j++) {
				if (appN.get(i) == appM.get(j)) {
					count ++;
					break;
				}
			}
		}
		int all = appN.size() * appM.size();
		for (int i = 1; i <= count; i++) {
			if (count % i == 0 && all % i == 0) {
				count /= i;
				all /= i;
			}
		}
		System.out.println(all + " " + count);
		sc.close();
	}
	
}
