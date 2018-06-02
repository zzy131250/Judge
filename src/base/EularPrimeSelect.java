package base;

import java.util.ArrayList;
import java.util.Arrays;

public class EularPrimeSelect {

	public static void main(String[] args) {
		int n = 99;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) primes.add(i);
			for (int j = 0; j < primes.size(); j++) {
				// 越界，结束
				if (i * primes.get(j) >= n) break;
				// 素数的倍数都是合数
				isPrime[i * primes.get(j)] = false;
				// 基数是已知素数的倍数，结束；确保筛选时用的是最小质因数
				if (i % primes.get(j) == 0) break;
			}
		}
		for (int temp: primes) System.out.println(temp);
	}
	
}
