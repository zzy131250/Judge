package hiho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Plane {
	int airValue;
	int damageValue;
}

class Ship {
	int[] capacity;
	List<Plane> planeList;
}

public class Hiho138 {
	
	static String line;
	static String[] items;
	static int ships, equipments, planes, minAirValue;
	static List<Ship> shipList;
	static List<Plane> planeList;
	static List<Plane> airPlaneList;
	static List<Plane> shipPlaneList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < times; i++) {
			line = sc.nextLine();
			items = line.split(" ");
			ships = Integer.parseInt(items[0]);
			equipments = Integer.parseInt(items[1]);
			planes = Integer.parseInt(items[2]);
			minAirValue = Integer.parseInt(items[3]);
			shipList = new ArrayList<>();
			planeList = new ArrayList<>();
			for (int j = 0; j < ships; j++) {
				line = sc.nextLine();
				items = line.split(" ");
				Ship ship = new Ship();
				ship.capacity = new int[equipments];
				ship.planeList = new ArrayList<>();
				for (int k = 0; k < equipments; k++) ship.capacity[k] = Integer.parseInt(items[k]);
				shipList.add(ship);
			}
			line = sc.nextLine();
			items = line.split(" ");
			for (int j = 0; j < planes; j++) {
				Plane plane = new Plane();
				plane.airValue = Integer.parseInt(items[j]);
				planeList.add(plane);
			}
			line = sc.nextLine();
			items = line.split(" ");
			for (int j = 0; j < planes; j++) {
				Plane plane = planeList.get(j);
				plane.damageValue = Integer.parseInt(items[j]);
			}
			// classify plane to air plane and ship plane
			airPlaneList = new ArrayList<>();
			shipPlaneList = new ArrayList<>();
			for (int j = 0; j < planes; j++) {
				Plane plane = planeList.get(j);
				if (plane.airValue == 0) shipPlaneList.add(plane);
				else airPlaneList.add(plane);
			}
			// sort plane list high to low
			Collections.sort(airPlaneList, new Comparator<Plane>() {
				@Override
				public int compare(Plane p1, Plane p2) {
					return p2.airValue - p1.airValue;
				}
			});
			Collections.sort(shipPlaneList, new Comparator<Plane>() {
				@Override
				public int compare(Plane p1, Plane p2) {
					return p2.damageValue - p1.damageValue;
				}
			});
			// 选出装备栏方案，对于每种方案，把伤害最高的放到最前面
		}
		sc.close();
	}
	
}
