package stringmatch;

public class StringMatch {

	public static void main(String[] args) {
		char[] str = "0ababcabcacbab".toCharArray();
		char[] pattern = "0cbab".toCharArray();
		System.out.println(simpleMatch(str, pattern));
		System.out.println(kmpMatch(str, pattern));
	}
	
	//简单字符串匹配，如果匹配则返回字符串开始位置
	public static int simpleMatch(char[] str, char[] pattern) {
		int i = 0, j = 0;
		while (i < str.length && j < pattern.length) {
			if (str[i] == pattern[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if (j == pattern.length) return i-j;
		return -1;
	}
	
	//kmp算法，如果匹配成功返回字符串开始位置，从1开始
	public static int kmpMatch(char[] str, char[] pattern) {
		int[] next = get_next(str);
		int i = 1, j = 1;
		while (i < str.length && j < pattern.length) {
			if (j == 0 || str[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return i-j+1;
	}
	
	//得到next数组，从1开始
	public static int[] get_next(char[] str) {
		int[] next = new int[str.length+1];
		int i = 1, j = 0;
		next[1] = 0;
		while (i < str.length) {
			if (j == 0 || str[i] == str[j]) {
				next[++i] = ++j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	
}
