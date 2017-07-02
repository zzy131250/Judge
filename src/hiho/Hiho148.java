package hiho;

import java.util.Scanner;

public class Hiho148 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests;
		String line;
		String[] items;
		line = sc.nextLine();
		tests = Integer.parseInt(line);
		int[] paragraphs = new int[tests];
		int[] maxPages = new int[tests];
		int[] width = new int[tests];
		int[] height = new int[tests];
		int[][] characters = new int[tests][];
		for (int i = 0; i < tests; i++) {
			line = sc.nextLine();
			items = line.split(" ");
			paragraphs[i] = Integer.parseInt(items[0]);
			maxPages[i] = Integer.parseInt(items[1]);
			width[i] = Integer.parseInt(items[2]);
			height[i] = Integer.parseInt(items[3]);
			characters[i] = new int[paragraphs[i]];
			line = sc.nextLine();
			items = line.split(" ");
			for (int j = 0; j < characters[i].length; j++) characters[i][j] = Integer.parseInt(items[j]);
		}
		sc.close();
		for (int i = 0; i < tests; i++) {
			System.out.println(getMaxFontSize(1, width[i], width[i], height[i], characters[i], maxPages[i]));
		}
	}
	
	public static int getMaxFontSize(int begin, int end, int width, int height, int[] characters, int maxPages) {
		int middle = (begin + end) / 2;
		if (begin == middle) return begin;
		if (isEnough(middle, width, height, characters, maxPages)) return getMaxFontSize(middle, end, width, height, characters, maxPages);
		else return getMaxFontSize(begin, middle, width, height, characters, maxPages);
	}
	
	public static boolean isEnough(int fontSize, int width, int height, int[] characters, int maxPages) {
		int lineCapacity = width / fontSize;
		int lineSum = 0;
		for (int i = 0; i < characters.length; i++) {
			lineSum += calculateOneParagraphLine(characters[i], lineCapacity);
		}
		int maxLines = height / fontSize * maxPages;
		if (lineSum > maxLines) return false;
		return true;
	}
	
	public static int calculateOneParagraphLine(int character, int lineCapacity) {
		if (character % lineCapacity == 0) return character / lineCapacity;
		else return character / lineCapacity + 1;
	}
	
}
