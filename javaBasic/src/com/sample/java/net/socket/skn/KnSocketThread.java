package com.sample.java.net.socket.skn;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class KnSocketThread {
	
	 // class name
    public static DataInputStream inStreamFromServer;
    private static boolean isInitialized;
    private static KnSocketThread readSockDataInstance;
    public static Socket socket;

    final private int TLV_HEADER_SIZE = 6 ;
    final private int BUFFER_INDEX_ZERO = 0 ;
    final private int BYTE_ARRAY_INDEX_1 = 1 ;
    final private int BYTE_ARRAY_INDEX_2 = 2 ;

    public static KnSocketThread getInstance(Socket socket1) {
        if (!isInitialized) {
            if (readSockDataInstance == null) {
                socket = socket1;
                readSockDataInstance = new KnSocketThread();
                isInitialized = true;
            }
        }
        return readSockDataInstance;
    }

    /**
     * Keep reading over the socket for the responses
     */
    public void run() {
        final String methodName = "run()";
        byte[] readByteArray = null;
        try {
            inStreamFromServer = new DataInputStream(socket.getInputStream());
            while (true) {
                try {
                    byte[] header = new byte[TLV_HEADER_SIZE];
                    int headerLength = inStreamFromServer.read(header, 0, TLV_HEADER_SIZE);

                    if (headerLength == -1) {
                        handleSocketFailure();
                        continue;
                    }

                    if (headerLength == 0) {
                        continue;
                    }

                    byte[] payloadArray = readPayload(header);
                    byte[] result = concatenateArrays(header, payloadArray);

                    KnPoCXLAClient.publishEvent(result);
                } catch (IOException e) {
                    handleSocketFailure();
                }
            }
        } catch (IOException e) {
            try {
                handleSocketFailure();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                inStreamFromServer.close();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }

    private void handleSocketFailure() throws IOException {
        isConnected = false;
        socket = KnPoCXLAClient.reconnectSocket();
        inStreamFromServer = new DataInputStream(socket.getInputStream());
    }

    private byte[] readPayload(byte[] header) throws IOException {
        byte[] bTemp = new byte[]{header[1], header[2]};
        int payloadLength = (getValueFromBytes(bTemp) - TLV_HEADER_SIZE);
        byte[] payloadArray = new byte[payloadLength];
        inStreamFromServer.read(payloadArray, 0, payloadLength);
        return payloadArray;
    }

    private byte[] concatenateArrays(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public Integer getValueFromBytes(byte[] abyte0) {
        int l = 0;
        int lvalue = 0;
        int length = abyte0.length;
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
