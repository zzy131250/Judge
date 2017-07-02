package tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WirelessRouter {
	
	static int[] satisfaction;
	//store doors between rooms
	static ArrayList<Set<Integer>> doors;
	//list of ways to put routers
	static ArrayList<String> list;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] items = line.split(" ");
		int n = Integer.parseInt(items[0]);
		int m = Integer.parseInt(items[1]);
		line = sc.nextLine();
		items = line.split(" ");
		satisfaction = new int[items.length];
		for (int i = 0; i < items.length; i++) satisfaction[i] = Integer.parseInt(items[i]);
		doors = new ArrayList<>();
		for (int i = 0; i < n-1; i++) {
			line = sc.nextLine();
			items = line.split(" ");
			Set<Integer> set = new HashSet<Integer>();
			set.add(Integer.parseInt(items[0])-1);
			set.add(Integer.parseInt(items[1])-1);
			doors.add(set);
		}
		sc.close();
		String str = "";
		for (int i = 0; i < m; i++) str += "1";
		while (str.length() < n) str += "0";
		list = new ArrayList<>();
		pickRooms(str);
		for (int i = 0; i < list.size(); i++) {
			calSatisfaction(list.get(i));
		}
		System.out.println(max);
	}
	
	//pick rooms that put the routers
	//select combination of a string, 1 for put and 0 for not put
	public static void pickRooms(String str) {
		//check if the way has been added
		boolean added = false;
		for (int i = str.length()-1; i > 0; i--) {
			if (str.charAt(i) == '0' && str.charAt(i-1) == '1') {
				added = true;
				if (!list.contains(str)) list.add(str);
				str = str.substring(0, i-1) + "01" + str.substring(i+1);
				pickRooms(str);
			}
		}
		if (!added && !list.contains(str)) list.add(str);
	}
	
	//calculate the satisfaction of a choice
	public static void calSatisfaction(String rooms) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < rooms.length(); i++) {
			if (rooms.charAt(i) == '1') {
				set.add(i);
				for (Set<Integer> temp: doors) {
					if (temp.contains(i)) set.addAll(temp);
				}
			}
		}
		//calculate satisfaction
		int sum = 0;
		for (Integer temp: set) sum += satisfaction[temp];
		if (sum > max) max = sum;
	}
	
}
