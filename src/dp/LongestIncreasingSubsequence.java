package dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 2, 5, 3, 1, 4, 5};
		int[] d = new int[nums.length+1];
		for (int i = 1; i <= nums.length; i++) {
			// d[i]表示前i个数字的最大非降子序列
			d[i] = i==1 ? 1: d[i-1];
			if (i >= 2) {
				if (nums[i-1] >= nums[i-2]) d[i] = d[i-1] + 1;
				else d[i] = d[i-1]>1 ? d[i-1]: 1;
			}
		}
		System.out.println(d[6]);
	}
	
	public static void recursive() {
		
	}
	
}
