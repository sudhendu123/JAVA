package com.sample.java.net.socket;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TlvDecoder {
	
	private byte[] fullTLV;
	private KnTLVTagGenerator tagGen = new KnTLVTagGenerator();
	
	public void gebrish() {
		String response = "[2, 73, 68, 98, 0, 0, 0, 1, -125, 0, 3, 5, 0, 0, -24, 8, 0, 6, 57, 57, 57, 57, 57, 32, 74, 0, 0, 0, 0, -125, 0, -122, 6, 0, 3, 0, 40, -95, 0, 11, 80, 84, 84, 83, 69, 82, 86, 69, 82, 73, 68, 98, 0, 0, 0, 1, -125, 0, 3, 5, 0, 0, -24, 8, 0, 6, 57, 57, 57, 57, 57, 32, 74, 0, 0, 0, 0, 0, 34, -95, 0, 10, 83, 89, 83, 67, 79, 78, 70, 70, 83, 49, 98, -1, -1, -1, -5, -125, 0, 3, 5, 0, 0, 70, -67, -1, -32, 0, 74, 0, 0, 0, 0, 0, 51, -95, 0, 10, 83, 89, 83, 67, 79, 78, 70, 70, 83, 50, 98, -1, -1, -1, -3, -125, 0, 3, 5, 0, 0, -24, 8, 0, 18, 1, -63, 67, -4, -1, -3, -87, -2, -2, -1, -1, -5, -5, -49, -67, -1, -33, -1, 74, 0, 0, 0, 0, 68, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";      // response from the Python script

		String[] byteValues = response.substring(1, response.length() - 1).split(",");
		byte[] bytes = new byte[byteValues.length];

		for (int i=0, len=bytes.length; i<len; i++) {
		   bytes[i] = Byte.parseByte(byteValues[i].trim());     
		}

		String str = new String(bytes);
		System.out.println(" str :"+str);
	}
	
	public static void main(String[] args) {
		
	
		//byte[] readByteArray=hexStringToByteArray("66010b000502a1001753595354454d434f4e4649475f464541545552455345548200370600010032a1000b50545453455256455249446200000001830003050000e8080006303130303131e90800063031303031314a000000008300a90600030032a1000b50545453455256455249446200000001830003050000e8080006303130303131e90800063031303031314a000000000027a1000a535953434f4e4646533162fffffffb83000305000046bdffdf7f47bdffdf7f4a000000000047a1000a535953434f4e4646533262fffffffd830003050000e808001107fffcffffefffffffffe7f9deffbf9fffe908001101c3fcfffdaffffefffffbfbdfbdffdf7f4a000000014400000000");
		//working
		//byte[] readByteArray=hexStringToByteArray("66010b000502a1001753595354454d434f4e4649475f464541545552455345548200370600010032a1000b50545453455256455249446200000001830003050000e8080006303130303131e90800063031303031314a000000008300a90600030032a1000b50545453455256455249446200000001830003050000e8080006303130303131e90800063031303031314a000000000027a1000a535953434f4e4646533162fffffffb83000305000046bdffdf7f47bdffdf7f4a000000000047a1000a535953434f4e4646533262fffffffd830003050000e808001107fffcffffefffffffffe7f9deffbf9fffe908001101c3fcfffdaffffefffffbfbdfbdffdf7f4a000000014400000000");
		byte[] readByteArray=hexStringToByteArray("660256000502a100164d4943524f535643535f434f4d4d4f4e434f4e4649478200a50600030032a1000b434f554e545259434f44456200000001830003050000e8080006393120202020e90800063931202020204a000000000026a10009434c555354455249446200000004830003050000640000000265000000024a000000000044a10009504152414d4e414d45620000000c830003050000e808001053454c465f444e445f46454154555245e908001053454c465f444e445f464541545552454a000000008301870600070032a1000b434f554e545259434f44456200000001830003050000e8080006393120202020e90800063931202020204a000000000026a10009434c555354455249446200000004830003050000640000000265000000024a000000000044a10009504152414d4e414d45620000000c830003050000e808001053454c465f444e445f46454154555245e908001053454c465f444e445f464541545552454a000000000027a1000a504152414d56414c5545620000000c830003050000e808000130e9080001314a000000010027a1000a504152414d53434f50456200000005830003050000640000006465000000644a000000000061a1000450415448620000000c830003050000e80800212f2323434f554e545259434f444523232f53454c465f444e445f46454154555245e90800212f2323434f554e545259434f444523232f53454c465f444e445f464541545552454a00000000002ba1000e4c41535455504441544554494d4562fffffffb830003050000469cfea70c479cda9ad24a000000014400000000");
		
		/*
		 * for(byte b:readByteArray) { System.out.println(" bytes :"+b); }
		 */
		
		TlvDecoder d=new TlvDecoder();
		try {
			KnTLVMsgRespDTO resp=d.decodeMessage(readByteArray);
			System.out.println("resp :"+resp);
			KnPoCXLATableDetailsDTO tlvResp=DecodeTlv.decodeTlv(resp);
			System.out.println("resp :"+tlvResp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public KnTLVMsgRespDTO decodeMessage(byte[] b) throws Exception {
        this.fullTLV = b;
        KnTLVMsgRespDTO respDTO = null;
        try {
            respDTO = decodeMessage();
        } catch (Exception e) {
    
            throw new Exception("Failed Decoding byte[]");
        }
        return respDTO;
    }

	public KnTLVMsgRespDTO decodeMessage() throws Exception {
        String methodName = "decodeMessage()";
        KnTLVHeaderObject obj;
        try {
            obj = decodeHeader();
        } catch (Exception e) {
            throw e;
        }
        byte[] payload = new byte[obj.getMessageLength()];
        int payloadLen = payload.length;
        System.arraycopy(fullTLV, KnTLVMsgConstants.TLV_HEADER_SIZE, payload, 0, payloadLen);
        HashMap<Integer, KnTLVValueObject> map = decodeFragment(payload);

        KnTLVMsgRespDTO response = new KnTLVMsgRespDTO(obj.getMessageId(), obj.getProtocol(), map);
        return response;

    }
	
	public HashMap<Integer, KnTLVValueObject> decodeFragment(byte[] payload) throws Exception {
        String methodName = "decodeFragment()";
        int i = 0;
        int payloadLen = payload.length;
        HashMap<Integer, KnTLVValueObject> map = new HashMap<Integer, KnTLVValueObject>();
        while (i != payloadLen) {
            int datatype = tagGen.getDataType(payload[i], true);
            int tag;
            if (datatype < 7) {
                tag = tagGen.getTagId(payload[i++]);
            } else {
                // get datatype from next bit
                tag = tagGen.getTagId(payload[i++]);
                datatype = tagGen.getDataType(payload[i++], false);
            }
            ITLVDataTypesIntf dataObj = getDataTypeObject(datatype);
            if (dataObj == null) {
                throw new Exception("DataType not found");
            }
            Object retObj = null;
            switch (dataObj.lengthSize()) {
                case 0:
                    switch (datatype) {
                        case KnTLVMsgConstants.DATATYPE_INTEGER1:
                            retObj = dataObj.getValueFromBytes(new byte[]{payload[i++]});
                            break;

                        case KnTLVMsgConstants.DATATYPE_INTEGER2:
                            byte[] bTemp = new byte[]{payload[i++], payload[i++]};
                            retObj = dataObj.getValueFromBytes(bTemp);
                            break;
                        case KnTLVMsgConstants.DATATYPE_INTEGER3:
                            byte[] byteTemp1 = new byte[]{payload[i++], payload[i++], payload[i++], payload[i++]};
                            retObj = dataObj.getValueFromBytes(byteTemp1);
                            break;

                        case KnTLVMsgConstants.DATATYPE_INTEGER4:
                            byte[] byteTemp2 = new byte[]{payload[i++], payload[i++], payload[i++], payload[i++]};
                            retObj = dataObj.getValueFromBytes(byteTemp2);
                            break;

                        case KnTLVMsgConstants.DATATYPE_ARRAY:
                            byte[] bTemp1 = new byte[]{payload[i++], payload[i++], payload[i++], payload[i++], payload[i++]};
                            Map map1 = KnTLVDatatypeArray.decodeArrayHeader(bTemp1);
                            int len = (Integer) map1.get(KnTLVDatatypeArray.ARRAY_LENGTH);
                            byte[] newTemp = new byte[len + 2];  // Length + bytes of length byte itself
                            System.arraycopy(bTemp1, 0, newTemp, 0, bTemp1.length);
                            for (int j = 5; j < len + 2; j++)
                                newTemp[j] = payload[i++];
                            retObj = dataObj.getValueFromBytes(newTemp);
                            break;
                    }
                    break;
                case 2:
                    //get Length
                    byte[] bTemp = new byte[]{payload[i++], payload[i++]};
                    int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp);
                    //KnLogManager.logMessage(className, methodName,"dataLen: "+dataLen,KnLogManager.SEVERITY_DEBUG);
                    bTemp = new byte[dataLen];
                    for (int j = 0; j < dataLen; j++)
                        bTemp[j] = payload[i++];
                    retObj = dataObj.getValueFromBytes(bTemp);
                    break;
            }
            KnTLVValueObject valObj = new KnTLVValueObject(datatype, retObj);
            map.put(tag, valObj);
            //KnLogManager.logMessage(className, methodName,"datatype: "+datatype,KnLogManager.SEVERITY_DEBUG);
            //KnLogManager.logMessage(className, methodName,"tag: "+tag,KnLogManager.SEVERITY_DEBUG);
        }
        return map;
    }
	
	private static ITLVDataTypesIntf getDataTypeObject(int datatype) {
        switch (datatype) {
            case KnTLVMsgConstants.DATATYPE_INTEGER1:
                return new KnTLVDatatypeInteger1();
            case KnTLVMsgConstants.DATATYPE_INTEGER2:
                return new KnTLVDatatypeInteger2();
            case KnTLVMsgConstants.DATATYPE_INTEGER3:
                return new KnTLVDatatypeInteger3();
            case KnTLVMsgConstants.DATATYPE_INTEGER4:
                return new KnTLVDatatypeInteger4();
            case KnTLVMsgConstants.DATATYPE_ARRAY:
                return new KnTLVDatatypeArray();
            case KnTLVMsgConstants.DATATYPE_VSTRING:
                return new KnTLVDatatypeVString();
            case KnTLVMsgConstants.DATATYPE_STRUCT:
                return new KnTLVDatatypeStruct();
            case KnTLVMsgConstants.DATATYPE_VMSTRING:
                return new KnTLVDatatypeVMString();
            default:
                return null;
        }
    }
	
	private KnTLVHeaderObject decodeHeader() throws Exception {
        String methodName = "decodeHeader";
        if (fullTLV.length == 0) {
            //error -- no message.
            throw new Exception("TLV message length is zero.");
        }
        KnTLVHeaderGenerator headerGen = new KnTLVHeaderGenerator();
        KnTLVHeaderObject obj = headerGen.decodeHeader(fullTLV);
        return obj;
    }
	
}

class KnTLVMsgRespDTO {
    private int messageId;
    private HashMap<Integer, KnTLVValueObject> map;
    private int protocol;


    public KnTLVMsgRespDTO(int message, int protocol, HashMap<Integer, KnTLVValueObject> obj) {
        this.messageId = message;
        this.protocol = protocol;
        this.map = obj;
    }

    public int getMessageId() {
        return messageId;
    }

    public HashMap<Integer, KnTLVValueObject> getMap() {
        return map;
    }

    public int getProtocol() {
        return protocol;
    }

    public String toString() {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("[KnTLVMsgRespDTO - ")
                .append("MESSAGE_ID - ").append(messageId)
                .append(", MAP - ").append(map)
                .append(", PROTOCOL - ").append(protocol)
                .append("]");

        return strBuffer.toString();
    }

}

class KnTLVHeaderObject {
    private int ipcMessageType;
    private int messageLength;
    private int messageId;
    private int protocol;

    private StringBuffer strBuf = null;

    public int getIpcMessageType(){
        return ipcMessageType;
    }

    public void setIpcMessageType(int val){
        this.ipcMessageType = val;
    }

    public int getMessageLength(){
        return messageLength;
    }

    public void setMessageLength(int val){
        this.messageLength = val;
    }

    public int getMessageId(){
        return messageId;
    }

    public void setMessageId(int val){
        this.messageId = val;
    }

    public int getProtocol(){
        return protocol;
    }

    public void setProtocol(int val){
        this.protocol = val;
    }

    public String toString(){
        strBuf = new StringBuffer();
        strBuf.append("IPCMessageType=").append(ipcMessageType).append(", MessageLength=").append(messageLength).append(", MessageID=").append(messageId).append(", Protocol=").append(protocol);
        return strBuf.toString();
    }
}

class KnTLVValueObject {
    private Object value;
    private int dataType;

    private StringBuffer strBuf = null;

    public KnTLVValueObject(int data, Object val){
        this.dataType = data;
        this.value = val;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object val){
        this.value = val;
    }

    public int getDataType(){
        return dataType;
    }

    public void setDataType(int val){
        this.dataType = val;
    }

    public String toString(){
        strBuf = new StringBuffer();
        strBuf.append("Value=").append(value).append(", DataType=").append(dataType);
        return strBuf.toString();
    }
}

class KnTLVMsgConstants {

    /**
     * TLV datatypes numeric values.
     */
    public static final int DATATYPE_INTEGER1 = 0;
    public static final int DATATYPE_INTEGER2 = 1;
    public static final int DATATYPE_INTEGER4 = 2;
    public static final int DATATYPE_INTEGER3 = 3;
    public static final int DATATYPE_ARRAY = 4;
    public static final int DATATYPE_VSTRING = 5;
    public static final int DATATYPE_BYTEARRAY = 8;
    public static final int DATATYPE_VMSTRING = DATATYPE_BYTEARRAY;
    public static final int DATATYPE_STRUCT = 6;
    public static final int DATATYPE_NTLV1 = DATATYPE_ARRAY;   //same as array (array-of-struct).

    public static final int BITSIZE_FOR_1_BYTES = 8;
    public static final int BITSIZE_FOR_2_BYTES = 16;
    public static final int BITSIZE_FOR_4_BYTES = 32;
    public static final int BITSIZE_FOR_16_BYTES = 128;

    public static final byte TLV_AGC_HEADER_SIZE = 4;
    public static final byte TLV_HEADER_SIZE = 6;
    public static final byte IPC_TLV = 100;
    public static final byte IPC_NESTED_TLV = 102;

    public static final int ARRAY_HEADER_SIZE = 5;

    public static final String VMSTRING_CHARSET = "UTF-16LE";

}

class KnTLVHeaderGenerator {
    private static final String CLASS_NAME = KnTLVHeaderGenerator.class.getName();

    private Integer protocolVersion;

    public KnTLVHeaderGenerator(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public KnTLVHeaderGenerator() {

    }

    /**
     * This class is used to generate the TLV message header in the below format.
     * Header format ==
     * ---------------------------------------------------------------
     * | IPC Type | Message Length | Message Type | Protocol Version |
     * | 1 byte   | 2 bytes        | 2 bytes      | 1 bytes          |
     * ---------------------------------------------------------------
     * @param messageID   int
     * @param messageSize int
     * @return  byte[] Header Byte Array
     * @throws KnTLVException Exception while generating the TLV Header
     */

    public byte[] getHeader(int messageID, int messageSize) throws Exception {
        String methodName = "getHeader(int, int)";
        byte[] tlvHeader = new byte[KnTLVMsgConstants.TLV_HEADER_SIZE];

        try {
            //message size includes the Header size also.
            messageSize = messageSize + KnTLVMsgConstants.TLV_HEADER_SIZE;

            //TODO need to check for normal TLV or NESTED TLV
            tlvHeader[0] = KnTLVMsgConstants.IPC_NESTED_TLV;

            /* Message size is a 2 byte integer hence using the Integer2 TLV datatype to obtain bytevalues.*/
            byte[] messageLengthBytes = new byte[0];
            messageLengthBytes = new KnTLVDatatypeInteger2(messageSize).getBytes();
            tlvHeader[1] = messageLengthBytes[0];
            tlvHeader[2] = messageLengthBytes[1];

            /* Message ID is a 2 byte integer  hence using the Integer2 TLV datatype to obtain bytevalues.*/
            byte[] messageTypeBytes = new KnTLVDatatypeInteger2(messageID).getBytes();
            tlvHeader[3] = messageTypeBytes[0];
            tlvHeader[4] = messageTypeBytes[1];

            tlvHeader[5] = this.protocolVersion.byteValue();

        } catch (Exception e) {
            throw new Exception("Failed to generate Header");
        }

        return tlvHeader;
    }

    /**
     * This method creates the TLV message header in the below format.
     * Header format ==
     * <p/>
     * ---------------------------------------------------------------
     * | Protocol Version | Feature Id | Message Type | Client Type |
     * | 1 byte           | 1 byte     | 1 byte       | 1 bytes     |
     * ---------------------------------------------------------------
     *
     * @param messageID
     * @return
     */
    public byte[] getAgcHeader(int messageID) {
        String methodName = "getAgcHeader(int)";
        byte[] tlvHeader = new byte[KnTLVMsgConstants.TLV_AGC_HEADER_SIZE];

        tlvHeader[0] = this.protocolVersion.byteValue();

        byte[] messageLengthBytes = new KnTLVDatatypeInteger1(4).getBytes();
        tlvHeader[1] = messageLengthBytes[0];
        

        //TODO need to read as method param
        int opType = -1;
//        switch (messageID) {
//            case KnRequestConstants.CREATE_SCHEDULE_CONF:
//                opType = KnRequestConstants.AGC_CREATE_SCHEDULE_CONF;
//                break;
//            case KnRequestConstants.MODIFY_SCHEDULE_CONF:
//                opType = KnRequestConstants.AGC_MODIFY_SCHEDULE_CONF;
//                break;
//            case KnRequestConstants.DELETE_SCHEDULE_CONF:
//                opType = KnRequestConstants.AGC_DELETE_SCHEDULE_CONF;
//                break;
//        }
        byte[] messageTypeBytes = new KnTLVDatatypeInteger1(opType).getBytes();
        tlvHeader[2] = messageTypeBytes[0];

        return tlvHeader;
    }

    public KnTLVHeaderObject decodeHeader(byte[] b) throws Exception {
        String methodName = "decodeHeader(byte[])";
        KnTLVHeaderObject obj = new KnTLVHeaderObject();
        obj.setIpcMessageType(b[0]);
        try {
            byte[] bTemp = new byte[]{(byte) b[1], (byte) b[2]};
            obj.setMessageLength(new KnTLVDatatypeInteger2().getValueFromBytes(bTemp) - KnTLVMsgConstants.TLV_HEADER_SIZE);
            bTemp = new byte[]{(byte) b[3], (byte) b[4]};
            obj.setMessageId(new KnTLVDatatypeInteger2().getValueFromBytes(bTemp));
        } catch (Exception ex) {
            throw new Exception("Failed Decoding the Header");
        }
        obj.setProtocol(b[5]);
        return obj;
    }
}

class KnTLVDatatypeInteger2 implements ITLVDataTypesIntf {

    private int value = -1;
    private int dataType = KnTLVMsgConstants.DATATYPE_INTEGER2;
    private int noOfDigits = 16;

    public KnTLVDatatypeInteger2(){
    }

    public KnTLVDatatypeInteger2(int value) {
        this.value = value;
    }

    public byte[] getBytes()  {
        String binaryStr = Integer.toBinaryString(value);
        char[] charArr = binaryStr.toCharArray();
        char[] totalArr = new char[noOfDigits];

        Arrays.fill(totalArr, '0');
        System.arraycopy(charArr, 0, totalArr, totalArr.length - charArr.length, charArr.length);

        int byte_1 = 0;
        int power = 0;
        for (int i = 15; i > 7; i--) {
            if (totalArr[i] == '1') {
                byte_1 =  (byte_1 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_2 = 0;
        power = 0;
        for (int i = 7; i > -1; i--) {
            if (totalArr[i] == '1') {
                byte_2 = (byte_2 | (int) two2Pow(power));
            }
            power++;
        }

        // methods have hardcoded return as 2 bytes. Big Endian Format (Network order).
        return new byte[]{ (byte)byte_2, (byte)byte_1};
    }

    public int getDataType() {
        return dataType;
    }

    public int lengthSize() {
        return 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return "KnTLVDatatypeInteger2.value=" + this.value;
    }

    /**
     * This method is intended just to provide replacement for Math.pow(2, x). As pow() operation can be costly.
     * @param pow
     * @return
     */
    private int two2Pow(int pow){
        switch(pow){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            default:
                return (int)Math.pow(2, pow);
        }
    }

    public Integer getValueFromBytes(byte[] abyte0) throws Exception {
        int l = 0;
        int lvalue = 0;
        int length = abyte0.length;
        if(length != 2){
            throw new Exception("Cannot handle Integers bigger than 2 bytes");
        }
        int count = 0;
        for (int i = 0; i < length; i++)
        {
            lvalue = abyte0[i] & 0xff;
            if (lvalue == 0 && i==0)
            {
                count++;
            }
        }
        length = length - count;
        switch (length)
        {
            case 0:
                break;
            case 1:
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 2:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
        }
        return l;
    }
}


interface ITLVDataTypesIntf {

    /**
     * This will return the byte array for the TLV datatype.
     *
     * @return
     * @throws Exception
     */
    public byte[] getBytes() throws Exception;

    /**
     * This will provide the numerical ID for the datatype.
     *
     * @return
     * @throws Exception
     */
    public int getDataType() throws Exception;

    /**
     * This method will tell the size of fragment length  required.
     * The length bytes are not required for datatypes with constant size as Integer1, Integer2.
     * They are only required for variable length datatypes such as String.
     * 
     * 0-> means length value is not required.
     * @return
     */
    public int lengthSize();

    /**
     * This method decodes the value from bytes
     * @param b
     * @return
     */
    public Object getValueFromBytes(byte[] b) throws Exception;
}


class KnTLVDatatypeInteger1 implements ITLVDataTypesIntf {
    private Integer value;
    private int dataType = KnTLVMsgConstants.DATATYPE_INTEGER1;

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public KnTLVDatatypeInteger1(){

    }

    public KnTLVDatatypeInteger1(int value) {
        this.value = value;
    }

    public KnTLVDatatypeInteger1(String value) {
        this.value = Integer.parseInt(value.trim());
    }

    public byte[] getBytes() {
        byte[] byteValue = new byte[1];

        byteValue[0] = value.byteValue();

        return byteValue;
    }

    public int getDataType()  {
        return dataType;
    }

    public int lengthSize() {
        return 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValueFromBytes(byte[] b){
        return b[0] & 0xff;
    }

    public String toString() {
        return "KnTLVDatatypeInteger1.value=" + this.value;
    }
}

class KnTLVTagGenerator {

    /**
     * return the tag bytes generated by combination of tagID and datatypeID.
     * Rules:
     * 1. the tagID can be 1byte or 2 byte depending on the datatype.
     * 2. if the datatype is less than 7 then the tagID is of 1byte --- first five bites contain tagID and last three bits
     * contain datatype
     * 3. If the datatype is greater than 6 then the tagID is of 2bytes --- first five bits of first byte contain tagID
     * and last 3 bits of first byte are set to 7. The second byte represents the datatype value.
     *
     * @param intDataType -- Datatype of the fragment in the NTLV.
     * @return
     * @throws Exception
     */
    public byte[] getTagBytes(int tagID, int intDataType) throws Exception {

        if (intDataType < 7) {//the first 3 bits of tag byte represent datatype and rest 5 bits the tagID.
            intDataType = intDataType << 5;               //left shift the datataypeID bit by 5.
            tagID = tagID & 31;                         //make the first 3 bits of tagID as 0.
            byte retVal = (byte) (intDataType | tagID);   //bitwise OR operation.
            return new byte[]{retVal};
        } else if (intDataType > 6) {
            //The first three bits of tagByte are set to 1. The next 1 byte after tagByte contains the datatypeID value.
            tagID = tagID | 0xE0;
            KnTLVDatatypeInteger1 datatypeInt1 = new KnTLVDatatypeInteger1(intDataType);
            byte[] datatypeBytes = datatypeInt1.getBytes();     //assuming 1 byte array is returned.
            return new byte[]{(byte) tagID, datatypeBytes[0]};
        }
        return null;
    }

    public int getDataType(byte b, boolean firstByte) {
        KnTLVDatatypeInteger1 datatypeInt1 = new KnTLVDatatypeInteger1();
        int data = datatypeInt1.getValueFromBytes(new byte[]{b});
        if (firstByte)
            data = data >> 5;
        return data;
    }

    public int getTagId(byte b) {
        KnTLVDatatypeInteger1 datatypeInt1 = new KnTLVDatatypeInteger1();
        int tag = datatypeInt1.getValueFromBytes(new byte[]{b});
        tag = tag & 31;
        return tag;
    }

}

class KnTLVDatatypeArray implements ITLVDataTypesIntf {

    private ArrayList<ITLVDataTypesIntf> value = new ArrayList<ITLVDataTypesIntf>();  //can hold any value of TLV datatype

    public static final int ARRAY_LENGTH=0;
    public static final int ELEMENT_DATATYPE=1;
    public static final int NUM_OF_ELEMENTS =2;

    private int dataType = KnTLVMsgConstants.DATATYPE_ARRAY;

    private int elementType;    //this will identity the datatype of array elements

    private byte[] valueBytes = new byte[0];

    public KnTLVDatatypeArray(){

    }
    /**
     * While instantiating the array the datatype of elements should be passed.
     *
     * @param elementType
     */
    public KnTLVDatatypeArray(int elementType) {
        this.elementType = elementType;
    }

    /**
     * Returns the byte array value for this array.
     *
     * @return
     * @throws Exception
     */
    public byte[] getBytes() throws Exception {
        if (value == null || value.isEmpty()) {
            //System.out.println("tlv array is empty");
            throw new Exception("No values in the KnTLVDatatypeArray.");
        }

        KnTLVDatatypeInteger2 length;
        byte[] databytes;
        byte[] lengthbytes;

        for (Iterator<ITLVDataTypesIntf> it = value.iterator(); it.hasNext();) {
            ITLVDataTypesIntf valueTmp = it.next();
            databytes = valueTmp.getBytes();

            if (valueTmp.lengthSize() == 2) {
                length = new KnTLVDatatypeInteger2(databytes.length);
                lengthbytes = length.getBytes();
            } else {
                lengthbytes = new byte[0];
            }
            byte newbytes[] = appendBytes(lengthbytes, databytes);
            valueBytes = appendBytes(valueBytes, newbytes);
        }

        addArrayHeader();
        return valueBytes;
    }

    public int getDataType() throws Exception {
        return this.dataType;
    }

    /**
     * The byte length for the array is not required since that will be added as array header.
     *
     * @return
     */
    public int lengthSize() {
        return 0;
    }

    private byte[] appendBytes(byte[] startBytes, byte[] endBytes) {
        byte[] newBytes = new byte[startBytes.length + endBytes.length];
        System.arraycopy(startBytes, 0, newBytes, 0, startBytes.length);
        System.arraycopy(endBytes, 0, newBytes, startBytes.length, endBytes.length);

        return newBytes;
    }

    /**
     * Generates array header values.
     *
     * @throws Exception
     */
    private void addArrayHeader() throws Exception {
        ITLVDataTypesIntf numArrayElems = new KnTLVDatatypeInteger2(value.size());
        ITLVDataTypesIntf elemType = new KnTLVDatatypeInteger1(this.elementType);
        ITLVDataTypesIntf arraySize = new KnTLVDatatypeInteger2(this.valueBytes.length + 3);
        byte[] headerBytes = new byte[KnTLVMsgConstants.ARRAY_HEADER_SIZE];

        //adding array size bytes
        byte[] arraySizeBytes = arraySize.getBytes();
        System.arraycopy(arraySizeBytes, 0, headerBytes, 0, arraySizeBytes.length);

        byte[] elemTypeBytes = elemType.getBytes();
        System.arraycopy(elemTypeBytes, 0, headerBytes, arraySizeBytes.length, elemTypeBytes.length);

        byte[] numElemBytes = numArrayElems.getBytes();
        System.arraycopy(numElemBytes, 0, headerBytes, arraySizeBytes.length + elemTypeBytes.length, numElemBytes.length);

        valueBytes = appendBytes(headerBytes, valueBytes);
    }

    /**
     * Decode array header values and returns length of array
     *
     * @throws Exception
     */
    public static Map<Integer, Integer> decodeArrayHeader(byte[] b) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = 0;
        byte[] bTemp = new byte[]{b[0],b[1]};
        len = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp);
        //System.out.println("len of array: "+len);
        map.put(ARRAY_LENGTH,len);
        KnTLVTagGenerator tagGen = new KnTLVTagGenerator();
        len = tagGen.getDataType(b[2],false);
        map.put(ELEMENT_DATATYPE,len);
        //System.out.println("datatype in array: "+len);
        bTemp = new byte[]{b[3],b[4]};
        len = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp);
        map.put(NUM_OF_ELEMENTS,len);
        //System.out.println("number of elements in array: "+len);
        return map;

    }

    /**
     * The external classes will use this method to add new elements to the array.
     * Each element should be of TLV datatype specified while instantiation of the array. Else an exception is thrown.
     *
     * @param element
     * @throws Exception
     */
    public void addElement(ITLVDataTypesIntf element) throws Exception {
        if (element.getDataType() != elementType) {
            throw new Exception("Invalid element datatype. Found : " + element.getDataType() + " required : " + this.elementType);
        }
        value.add(element);
    }

    /**
     * To check if this array contains any elements.
     *
     * @return
     */
    public boolean isEmpty() {
        return value.isEmpty();
    }

    public Object getValueFromBytes(byte[] b) throws Exception{
//        ArrayList<HashMap<Integer,KnTLVValueObject>> list = new ArrayList<HashMap<Integer,KnTLVValueObject>>();
        List list = new ArrayList();
        int i=0;
        int payloadLen = b.length;
        //System.out.println("payload len in array : "+payloadLen);
        while(i<payloadLen){
            byte[] bTemp1 = new byte[]{b[i++],b[i++],b[i++],b[i++],b[i++]};
            Map<Integer, Integer> map1 = KnTLVDatatypeArray.decodeArrayHeader(bTemp1);
            int dataType = map1.get(ELEMENT_DATATYPE);
            int elems = map1.get(NUM_OF_ELEMENTS);

//            if(dataType== KnTLVMsgConstants.DATATYPE_STRUCT){
//                KnTLVDatatypeStruct dataObj = new KnTLVDatatypeStruct();
//                for(int k=0;k<elems;k++){
//                    bTemp1 = new byte[] { b[i++], b[i++]};
//                    int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp1);
//                    //System.out.println("datalen for struct:" + dataLen);
//                    bTemp1 = new byte[dataLen];
//                    for(int j=0;j<dataLen;j++)
//                        bTemp1[j]=b[i++];
//                    list.add((HashMap<Integer,KnTLVValueObject>)dataObj.getValueFromBytes(bTemp1));
//                    //System.out.println("list : "+list);
//                }
//
//            }

            ITLVDataTypesIntf dataObj;
            switch (dataType) {
            case KnTLVMsgConstants.DATATYPE_STRUCT:
            List Structlist = new ArrayList<HashMap<Integer,KnTLVValueObject>>();
                dataObj = new KnTLVDatatypeStruct();
                for(int k=0;k<elems;k++){
                    bTemp1 = new byte[] { b[i++], b[i++]};
                    int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp1);
                    //System.out.println("datalen for struct:" + dataLen);
                    bTemp1 = new byte[dataLen];
                    for(int j=0;j<dataLen;j++)
                    	bTemp1[j]=b[i++];
                    Structlist.add((HashMap<Integer,KnTLVValueObject>)dataObj.getValueFromBytes(bTemp1));
                    //System.out.println("list : "+list);
                }
                // adding to support array of structures..(array of NTLV's)
                list.add(Structlist);
                break;
            case KnTLVMsgConstants.DATATYPE_VSTRING:
//            	list = new ArrayList<String>();
            	dataObj = new KnTLVDatatypeVString();
            	for(int k = 0; k < elems; k++) {
            		bTemp1 = new byte[] { b[i++], b[i++]};
            		int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp1);
            		bTemp1 = new byte[dataLen];
            		for(int j=0;j<dataLen;j++)
                        bTemp1[j]=b[i++];
            			list.add(dataObj.getValueFromBytes(bTemp1));
            	}
            	break;
            case KnTLVMsgConstants.DATATYPE_VMSTRING:
//            	list = new ArrayList<String>();
            	dataObj = new KnTLVDatatypeVMString();
            	for(int k = 0; k < elems; k++) {
            		bTemp1 = new byte[] { b[i++], b[i++]};
            		int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp1);
            		bTemp1 = new byte[dataLen];
            		for(int j=0;j<dataLen;j++)
                        bTemp1[j]=b[i++];
            			list.add(dataObj.getValueFromBytes(bTemp1));
            	}
            	break;
            case KnTLVMsgConstants.DATATYPE_INTEGER1:
//            	list = new ArrayList<Integer>();
            	dataObj = new KnTLVDatatypeInteger1();
            	for (int k = 0; k < elems; k++) {
            		bTemp1 = new byte[] { b[i++] };
            		list.add(dataObj.getValueFromBytes(bTemp1));
            	}
            	break;
            case KnTLVMsgConstants.DATATYPE_INTEGER2:
//            	list = new ArrayList<Integer>();
            	dataObj = new KnTLVDatatypeInteger2();
            	for (int k = 0; k < elems; k++) {
            		bTemp1 = new byte[] { b[i++], b[i++] };
            		list.add(dataObj.getValueFromBytes(bTemp1));
            	}
            	break;
            case KnTLVMsgConstants.DATATYPE_INTEGER4:
//            	list = new ArrayList<Integer>();
            	dataObj = new KnTLVDatatypeInteger4();
            	for (int k = 0; k < elems; k++) {
            		bTemp1 = new byte[] { b[i++], b[i++],b[i++],b[i++] };
            		list.add(dataObj.getValueFromBytes(bTemp1));
            	}
            	break;
            case KnTLVMsgConstants.DATATYPE_INTEGER3:
//            	list = new ArrayList<Integer>();
            	dataObj = new KnTLVDatatypeInteger3();
            	for (int k = 0; k < elems; k++) {
            		bTemp1 = new byte[] { b[i++], b[i++],b[i++],b[i++] };
            		list.add(dataObj.getValueFromBytes(bTemp1));
            	}
            	break;
            case KnTLVMsgConstants.DATATYPE_ARRAY:
                List Arraylistlist = new ArrayList<HashMap<Integer,KnTLVValueObject>>();
                    dataObj = new KnTLVDatatypeStruct();
                    for(int k=0;k<elems;k++){
                        bTemp1 = new byte[] { b[i++], b[i++]};
                        int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp1);
                        //System.out.println("datalen for struct:" + dataLen);
                        bTemp1 = new byte[dataLen];
                        for(int j=0;j<dataLen;j++)
                        	bTemp1[j]=b[i++];
                        Arraylistlist.add((HashMap<Integer,KnTLVValueObject>)dataObj.getValueFromBytes(bTemp1));
                        //System.out.println("list : "+list);
                    }
                    // adding to support array of structures..(array of NTLV's)
                    list.add(Arraylistlist);
                    break;
            }
        }
        return list;
    }

    public String toString() {
        String retStr = "ElementType=" + elementType + ", arrayElements=[";
        for (ITLVDataTypesIntf aValue : value) {
            retStr = retStr + "(" + aValue.toString() + "),";
        }
        retStr = retStr + "]";
        return retStr;
    }
}

