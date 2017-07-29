package hiho;

import java.util.Scanner;

public class Hiho160 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int count = Integer.parseInt(line);
		for (int i = 0; i < count; i++) {
			line = sc.nextLine();
		}
		sc.close();
	}
	
}
