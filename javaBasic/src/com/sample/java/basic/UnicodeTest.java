package com.sample.java.basic;

import java.nio.charset.StandardCharsets;

public class UnicodeTest {
	public static void main(String[] args) {
		String str = "Hello";
		//The hex output 0x48 0x65 0x6c 0x6c 0x6f is binary of form string Hello in ASCII.
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        printBytes(bytes);
        
        byte[] bytess = {0x48, 0x65, 0x6c, 0x6c, 0x6f};
        //The String class decodes the bytes with US_ASCII charset which is displayed as Hello.
        String strs = new String(bytess, StandardCharsets.US_ASCII);
        System.out.println(strs);
        //UTF_8
        // encode
        String strr = "你";
        byte[] bytesr = strr.getBytes(StandardCharsets.UTF_8);
        printBytes(bytesr);      // xe4 xbd xa0  (3 bytes)

        // decode
        String decodedStr = new String(bytesr, StandardCharsets.UTF_8);
        System.out.println(decodedStr);    // 你  
        //UTF_16
        // encode
        String strq = "你";
        byte[] bytesq = strq.getBytes(StandardCharsets.UTF_16);
        printBytes(bytesq);      // xfe xff x4f x60  (4 bytes)

        // decode
        String decodedStrq = new String(bytesq, StandardCharsets.UTF_16);
        System.out.println(decodedStrq);    // 你
        //unicode
        //encode
        String sttr = "你";
        int codePoint = sttr.codePointAt(0);    
        System.out.format("\\u%04X", codePoint);
        System.out.println();
        //deocde
        String utf8Text = "\u4F60";
        byte[] byytes = utf8Text.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        String text = new String(byytes, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println(text);
        
        //Transcoding is the direct digital-to-digital conversion from an encoding to another,
        //such as UTF-8 to UTF-16. We regularly encounter transcoding in video,
        //audio and image files but rarely with text files.
	}
	
	public static void printBytes(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (byte b : a) {
            sb.append(String.format("x%02x ", b));
        }
        System.out.println(sb);
    }

}