class KnTLVDatatypeStruct implements ITLVDataTypesIntf {

    private KnTLVTagGenerator tagGen = new KnTLVTagGenerator();

    private Map value = new HashMap();
    private int dataType = KnTLVMsgConstants.DATATYPE_STRUCT;
    private byte[] valueBytes = null;

    /**
     * Returns the byte array value for the structure.
     *
     * @return
     * @throws Exception
     */
    public byte[] getBytes() throws Exception {
        if (valueBytes != null && valueBytes.length > 0) {
            // reusing the initially calculated valueBytes. This may cause an issue when we are appending to the value
            // and want to get the new valueBytes. Use resetValueBytes() method before calling this method to obtain
            // fresh byte array.
            return this.valueBytes;
        }

        if (value == null || value.isEmpty()) {
            return new byte[0];
        }

        valueBytes = new byte[0];

        for (Iterator it = (value.keySet()).iterator(); it.hasNext();) {
            Integer tagID = (Integer) it.next();
            ITLVDataTypesIntf dataValue = (ITLVDataTypesIntf) value.get(tagID);
            if (dataValue == null) {
                continue;
            }
            //add this tag-value pair to the valueBytes.
            addFragment(tagID, dataValue);
        }

        if (valueBytes == null || valueBytes.length < 1) {
            return new byte[0];
        } else {
            return valueBytes;
        }
    }

