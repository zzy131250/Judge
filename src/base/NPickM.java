package base;

// pick m items from n items
public class NPickM {
	
	public static void main(String[] args) {
		nPickM(5, 2);
	}
	
	public static void nPickM (int n, int m) {
		for (int i = 1; i < 1<<n; i++) {
			if (Integer.bitCount(i) == m) {
				// add 0 in the front
				String str = Integer.toBinaryString(i);
				while (str.length() < n) str = "0" + str;
				System.out.println(str);
			}
		}
	}

}
