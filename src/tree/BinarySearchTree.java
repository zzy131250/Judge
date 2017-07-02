package tree;

public class BinarySearchTree {
	
	static class Node {
		int value;
		Node left;
		Node right;
	}
	
	static Node root;

	public static void main(String[] args) {
		
	}
	
	public static void insert(int num) {
		while (root != null) {
			if (num < root.value) {
				if (root.left == null) {
					Node tmp = new Node();
					tmp.value = num;
					root.left = tmp;
					break;
				} else {
					root = root.left;
				}
			}
			else {
				if (root.right == null) {
					Node tmp = new Node();
					tmp.value = num;
					root.right = tmp;
					break;
				} else {
					root = root.right;
				}
			}
		}
	}
	
	public static void delete(int num) {
		
	}
	
}
