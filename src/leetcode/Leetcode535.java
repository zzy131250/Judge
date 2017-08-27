package leetcode;

import java.util.ArrayList;

public class Leetcode535 {
	// 类似于存入数据库，然后取自增长id
	
	static ArrayList<String> urls = new ArrayList<String>();

	public static void main(String[] args) {
		
	}
	
	public static String encode(String longUrl) {
        urls.add(longUrl);
        return Integer.toString(urls.size()-1);
    }
	
	public static String decode(String shortUrl) {
        return urls.get(Integer.parseInt(shortUrl));
    }
	
}
