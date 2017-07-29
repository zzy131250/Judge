package dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 2, 5, 7, 6, 8, 16, 5};
		System.out.println(recursive(nums, 9));
	}
	
	public static int recursive(int[] nums, int index) {
		if (index == 1) return 1;
		int d = 0;
		for (int i = 1; i <= index; i++) {
			int tempD = recursive(nums, i);
//			if (nums[])
		}
		return 0;
	}
	
	public static int nonRecursive(int[] nums, int index) {
		int[] d = new int[nums.length+1];
		for (int i = 1; i <= nums.length; i++) {
			// d[i]表示以第i个数字结尾的最大非降子序列长度
			if (i == 1) d[i] = 1;
			// 遍历d[j]，找出最大的d[j]，且满足第j个数字小于第i个数字
			// 这样，d[i]=d[j]+1，否则d[i]=1
			for (int j = 1; j < i; j++) {
				if (nums[j-1] < nums[i-1] && d[j]+1 > d[i]) d[i] = d[j]+1;
			}
			d[i] = d[i] > 1 ? d[i] : 1;
		}
		int max = 0;
		// 遍历各个最大非降子序列长度值，返回前index个数字中最大的非降子序列长度
		for (int i = 1; i <= index; i++) {
			if (max < d[i]) max = d[i];
		}
		return max;
	}
	
}