    public int getDataType() throws Exception {
        return this.dataType;
    }

    public int lengthSize() {
        return 2;
    }

    /**
     * Used by external classes to populate the data (tagID-value) pair.
     *
     * @param keyTag
     * @param dataValue
     * @throws Exception
     */
    public void add(int keyTag, ITLVDataTypesIntf dataValue) throws Exception {

        if (dataValue == null) {
            throw new NullPointerException("Data value is null.");
        }
        this.value.put(keyTag, dataValue);
    }

    /**
     * This method will add the new TLV fragment to the NTLV value.
     *
     * @param value
     * @throws Exception
     */
    private void addFragment(int tagID, ITLVDataTypesIntf value) throws Exception {
        byte[] tagBytes;
        byte[] valueBytes;
        byte[] lengthBytes = new byte[0];

        //obtaining tag bytes.
        tagBytes = getTagBytes(tagID, value.getDataType());

        //obtaining the byte array for the value.
        valueBytes = value.getBytes();

        ITLVDataTypesIntf length = null;

        //calculating length of value and getting the bytes.
        if(value.lengthSize() == 2){
            length = new KnTLVDatatypeInteger2(valueBytes.length);
            lengthBytes = length.getBytes();
        }

        if(value.lengthSize() == 4){
            length = new KnTLVDatatypeInteger2(valueBytes.length);
            lengthBytes = length.getBytes();
        }

        //calculating total size of the fragment = <tag byte> + lengthBytes + valueBytes.
        int totalFragLength = tagBytes.length + lengthBytes.length + valueBytes.length;
        byte[] fragmentBytes = new byte[totalFragLength];

        //adding tag to the fragment
        System.arraycopy(tagBytes, 0, fragmentBytes, 0, tagBytes.length);

        //adding length array to the fragment
        System.arraycopy(lengthBytes, 0, fragmentBytes, tagBytes.length, lengthBytes.length);

        //adding value array
        System.arraycopy(valueBytes, 0, fragmentBytes, (tagBytes.length + lengthBytes.length), valueBytes.length);

        appendBytes(this.valueBytes, fragmentBytes);
    }

