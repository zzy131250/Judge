package dp;

public class BadNeighbors {
	// 分解为[0, n-1]最大与[1, n]最大两个问题，可避免考虑首尾是否相连的特殊情况

	public static void main(String[] args) {
		//max[x] = max[x-1] | max[x-2]+x | max[x-3] + x
		int[] donations = new int[]{ 10, 3, 2, 5, 7, 8 };
		System.out.println(maxDonations(donations, donations.length-1));
	}
	
	public static int maxDonations(int[] donations, int length) {
		if (length == 0) return 0;
		if (length == 1) return donations[length-1];
		if (length == 2) return donations[length-1] > donations[length-2] ? donations[length-1]: donations[length-2];
		int max1 = maxDonations(donations, length-1);
		int max2 = maxDonations(donations, length-2) + donations[length-1];
		int max3 = maxDonations(donations, length-3) + donations[length-1];
		int max = max1 > max2 ? max1: max2;
		return max > max3 ? max: max3;
		
//		int[] maxDs = new int[donations.length+1];
//		boolean[] isFirstIn = new boolean[donations.length+1];
//		maxDs[1] = donations[0];
//		isFirstIn[1] = true;
//		if (donations[0] > donations[1]) {
//			maxDs[2] = donations[0];
//			isFirstIn[2] = true;
//		} else {
//			maxDs[2] = donations[1];
//		}
//		for (int i = 3; i <= donations.length; i++) {
//			int max1 = maxDs[i-1];
//			int max2 = maxDs[i-2] + donations[i-1];
//			int max3 = maxDs[i-3] + donations[i-1];
//			if (i == donations.length) {
//				if (isFirstIn[i-1]) maxDs[i] = Arrays.stream(new int[]{max1, max2, max3}).max().getAsInt();
//				return maxDs[i];
//			}
//			if (max1 > max2) {
//				if (max1 > max3) {
//					maxDs[i] = max1;
//					isFirstIn[i] = isFirstIn[i-1];
//				} else {
//					maxDs[i] = max3;
//					isFirstIn[i] = isFirstIn[i-3];
//				}
//			} else {
//				if (max2 > max3) {
//					maxDs[i] = max2;
//					isFirstIn[i] = isFirstIn[i-2];
//				} else {
//					maxDs[i] = max3;
//					isFirstIn[i] = isFirstIn[i-3];
//				}
//			}
//		}
//		return 0;
	}
	
}
