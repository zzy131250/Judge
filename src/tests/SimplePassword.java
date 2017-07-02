package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimplePassword {
	
	static Map<Character, String> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String password = sc.nextLine();
		initMap();
		System.out.println(encrypt(password));
	}
	
	public static String encrypt(String str) {
		String pass = "";
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp >= 97 && temp <= 122) pass += map.get(temp);
			else if (temp >= '0' && temp <= '9') pass += temp;
			else if (temp == 'Z') pass += "a";
			else {
				temp += 33;
				pass += temp;
			}
		}
		return pass;
	}
	
	public static void initMap() {
		map = new HashMap<Character, String>();
		int num = 1;
		for (char i = 97; i <= 111; i++) {
			if (i % 3 == 1) num++;
			map.put(i, Integer.toString(num));
		}
		for (char i = 112; i <= 115; i++) {
			map.put(i, "7");
		}
		for (char i = 116; i <= 118; i++) {
			map.put(i, "8");
		}
		for (char i = 119; i <= 122; i++) {
			map.put(i, "9");
		}
	}
	
}
