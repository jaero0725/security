package kr.ac.zerco;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static final String key = "aesEncryptionKey"; //16Byte == 128bit
	private static final String initVector = "encryptionIntVec"; //16Byte
	
	//인코더 생성
	private static final Base64.Encoder enc = Base64.getEncoder(); 
	
	//디코더 생성
	private static final Base64.Decoder dec = Base64.getDecoder();
	
	public static String encrypt(String value) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8")); // 초기화백터 byte로 변경
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES"); // byte로 변경
	 
	        //cipher를 만들
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING"); //AES, CBC모드, partial block 채우기
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv); // mode 
	 
	        //실제로 암호화 하는 부분
	        byte[] encrypted = cipher.doFinal(value.getBytes()); 
	        return enc.encodeToString(encrypted); //암호문을 base64로 인코딩하여 출력 해줌
	        
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	public static String decrypt(String encrypted) {
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	        byte[] original = cipher.doFinal(dec.decode(encrypted)); //base64 to byte 

	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		String originalString = "Plain text는 여러개의 블럭으로 나누어져있다.\r\n" + 
				"\r\n" + 
				"블럭이 128비트라고 하면 각각의 블럭으로 암호화 하는 방식에 대해서는 DES, TripleDES, AES를 통해 알 수 있다.\r\n" + 
				"출처: https://zeroco.tistory.com/63 [zeroco]";
		
	    System.out.println("Original String to encrypt - " + originalString);
	    
	    //암호화
	    String encryptedString = encrypt(originalString);
	    System.out.println("Encrypted String - " + encryptedString);

	    //복호화
	    String decryptedString = decrypt(encryptedString);
	    System.out.println("After decryption - " + decryptedString);
	}

}