    /**
     * This method is used to append byte arrays together, and set the resulting array as fullTLV.
     *
     * @param startBytes
     * @param endBytes
     */
    private void appendBytes(byte[] startBytes, byte[] endBytes) {
        byte[] newBytes = new byte[startBytes.length + endBytes.length];
        System.arraycopy(startBytes, 0, newBytes, 0, startBytes.length);
        System.arraycopy(endBytes, 0, newBytes, startBytes.length, endBytes.length);

        this.valueBytes = newBytes;
    }

    /**
     * return the tag bytes generated by combination of tagID and datatypeID.
     *
     * @param intDataType -- Datatype of the fragment in the NTLV.
     * @return
     * @throws Exception
     */
    private byte[] getTagBytes(int tagID, int intDataType) throws Exception {
        return tagGen.getTagBytes(tagID, intDataType);
    }

    /**
     * This method is used to reset the valueBytes before invoking getBytes() method for fresh byte calculation.
     */
    public void resetValueBytes() {
        this.valueBytes = null;
    }

    public Object getValueFromBytes(byte[] b) throws Exception{
        HashMap<Integer,KnTLVValueObject> map = null;
        try{
            KnTLVMessageDecoder decoder = new KnTLVMessageDecoder();
            map = decoder.decodeFragment(b);
        }catch(Exception ex){
            throw ex;
        }
        return map;
    }

