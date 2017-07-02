package hiho;

import java.util.Scanner;

public class No1369 {
	
	static int node;
	static int[][] g;
	static int maxFlow = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] items = line.split(" ");
		node = Integer.parseInt(items[0]);
		g = new int[node][node];
		for (int i = 0; i < node; i++) {
			for (int j = 0; j < node; j++) {
				g[i][j] = -1;
			}
		}
		int num = Integer.parseInt(items[1]);
		for (int n = 0; n < num; n++) {
			line = sc.nextLine();
			items = line.split(" ");
			if (g[Integer.parseInt(items[0])-1][Integer.parseInt(items[1])-1] == -1)
				g[Integer.parseInt(items[0])-1][Integer.parseInt(items[1])-1] = Integer.parseInt(items[2]);
			else {
				if (Integer.parseInt(items[2]) < g[Integer.parseInt(items[0])-1][Integer.parseInt(items[1])-1])
					g[Integer.parseInt(items[0])-1][Integer.parseInt(items[1])-1] = Integer.parseInt(items[2]);
			}
		}
		sc.close();
		calFlow(0, -1);
		System.out.println(maxFlow);
	}
	
	//(0, 1)(1, 3)(3, 5)/(0, 2)(2, 3)(3, 5)/(0, 2)(2, 4)(4, 5)
	public static void calFlow(int index, int min) {
		if (index >= node-1) {
			maxFlow += min;
			return;
		}
		for (int i = 0; i < node; i++) {
			if (g[index][i] != -1) {
				int localMin = min;
				if (localMin >= 0) {
					if (g[index][i] < localMin) localMin = g[index][i];
				} else {
					localMin = g[index][i];
				}
				calFlow(i, localMin);
			}
		}
	}
	
}
