package com.sample.java.net.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSocketTest {
	
	
	//initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream inStreamFromServer; 
  
    // constructor with port 
    public ServerSocketTest(int port) 
    { 
        // starts server and waits for a connection 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            inStreamFromServer = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream())); 
  
            
            String line = ""; 
  
            
            TlvDecoder tlv=new TlvDecoder();
            byte[] readByteArray=null;
            while (!line.equals("Over")) 
            { 
                try
                { 
                    line = inStreamFromServer.readUTF(); 
                    //System.out.println(line);
                    
                    readByteArray=tlv.hexStringToByteArray(line);
                    try {
                    	publishEvent(readByteArray);
            		} catch (Exception e) {
            			e.printStackTrace();
            		} 
                    
                    
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            }
            // close connection
            System.out.println("Closing connection");
    socket.close(); 
    inStreamFromServer.close(); 
           
        } 
        catch(IOException i) 
        { 
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
    
    public static void main(String args[]) 
    { 
    	ServerSocketTest server = new ServerSocketTest(5000); 
    } 
} 