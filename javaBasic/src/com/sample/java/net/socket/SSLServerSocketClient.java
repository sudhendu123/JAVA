package com.sample.java.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLSocketFactory;

public class SSLServerSocketClient {

	static final int port = 8000;

	/**
	 * 
	 -Djavax.net.ssl.keyStore=keystore \
    -Djavax.net.ssl.keyStorePassword=passphrase \
    -Djavax.net.ssl.trustStore=keystore \
    -Djavax.net.ssl.trustStorePassword=passphrase \
	 */
	
	private SecretKeySpec signKey;
	
	SSLServerSocketClient(){
		byte[] key=new byte[20];
		new Random().nextBytes(key);
		this.signKey=new SecretKeySpec(key,"HmacSHA256");
	}
	
	public void createToken() {
		Mac mac;
		try {
			mac = Mac.getInstance("HmacSHA256");
			mac.init(signKey);
			String tokenInput="role_";
			//String finalToken=tokenInput+"_token_"+toHexString(mac.doFinal(tokenInput.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			System.out.println("invalid key");
		}
		
	}
	
    public static void main(String[] args) {
    	
    	
        
    	System.setProperty("javax.net.ssl.trustStore","truststore");
        System.setProperty("javax.net.ssl.trustStorePassword", "passphrase");
        
        SSLSocketFactory sslSocketFactory = 
                (SSLSocketFactory)SSLSocketFactory.getDefault();
        try {
            Socket socket = sslSocketFactory.createSocket("localhost", port);
            //SSLSocketFactory sslSocketFactory =(SSLSocketFactory)SSLSocketFactory.getDefault();
            //SSLSocket soc=(SSLSocket)sslSocketFactory.createSocket("localhost", port);
            //soc.startHandshake();
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                Scanner scanner = new Scanner(System.in);
                while(true){
                    System.out.println("Enter something:");
                    String inputLine = scanner.nextLine();
                    if(inputLine.equals("q")){
                        break;
                    }
                    
                    out.println(inputLine);
                    System.out.println(bufferedReader.readLine());
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SSLServerSocketClient.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
         
    }
	
}
