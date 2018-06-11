package dp;

/**
 * 背包问题
 */
public class KnapsackProblem {

	public static void main(String[] args) {
		int[] volumes = new int[]{5, 4, 3};
		int[] values = new int[]{20, 10, 12};
		int C = 10;
		System.out.println(nonRecursive(volumes, values, volumes.length, C));
//		System.out.println(recursive(volumes, values, volumes.length, C));
	}
	
	// 返回前number个宝石放入体积为volume的背包可以获得的最大价值
	public static int recursive(int[] volumes, int[] values, int number, int volume) {
		// number从1开始，如果number为0，最大价值为0
		if (number == 0) return 0;
		// 判断第number个宝石是否放入
		// 第number个宝石不放入背包，计算最大价值
		int notAdded = recursive(volumes, values, number-1, volume);
		// 第number个宝石放入背包，计算最大价值
		int added = 0;
		// 放入背包前确保有足够空间
		if (volume >= volumes[number-1]) {
			added = recursive(volumes, values, number-1, volume-volumes[number-1]) + values[number-1];
		}
		return notAdded > added ? notAdded : added;
	
	}
	
	// 返回前number个宝石放入体积为volume的背包可以获得的最大价值
	public static int nonRecursive(int[] volumes, int[] values, int number, int volume) {
		// maxValues[i][j]: 前i个宝石装入剩余容量为j的背包中的最大价值
		int[][] maxValues = new int[100][100];
		for (int i = 0; i <= number; i++) {
			for (int j = 0; j <= volume; j++) {
				// 前0个宝石放入背包，最大价值均为0
				// 第i个宝石不放入背包，计算最大价值
				maxValues[i][j] = i==0 ? 0 : maxValues[i-1][j];
				// 确保有足够空间放入宝石
				if (i > 0 && j >= volumes[i-1]) {
					// 第i个宝石放入背包，计算最大价值
					int added = maxValues[i-1][j-volumes[i-1]] + values[i-1];
					maxValues[i][j] = maxValues[i][j] > added ? maxValues[i][j] : added;
				}
			}
		}
		// 返回要求计算的最大价值
		return maxValues[number][volume];
	}
	
}