    public String toString() {
        return "KnTLVDatatypeStruct.value=" + this.value;
    }
}

class KnTLVMessageDecoder {
    private final String className = KnTLVMessageDecoder.class.getName();

    private byte[] fullTLV;
    private KnTLVTagGenerator tagGen = new KnTLVTagGenerator();

    public KnTLVMessageDecoder(byte[] b) {
        this.fullTLV = b;
    }

    public KnTLVMessageDecoder() {
    }

    private KnTLVHeaderObject decodeHeader() throws Exception {
        String methodName = "decodeHeader";
        if (fullTLV.length == 0) {
            //error -- no message.
            throw new Exception("TLV message length is zero.");
        }
        KnTLVHeaderGenerator headerGen = new KnTLVHeaderGenerator();
        KnTLVHeaderObject obj = headerGen.decodeHeader(fullTLV);
        return obj;
    }

    public KnTLVMsgRespDTO decodeMessage() throws Exception {
        String methodName = "decodeMessage()";
        KnTLVHeaderObject obj;
        try {
            obj = decodeHeader();
        } catch (Exception e) {
            throw e;
        }
        //KnLogManager.logMessage(className, methodName, "len: "+fullTLV.length, KnLogManager.SEVERITY_DEBUG);
        byte[] payload = new byte[obj.getMessageLength()];
        int payloadLen = payload.length;
        System.arraycopy(fullTLV, KnTLVMsgConstants.TLV_HEADER_SIZE, payload, 0, payloadLen);
        HashMap<Integer, KnTLVValueObject> map = decodeFragment(payload);
        //KnLogManager.logMessage(className, methodName,"map: "+map,KnLogManager.SEVERITY_DEBUG);

        KnTLVMsgRespDTO response = new KnTLVMsgRespDTO(obj.getMessageId(), obj.getProtocol(), map);
        return response;

    }

