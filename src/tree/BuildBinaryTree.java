package tree;

import java.util.LinkedList;
import java.util.Queue;

//先序中序，后序中序构造二叉树
public class BuildBinaryTree {
	
	static String pre = "013425";
	static String in = "314052";
	static String post = "341520";
	
	static class Node {
		int value;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		preIn(pre, in);
		inPost(in, post);
	}
	
	public static void preIn(String pre, String in) {
		Node root = buildTreeByPreIn(pre, in);
		levelPrint(root);
	}
	
	public static Node buildTreeByPreIn(String pre, String in) {
		if (in.length() == 0) return null;
		if (in.length() == 1) {
			Node node = new Node();
			node.value = Integer.parseInt(in);
			return node;
		}
		//在中序中找出根（在先序中最先出现）
		String value = "";
		for (int i = 0; i < pre.length(); i++) {
			value = pre.substring(i, i+1);
			if (in.contains(value)) break;
		}
		String leftIn = "", rightIn = "";
		for (int i = 0; i < in.length(); i++) {
			if (in.substring(i, i+1).equals(value)) {
				leftIn = in.substring(0, i);
				rightIn = in.substring(i+1);
				break;
			}
		}
		Node node = new Node();
		node.value = Integer.parseInt(value);
		node.left = buildTreeByPreIn(pre, leftIn);
		node.right = buildTreeByPreIn(pre, rightIn);
		return node;
	}
	
	public static void inPost(String in, String post) {
		Node root = buildTreeByInPost(in, post);
		levelPrint(root);
	}
	
	public static Node buildTreeByInPost(String in, String post) {
		if (in.length() == 0) return null;
		if (in.length() == 1) {
			Node node = new Node();
			node.value = Integer.parseInt(in);
			return node;
		}
		//在中序中找出根（在后序中最后出现）
		String value = "";
		for (int i = post.length()-1; i >= 0; i--) {
			value = post.substring(i, i+1);
			if (in.contains(value)) break;
		}
		String leftIn = "", rightIn = "";
		for (int i = 0; i < in.length(); i++) {
			if (in.substring(i, i+1).equals(value)) {
				leftIn = in.substring(0, i);
				rightIn = in.substring(i+1);
				break;
			}
		}
		Node node = new Node();
		node.value = Integer.parseInt(value);
		node.left = buildTreeByInPost(leftIn, post);
		node.right = buildTreeByInPost(rightIn, post);
		return node;
	}
	
	public static void levelPrint(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.value);
			if (temp.left != null) queue.add(temp.left);
			if (temp.right != null) queue.add(temp.right);
		}
		System.out.println();
	}
	
}
