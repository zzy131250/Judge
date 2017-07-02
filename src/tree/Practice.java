package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.BinaryTree.Node;

public class Practice {
	
	static class Node {
		int value;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		Node root = new Node();
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
		System.out.println(isAVLTree(root));
	}
	
	//判断一棵树是否为AVL树
	public static boolean isAVLTree(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp == null) {
				while (!queue.isEmpty()) {
					Node tmp = queue.poll();
					if (tmp != null) return false;
				}
			} else {
				queue.add(temp.left);
				queue.add(temp.right);
			}
		}
		return true;
	}
	
}
