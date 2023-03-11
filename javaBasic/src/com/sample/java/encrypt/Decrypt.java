package com.sample.java.encrypt;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
	private static String key = "PBKDF2WithHmacSHA256";
    private static String algo = "AES";
    private static String padding = "AES/CBC/PKCS5Padding";
    public static final String SALT = "X@#5";
    public static final String SECRETKEY = "A1B8D95BA9EA5440F252C3";
    public static final String IVSTRING = "0000000000000000";
    public static final Integer KEYSIZE=256;
	public static final Integer ITERATION=1000;
    
    public static void main(String[] args) {
    	try {
			String dec = decrypt(SALT, "SF5azhEFuwZFqrjUjBHWyw", SECRETKEY, IVSTRING, KEYSIZE, ITERATION);
			System.out.println("dec :"+dec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//KnEncryptionDecryptionUtil.getInstance().decrypt(KnDBConst.SALT
    	//, lDbProps.getProperty("DBPASSWORD"), KnDBConst.SECRETKEY, KnDBConst.IVSTRING, KnDBConst.KEYSIZE, KnDBConst.ITERATION);
	}
	
	public static String decrypt(String salt, String encryptedText,String secretKey,String ivString, int keySize,int iterations) throws Exception {
        byte[] iv = ivString.getBytes();
        IvParameterSpec ivspec = new IvParameterSpec(iv);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(key);
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), iterations, keySize);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secKey = new SecretKeySpec(tmp.getEncoded(), algo);
        Cipher cipher = Cipher.getInstance(padding);
        cipher.init(Cipher.DECRYPT_MODE, secKey, ivspec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }

}
