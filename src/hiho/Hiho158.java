package hiho;

import java.util.Scanner;

public class Hiho158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		System.out.println(cal(Integer.parseInt(line)) % ((int)Math.pow(10, 9)+7));
		sc.close();
	}
	
	// 非法数字数，合法且第一位为1的数字数，合法且第一位为0的数字数
	public static int[] calIllegalNum(int numOfBits) {
		if(numOfBits == 1) return new int[]{0, 1, 1};
		int[] lastResult = calIllegalNum(numOfBits-1);
		int f = lastResult[0] * 2 + lastResult[1];
		int g = lastResult[2];
		return new int[]{f, g, (int) Math.pow(2, numOfBits)-f-g};
	}
	
	public static int cal(int numOfBits) {
		int[] f = new int[numOfBits+1];
		int[] g = new int[numOfBits+1];
		int[] h = new int[numOfBits+1];
		for(int i = 1; i <= numOfBits; i++) {
			if(i == 1) {
				f[i] = 0;
				g[i] = 1;
				h[i] = 1;
			} else {
				f[i] = f[i-1]*2+g[i-1];
				g[i] = h[i-1];
				h[i] = (int)Math.pow(2, numOfBits) - f[i] - g[i];
			}
		}
		return f[numOfBits];
	}
	
}
