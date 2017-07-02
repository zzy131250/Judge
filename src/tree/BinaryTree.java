package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉树及其遍历

public class BinaryTree {
	
	static class Node {
		int value;
		Node left;
		Node right;
	}
	
	static Node root;

	public static void main(String[] args) {
		root = new Node();
		root.value = 0;
		Node left = new Node();
		left.value = 1;
		root.left = left;
		Node right = new Node();
		right.value = 2;
		root.right = right;
		Node ll = new Node();
		ll.value = 3;
		left.left = ll;
		Node lr = new Node();
		lr.value = 4;
		left.right = lr;
		Node rl = new Node();
		rl.value = 5;
		right.left = rl;
		preorderNonRecursive(root);
		System.out.println();
		inorderNonRecursive(root);
		System.out.println();
		postorderNonRecursive(root);
		System.out.println();
		levelorderNonRecursive(root);
	}
	
	//先序非递归
	public static void preorderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.print(root.value);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;
		}
	}
	
	//中序非递归
	public static void inorderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.value);
				//访问右边
				root = root.right;
			}
		}
	}
	
	//后序非递归
	public static void postorderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node visited = null;
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.peek();
				if (root.right != null && root.right != visited) {  //遍历右子树
					root = root.right;
					stack.push(root);
					root = root.left;
				} else {    //访问节点
					root = stack.pop();
					System.out.print(root.value);
					visited = root;
					root = null;
				}
			}
		}
	}
	
	//层序非递归
	public static void levelorderNonRecursive(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp != null) {
				System.out.print(temp.value);
				if (temp.left != null) queue.add(temp.left);
				if (temp.right != null) queue.add(temp.right);
			}
		}
	}
	
}
