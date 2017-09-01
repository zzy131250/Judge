package leetcode;

public class Leetcode657 {
	
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
	}
	
	public static boolean judgeCircle(String moves) {
        for (int i = 0; i < moves.length(); i++) move(moves.charAt(i));
        if (x == 0 && y == 0) return true;
        return false;
    }
	
	public static void move(char move) {
		switch (move) {
		case 'U':
			y += 1;
			break;
		case 'D':
			y -= 1;
			break;
		case 'R':
			x += 1;
			break;
		case 'L':
			x -= 1;
			break;
		default:
			break;
		}
	}
	
}
