package hiho;

import java.util.ArrayList;
import java.util.Scanner;

public class Hiho157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int count = Integer.parseInt(line);
		ArrayList<String> resultList = new ArrayList<>();
		for(int i = 0; i < count; i++) {
			line = sc.nextLine();
			line = line.substring(2);
			int[] bits = new int[line.length()];
			for(int j = 0; j < line.length(); j++) bits[j] = Integer.parseInt(line.substring(j, j+1));
			ArrayList<Integer> binaryNum = new ArrayList<>();
			boolean divisible = false;
			for(int j = 0; j < line.length(); j++) {
				bits = multiple2Minus1(bits, binaryNum);
				if(isDivisible(bits)) {
					divisible = true;
					break;
				}
			}
			if(divisible) {
				String result = "0.";
				for(int j = 0; j < binaryNum.size(); j++) result += Integer.toString(binaryNum.get(j));
				resultList.add(result);
			} else {
				resultList.add("NO");
			}
		}
		for(String temp: resultList) System.out.println(temp);
		sc.close();
	}
	
	public static int[] multiple2Minus1(int[] bits, ArrayList<Integer> binaryNum) {
		int[] newBits = new int[bits.length];
		boolean isCarry = false;
		for(int i = bits.length-1; i >= 0; i--) {
			newBits[i] = bits[i] * 2 % 10;
			if(isCarry) newBits[i]++;
			if(bits[i] * 2 / 10 == 1) isCarry = true;
			else isCarry = false;
		}
		if(isCarry) binaryNum.add(1);
		else binaryNum.add(0);
		return newBits;
	}
	
	public static boolean isDivisible(int[] bits) {
		boolean divisible = true;
		for(int temp: bits) {
			if(temp != 0) {
				divisible = false;
				break;
			}
		}
		return divisible;
	}
	
}
