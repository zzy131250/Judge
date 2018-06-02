package scan;

/**
 * 连续子数组最大值
 * 最优方法，时间复杂度O（n）
 * 和最大的子序列的第一个元素肯定是正数
 * 因为元素有正有负，因此子序列的最大和一定大于0
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int max = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > max) max = currentSum;
            if (currentSum < 0) currentSum = 0;
        }
        System.out.println(max);
    }

}
