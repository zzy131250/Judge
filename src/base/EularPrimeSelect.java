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
				if (i * primes.get(j) >= n) break;
				isPrime[i * primes.get(j)] = false;
				if (i % primes.get(j) == 0) break;
			}
		}
		for (int temp: primes) System.out.println(temp);
	}
	
}