    public KnTLVMsgRespDTO decodeMessage(byte[] b) throws Exception {
        this.fullTLV = b;
        KnTLVMsgRespDTO respDTO = null;
        try {
            respDTO = decodeMessage();
        } catch (Exception e) {
            throw new Exception( "Failed Decoding byte[]");
        }
        return respDTO;
    }

    public HashMap<Integer, KnTLVValueObject> decodeFragment(byte[] payload) throws Exception {
        String methodName = "decodeFragment()";
        int i = 0;
        int payloadLen = payload.length;
        HashMap<Integer, KnTLVValueObject> map = new HashMap<Integer, KnTLVValueObject>();
        while (i != payloadLen) {
            int datatype = tagGen.getDataType(payload[i], true);
            int tag;
            if (datatype < 7) {
                tag = tagGen.getTagId(payload[i++]);
            } else {
                // get datatype from next bit
                tag = tagGen.getTagId(payload[i++]);
                datatype = tagGen.getDataType(payload[i++], false);
            }
            ITLVDataTypesIntf dataObj = getDataTypeObject(datatype);
            if (dataObj == null) {
                throw new Exception("DataType not found");
            }
            Object retObj = null;
            switch (dataObj.lengthSize()) {
                case 0:
                    switch (datatype) {
                        case KnTLVMsgConstants.DATATYPE_INTEGER1:
                            retObj = dataObj.getValueFromBytes(new byte[]{payload[i++]});
                            break;

                        case KnTLVMsgConstants.DATATYPE_INTEGER2:
                            byte[] bTemp = new byte[]{payload[i++], payload[i++]};
                            retObj = dataObj.getValueFromBytes(bTemp);
                            break;
                        case KnTLVMsgConstants.DATATYPE_INTEGER3:
                            byte[] byteTemp1 = new byte[]{payload[i++], payload[i++], payload[i++], payload[i++]};
                            retObj = dataObj.getValueFromBytes(byteTemp1);
                            break;

                        case KnTLVMsgConstants.DATATYPE_INTEGER4:
                            byte[] byteTemp2 = new byte[]{payload[i++], payload[i++], payload[i++], payload[i++]};
                            retObj = dataObj.getValueFromBytes(byteTemp2);
                            break;

                        case KnTLVMsgConstants.DATATYPE_ARRAY:
                            byte[] bTemp1 = new byte[]{payload[i++], payload[i++], payload[i++], payload[i++], payload[i++]};
                            Map map1 = KnTLVDatatypeArray.decodeArrayHeader(bTemp1);
                            int len = (Integer) map1.get(KnTLVDatatypeArray.ARRAY_LENGTH);
                            byte[] newTemp = new byte[len + 2];  // Length + bytes of length byte itself
                            System.arraycopy(bTemp1, 0, newTemp, 0, bTemp1.length);
                            for (int j = 5; j < len + 2; j++)
                                newTemp[j] = payload[i++];
                            retObj = dataObj.getValueFromBytes(newTemp);
                            break;
                    }
                    break;
                case 2:
                    //get Length
                    byte[] bTemp = new byte[]{payload[i++], payload[i++]};
                    int dataLen = new KnTLVDatatypeInteger2().getValueFromBytes(bTemp);
                    //KnLogManager.logMessage(className, methodName,"dataLen: "+dataLen,KnLogManager.SEVERITY_DEBUG);
                    bTemp = new byte[dataLen];
                    for (int j = 0; j < dataLen; j++)
                        bTemp[j] = payload[i++];
                    retObj = dataObj.getValueFromBytes(bTemp);
                    break;
            }
            KnTLVValueObject valObj = new KnTLVValueObject(datatype, retObj);
            map.put(tag, valObj);
            //KnLogManager.logMessage(className, methodName,"datatype: "+datatype,KnLogManager.SEVERITY_DEBUG);
            //KnLogManager.logMessage(className, methodName,"tag: "+tag,KnLogManager.SEVERITY_DEBUG);
        }
        return map;
    }

