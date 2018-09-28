package leetcode;

public class _0167_NumSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int low = 0, high = numbers.length - 1; low < high;) {
            if (numbers[low] + numbers[high] == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            } else if(numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

}
