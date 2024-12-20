package com.sample.java.net.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient1 {
	// initialize socket and input output streams
		private Socket socket = null;
		private DataInputStream input = null;
		private DataOutputStream out = null;

		// constructor to put ip address and port
		public SocketClient1(String address, int port) {
			// establish a connection
			try {
				socket = new Socket(address, port);
				System.out.println("client1 Connected");

				// takes input from terminal
				input = new DataInputStream(System.in);
	            
				// sends output to the socket
				out = new DataOutputStream(socket.getOutputStream());
			} catch (UnknownHostException u) {
				System.out.println(u);
			} catch (Throwable i) {
				System.out.println(i);
			}

			// string to read message from input
			String line = "";

			// keep reading until "Over" is input
			while (!line.equals("Over")) {
				try {
					line = input.readLine();
					out.writeUTF(line);
				} catch (IOException i) {
					System.out.println(i);
				}
			}

			// close the connection
			try {
				input.close();
				out.close();
				socket.close();
			} catch (IOException i) {
				System.out.println(i);
			}
		}

		 public void publishEvent(byte[] readByteArray) {
		    	TlvDecoder tlv=new TlvDecoder();
		    	KnTLVMsgRespDTO resp = null;
				try {
					resp = tlv.decodeMessage(readByteArray);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("resp :"+resp);
				KnPoCXLATableDetailsDTO tlvResp=DecodeTlv.decodeTlv(resp);
				System.out.println("resp :"+tlvResp);
		    	
		    }
		 
		public static void main(String args[]) {
			SocketClient1 client = new SocketClient1("127.0.0.1", 5000);
		}
	}