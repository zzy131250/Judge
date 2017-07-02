package tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(1);
		System.out.println(set.size());
		String a = "123";
		String b = "123";
		ArrayList<String> list = new ArrayList<>();
		list.add(a);
		if (list.contains(b)) System.out.println("hhh");
	}
	
}
