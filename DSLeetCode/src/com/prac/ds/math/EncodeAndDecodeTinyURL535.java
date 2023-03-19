package com.prac.ds.math;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a
 * tiny URL.
 *
 */
public class EncodeAndDecodeTinyURL535 {

	static Map<String, String> codeDB = new HashMap<>();
	static Map<String, String> urlDB = new HashMap<>();
	static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		
		System.out.println("encode:"+encode("https://leetcode.com/problems/design-tinyurl"));
		System.out.println("decode:"+decode("http://tinyurl.com/42-96ae-46dd-98d3-994b1f8811e2"));
	}
	
	

	public static String encode(String longUrl) {
		if (urlDB.containsKey(longUrl))
			return urlDB.get(longUrl);
		String code = getCode();
		while (codeDB.containsKey(code))
			code = getCode();
		codeDB.put(code, longUrl);
		urlDB.put(longUrl, code);
		return code;
	}
	
	private static String getCode() {
		char[] code = new char[6];
		for (int i = 0; i < 6; i++)
			code[i] = chars.charAt((int) Math.random() * 62);
		
		UUID uuid = UUID.randomUUID();
        //return "http://tinyurl.com/" + String.valueOf(code);
        return "http://tinyurl.com/" +uuid.toString().substring(6);
	}

	public static String decode(String shortUrl) {
		return codeDB.get(shortUrl);
	}
}
