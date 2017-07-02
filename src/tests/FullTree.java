package tests;

import java.util.Scanner;

public class FullTree {
	
	static String[] midTree;
	static String[] tree;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		midTree = line.split(" ");
		tree = new String[midTree.length];
		getNode(0, midTree.length-1);
		for (String temp: tree) {
			System.out.print(temp + " ");
		}
	}
	
	public static void getNode(int left, int right) {
		int mid = (left + right) / 2;
		tree[count++] = midTree[mid];
		if (mid == left) return;
		getNode(left, mid-1);
		getNode(mid+1, right);
	}
	
}