    private static ITLVDataTypesIntf getDataTypeObject(int datatype) {
        switch (datatype) {
            case KnTLVMsgConstants.DATATYPE_INTEGER1:
                return new KnTLVDatatypeInteger1();
            case KnTLVMsgConstants.DATATYPE_INTEGER2:
                return new KnTLVDatatypeInteger2();
            case KnTLVMsgConstants.DATATYPE_INTEGER3:
                return new KnTLVDatatypeInteger3();
            case KnTLVMsgConstants.DATATYPE_INTEGER4:
                return new KnTLVDatatypeInteger4();
            case KnTLVMsgConstants.DATATYPE_ARRAY:
                return new KnTLVDatatypeArray();
            case KnTLVMsgConstants.DATATYPE_VSTRING:
                return new KnTLVDatatypeVString();
            case KnTLVMsgConstants.DATATYPE_STRUCT:
                return new KnTLVDatatypeStruct();
            case KnTLVMsgConstants.DATATYPE_VMSTRING:
                return new KnTLVDatatypeVMString();
            default:
                return null;
        }
    }
}

class KnTLVDatatypeInteger3 implements ITLVDataTypesIntf {

    private int value = -1;
    private int dataType = KnTLVMsgConstants.DATATYPE_INTEGER3;
    private int noOfDigits = 32;

    public KnTLVDatatypeInteger3(){
    }

    public KnTLVDatatypeInteger3(int value) {
        this.value = value;
    }

