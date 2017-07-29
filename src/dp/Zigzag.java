package dp;

public class Zigzag {

	public static void main(String[] args) {
		int[] nums = new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
		System.out.println(longestZigzag(nums));
	}
	
	public static int longestZigzag(int[] nums) {
		// d[i]，以nums[i]结尾的zigzag序列的最大长度
		// symbol[i]，以nums[i]结尾的最后一个差的符号
		if (nums.length == 1) return 1;
		int[] d = new int[nums.length];
		int[] symbol = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			if (i == 1) {
				d[i] = 2;
				symbol[i] = getSymbol(nums[i]-nums[i-1]);
			}
			for (int j = 1; j < i; j++) {
				if (symbol[j] > 0) {
					if (nums[j] > nums[i] && d[j]+1 > d[i]) {
						d[i] = d[j] + 1;
						symbol[i] = -1;
					}
				}
				if (symbol[j] < 0) {
					if (nums[j] < nums[i] && d[j]+1 > d[i]) {
						d[i] = d[j] + 1;
						symbol[i] = 1;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (d[i] > max) max = d[i];
		}
		return max;
	}
	
	public static int getSymbol(int num) {
		if (num < 0) return -1;
		else if (num == 0) return 0;
		return 1;
	}
	
}
