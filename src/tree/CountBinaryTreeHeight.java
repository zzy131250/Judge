package tree;

import java.util.LinkedList;
import java.util.Queue;

//层次遍历求二叉树高度（链表存储）
public class CountBinaryTreeHeight {
	
	static class Node {
		int value;
		Node left;
		Node right;
		int level;
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.value = 0;
		root.level = 1;
		Node l = new Node();
		l.value = 1;
		Node r = new Node();
		r.value = 2;
		Node ll = new Node();
		ll.value = 3;
		Node lr = new Node();
		lr.value = 4;
		Node rl = new Node();
		rl.value = 5;
		root.left = l;
		root.right = r;
		l.left = ll;
		l.right = lr;
		r.left = rl;
		System.out.println(calHeight(root));
	}
	
	public static int calHeight(Node root) {
		int height = root.level;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.level > height) height = temp.level;
			if (temp.left != null) {
				temp.left.level = temp.level + 1;
				queue.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.level = temp.level + 1;
				queue.add(temp.right);
			}
		}
		return height;
	}
	
}