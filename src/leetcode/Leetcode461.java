package leetcode;

public class Leetcode461 {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}
	
	public static int hammingDistance(int x, int y) {
		int distance = 0;
        while (x / 2 != 0 || y / 2 != 0) {
        	if (x % 2 != y % 2) distance += 1;
        	x = x / 2;
        	y = y / 2;
        }
        if (x != y) distance += 1;
        return distance;
    }
	
}
