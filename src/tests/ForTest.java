package tests;

public class ForTest {
	
	static class Ref {
		int value;
	}
	
	public static void main(String[] args) {
//		int i;
//		for (i = 0; i <= 5; i++) {
//			
//		}
//		System.out.println(i);
		Ref ref = new Ref();
		ref.value = 1;
		test(ref);
		System.out.println(ref.value);
	}
	
	public static void test(Ref ref) {
		ref.value = 3;
	}
	
}
