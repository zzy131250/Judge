package dp;

/**
 * 完全背包问题
 */
public class CompleteKnapsackProblem {

	public static void main(String[] args) {
		int[] volumes = new int[]{5, 4, 3};
		int[] values = new int[]{20, 10, 12};
		int C = 10;
		System.out.println(nonRecursive(volumes, values, volumes.length, C));
	}
	
	public static int recursive(int[] volumes, int[] values, int number, int volume) {
		if (number == 0) return 0;
		int maxValue = 0;
		for (int i = 0; i <= volume / volumes[number-1]; i++) {
			int value = 0;
			if (volume >= volumes[number-1]) value = recursive(volumes, values, number-1, volume-i*volumes[number-1]) + i*values[number-1];
			if (value > maxValue) maxValue = value;
		}
		return maxValue;
	}
	
	public static int nonRecursive(int[] volumes, int[] values, int number, int volume) {
		int[][] maxValues = new int[100][100];
		for (int i = 0; i <= number; i++) {
			for (int j = 0; j <= volume; j++) {
				if (i == 0) maxValues[i][j] = 0;
				// 选出第i个宝石不限数量放入时的最大值
				for (int k = 0; k <= volume/volumes[number-1]; k++) {
					if (i > 0 && j >= k*volumes[i-1]) {
						int value = maxValues[i-1][j-k*volumes[i-1]] + k*values[i-1];
						maxValues[i][j] = maxValues[i][j] > value ? maxValues[i][j] : value;
					}
				}
			}
		}
		return maxValues[number][volume];
	}
	
}
