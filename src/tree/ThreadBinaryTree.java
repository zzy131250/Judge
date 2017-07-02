package tree;

public class ThreadBinaryTree {
	
	static class ThreadNode {
		int value;
		ThreadNode left, right;
		int ltag, rtag;
	}
	
	static ThreadNode pre = null;

	public static void main(String[] args) {
		ThreadNode root = new ThreadNode();
		ThreadNode l = new ThreadNode();
		ThreadNode r = new ThreadNode();
		ThreadNode lr = new ThreadNode();
		ThreadNode rl = new ThreadNode();
		root.value = 0;
		l.value = 1;
		r.value = 2;
		lr.value = 3;
		rl.value = 4;
		root.left = l;
		root.right = r;
		l.right = lr;
		r.left = rl;
		createInThread(root);
		inOrder(root);
	}
	
	public static void createInThread(ThreadNode root) {
		if (root != null) {
			inThread(root);
			pre.right = null;
			pre.rtag = 1;
		}
	}
	
	//中序遍历对二叉树线索化
	public static void inThread(ThreadNode p) {
		if (p != null) {
			inThread(p.left);
			if (p.left == null) {
				p.left = pre;
				p.ltag = 1;
			}
			if (pre != null && pre.right == null) {
				pre.right = p;
				pre.rtag = 1;
			}
			pre = p;
			inThread(p.right);
		}
	}
	
	//中序遍历第一个节点
	public static ThreadNode firstNode(ThreadNode p) {
		while (p.ltag == 0) p = p.left;
		return p;
	}
	
	//中序遍历后一个节点
	public static ThreadNode nextNode(ThreadNode p) {
		if (p.rtag == 0) return firstNode(p.right);
		else return p.right;
	}
	
	//中序遍历
	public static void inOrder(ThreadNode root) {
		for (ThreadNode p = firstNode(root); p != null; p = nextNode(p)) {
			System.out.print(p.value);
		}
	}
	
}
