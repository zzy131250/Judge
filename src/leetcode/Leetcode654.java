package leetcode;

public class Leetcode654 {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		System.out.println(constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}).val);
	}
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
	
	public static TreeNode buildTree(int[] nums, int startIndex, int endIndex) {
		if (startIndex > endIndex) return null;
		int maxIndex = startIndex;
		for (int i = startIndex; i <= endIndex; i++) {
			if (nums[i] > nums[maxIndex]) maxIndex = i; 
		}
		TreeNode node = new TreeNode(nums[maxIndex]);
		node.left = buildTree(nums, startIndex, maxIndex-1);
		node.right = buildTree(nums, maxIndex+1, endIndex);
		return node;
	}
	
}
