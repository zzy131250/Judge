package hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Post {
	int x1, y1;
	int x2, y2;
	ArrayList<Post> overlap;
}

public class Hiho140 {
	
	static int width;
	static int height;
	static int number;
	static ArrayList<Post> postList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		String[] items;
		line = sc.nextLine();
		items = line.split(" ");
		width = Integer.parseInt(items[0]);
		height = Integer.parseInt(items[1]);
		number = Integer.parseInt(items[2]);
		postList = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			line = sc.nextLine();
			items = line.split(" ");
			Post post = new Post();
			post.overlap = new ArrayList<>();
			post.x1 = Integer.parseInt(items[0]);
			post.y1 = Integer.parseInt(items[1]);
			post.x2 = Integer.parseInt(items[2]);
			post.y2 = Integer.parseInt(items[3]);
			postList.add(post);
		}
		buildDAG();
		int max = 0;
		int start = 1;
		for (int i = 0; i < postList.size(); i++) {
			int tempMax = calMaxPost(postList.get(i), new ArrayList<Post>());
			if (tempMax > max) {
				max = tempMax;
				start = i+1;
			}
		}
		System.out.println(max + " " + start);
		sc.close();
	}
	
	public static int calMaxPost(Post start, ArrayList<Post> posts) {
		Queue<Post> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Post post = queue.poll();
			if (post != null && !posts.contains(post)) posts.add(post);
			for (Post temp: post.overlap) queue.add(temp);
		}
		return posts.size();
	}
	
	public static void buildDAG() {
		for (int i = 0; i < postList.size(); i++) {
			for (int j = i+1; j < postList.size(); j++) {
				if (isOverlap(postList.get(i), postList.get(j))) 
					postList.get(i).overlap.add(postList.get(j));
			}
		}
	}
	
	public static boolean isOverlap(Post p, Post q) {
		return !(p.x1 >= q.x2 || p.x2 <= q.x1 || p.y1 >= q.y2 || p.y2 <= q.y1);
	}
	
}