    public byte[] getBytes() throws Exception {
        String binaryStr = Integer.toBinaryString(value);
        char[] charArr = binaryStr.toCharArray();
        char[] totalArr = new char[noOfDigits];

        Arrays.fill(totalArr, '0');
        System.arraycopy(charArr, 0, totalArr, totalArr.length - charArr.length, charArr.length);

        int byte_1 = 0;
        int power = 0;
        for (int i = 31; i > 23; i--) {
            if (totalArr[i] == '1') {
                byte_1 =  (byte_1 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_2 = 0;
        power = 0;
        for (int i = 23; i > 15; i--) {
            if (totalArr[i] == '1') {
                byte_2 =  (byte_2 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_3 = 0;
        power = 0;
        for (int i = 15; i > 7; i--) {
            if (totalArr[i] == '1') {
                byte_3 =  (byte_3 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_4 = 0;
        power = 0;
        for (int i = 7; i > -1; i--) {
            if (totalArr[i] == '1') {
                byte_4 = (byte_4 | (int) two2Pow(power));
            }
            power++;
        }
        // methods have hardcoded return as 4 bytes. Big Endian Format (Network order).
        return new byte[]{ (byte)byte_4, (byte)byte_3, (byte)byte_2, (byte)byte_1};
    }

    public int getDataType() throws Exception {
        return dataType;
    }

    public int lengthSize() {
        return 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return "KnTLVDatatypeInteger3.value=" + this.value;
    }
    /**
     * This method is intended just to provide replacement for Math.pow(2, x). As pow() operation can be costly.
     * @param pow
     * @return
     */
    private int two2Pow(int pow){
        switch(pow){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            default:
                return (int)Math.pow(2, pow);
        }
    }

    public Integer getValueFromBytes(byte[] abyte0) throws Exception{
        int l = 0;
        int lvalue = 0;
        int length = abyte0.length;
        if(length != 4){
            throw new Exception("Cannot handle Integers bigger than 4 bytes");
        }
        int count = 0;
        for (int i = 0; i < length; i++)
        {
            lvalue = abyte0[i] & 0xff;
            if (lvalue == 0 && i==0)
            {
                count++;
            }
        }
        length = length - count;
        switch (length)
        {
            case 0:
                break;
            case 1:
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 2:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 3:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 65536;
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 4:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 16777216;
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 65536;
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
        }
        return l;
    }

}

class KnTLVDatatypeInteger4 implements ITLVDataTypesIntf {

    private int value = -1;
    private int dataType = KnTLVMsgConstants.DATATYPE_INTEGER4;
    private int noOfDigits = 32;

    public KnTLVDatatypeInteger4(){
    }

    public KnTLVDatatypeInteger4(int value) {
        this.value = value;
    }

    public byte[] getBytes() throws Exception {
        String binaryStr = Integer.toBinaryString(value);
        char[] charArr = binaryStr.toCharArray();
        char[] totalArr = new char[noOfDigits];

        Arrays.fill(totalArr, '0');
        System.arraycopy(charArr, 0, totalArr, totalArr.length - charArr.length, charArr.length);

        int byte_1 = 0;
        int power = 0;
        for (int i = 31; i > 23; i--) {
            if (totalArr[i] == '1') {
                byte_1 =  (byte_1 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_2 = 0;
        power = 0;
        for (int i = 23; i > 15; i--) {
            if (totalArr[i] == '1') {
                byte_2 =  (byte_2 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_3 = 0;
        power = 0;
        for (int i = 15; i > 7; i--) {
            if (totalArr[i] == '1') {
                byte_3 =  (byte_3 | (int) two2Pow(power));
            }
            power++;
        }

        int byte_4 = 0;
        power = 0;
        for (int i = 7; i > -1; i--) {
            if (totalArr[i] == '1') {
                byte_4 = (byte_4 | (int) two2Pow(power));
            }
            power++;
        }
        // methods have hardcoded return as 4 bytes. Big Endian Format (Network order).
        return new byte[]{ (byte)byte_4, (byte)byte_3, (byte)byte_2, (byte)byte_1};
    }

    public int getDataType() throws Exception {
        return dataType;
    }

    public int lengthSize() {
        return 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return "KnTLVDatatypeInteger4.value=" + this.value;
    }
    /**
     * This method is intended just to provide replacement for Math.pow(2, x). As pow() operation can be costly.
     * @param pow
     * @return
     */
    private int two2Pow(int pow){
        switch(pow){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            default:
                return (int)Math.pow(2, pow);
        }
    }

    public Integer getValueFromBytes(byte[] abyte0) throws Exception{
        int l = 0;
        int lvalue = 0;
        int length = abyte0.length;
        if(length != 4){
            throw new Exception("Cannot handle Integers bigger than 4 bytes");
        }
        int count = 0;
        for (int i = 0; i < length; i++)
        {
            lvalue = abyte0[i] & 0xff;
            if (lvalue == 0 && i==0)
            {
                count++;
            }
        }
        length = length - count;
        switch (length)
        {
            case 0:
                break;
            case 1:
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 2:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 3:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 65536;
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
            case 4:
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 16777216;
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 65536;
                lvalue = abyte0[count++] & 0xff;
                l += lvalue * 256;
                lvalue = abyte0[count] & 0xff;
                l += lvalue;
                break;
        }
        return l;
    }

}

class KnTLVDatatypeVString implements ITLVDataTypesIntf {
    private String value = null;
    private int dataType = KnTLVMsgConstants.DATATYPE_VSTRING;

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public KnTLVDatatypeVString(){

    }
    
    public KnTLVDatatypeVString(String value) {
        this.value = value;
    }

    public byte[] getBytes() {
        return value.getBytes();
    }

    public int getDataType() throws Exception {
        return dataType;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int lengthSize() {
        return 2;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueFromBytes(byte[] b){
        return new String(b);    
    }

    public String toString() {
        return "KnTLVDatatypeVString.value=" + this.value;
    }
}

class KnTLVDatatypeVMString implements ITLVDataTypesIntf {
    private final String CLASS_NAME = KnTLVDatatypeVMString.class.getName();

    private String value = null;
    private int dataType = KnTLVMsgConstants.DATATYPE_VMSTRING;

    public KnTLVDatatypeVMString() {

    }

    public KnTLVDatatypeVMString(String value) {
        this.value = value;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public byte[] getBytes() {
        try {
            return value.getBytes(KnTLVMsgConstants.VMSTRING_CHARSET);
        } catch (UnsupportedEncodingException e) {
            System.out.print(e);
        }

        return new byte[0];
    }

    public int getDataType() throws Exception {
        return dataType;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int lengthSize() {
        return 2;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public byte[] getValueFromBytes(byte[] b) {
       // try {
            //return new String(b, KnTLVMsgConstants.VMSTRING_CHARSET);
            return b;
        //} catch (UnsupportedEncodingException e) {
         //   knLogger.error( "getValueFromBytes(byte[])", "Encoding Exception" + e);
         //   knLogger.error( "getValueFromBytes(byte[])", e);
       // }
       // return new String();
    }

    public String toString() {
        return "KnTLVDatatypeVMString.value=" + this.value;
    }
}




