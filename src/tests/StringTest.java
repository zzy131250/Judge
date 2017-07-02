package tests;

public class StringTest {

	public static void main(String[] args) {
		equalTest();
		threadTest();
	}
	
	public static void equalTest() {
		String p = "abd" + "def";
		String q = new String(p);
		System.out.println(p == q);
		System.out.println(p.equals(q));
		
		Integer a = 128;
		Integer b = 128;
		System.out.println(a==b);
	}
	
	public static void threadTest() {
		String a = "MD";
		String b = "ZZ";
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(a);
			}
		});
		t.run();
		System.out.println(b);
	}
	
}
