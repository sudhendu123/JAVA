package com.sample.java.net.socket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;


public class SSLServerSocketServer {

	static final int port = 8000;

	static SSLContext ctx;
	static KeyManagerFactory kmf;
	static KeyStore ks;
	
	
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, GeneralSecurityException, FileNotFoundException, IOException {
        /**
    	char pass[]="cyberscore".toCharArray();
    	ctx=SSLContext.getInstance("TLS");
    	kmf=KeyManagerFactory.getInstance("SunX509");
    	ks=KeyStore.getInstance("JKS");
    	ks.load(new FileInputStream("bank.keyStore"),pass);
    	kmf.init(ks,pass);
    	ctx.init(kmf.getKeyManagers(), null, null);
    	SSLServerSocketFactory sslServerSocketFac=ctx.getServerSocketFactory();
    	ServerSocket ssc = sslServerSocketFac.createServerSocket(8080);
    		*/	
    	System.setProperty("javax.net.ssl.keyStore","keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "passphrase");
    	
        SSLServerSocketFactory sslServerSocketFactory = 
                (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
        
        try {
            ServerSocket sslServerSocket = 
                    sslServerSocketFactory.createServerSocket(port);
            System.out.println("SSL ServerSocket started");
            System.out.println(sslServerSocket.toString());
            
            Socket socket = sslServerSocket.accept();
            System.out.println("ServerSocket accepted");
            
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try (BufferedReader bufferedReader = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                String line;
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                    out.println(line);
                }
            }
            System.out.println("Closed");
            
        } catch (IOException ex) {
            Logger.getLogger(SSLServerSocketServer.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
