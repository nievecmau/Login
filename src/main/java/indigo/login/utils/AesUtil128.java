package indigo.login.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AesUtil128 {

	 private final static String AES = "AES";
	    private final static String UTF8 = "UTF-8";
	    // Definir un vector inicial de 16 bytes
	   
	    private static final String iv = "IFSWYUXVOPAWOIRL";
	    private static final String keys = "IFSJHDSDJSSKIUASLOPNXAEOLGDBVXCR";

	    public static String aesEncry(String content) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
	        byte[] contentByte = content.getBytes(UTF8);
	        byte[] keyByte = keys.getBytes();
	    
	        SecretKeySpec keySpec = new SecretKeySpec(keyByte ,AES);
	        // Inicializa un vector inicial, si no se pasa, el vector inicial con todos los 0 se usa por defecto
	        byte[] initParam = iv.getBytes();
	        IvParameterSpec ivSpec = new IvParameterSpec(initParam);
	        // Especificar algoritmo de cifrado, modo de trabajo y método de llenado
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec,ivSpec);
	        byte[] encryptedBytes = cipher.doFinal(contentByte);
	        String encodedString = Base64.getEncoder().encodeToString(encryptedBytes);
	        return encodedString;
	    }

	    public static String aesDecry(String content,String keys) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
			String encryptedText = "8ubv7e1vK/hKoDyy8zWeMg==";
			String keyString = "FLBEGFIAFAPWCBUIELFSWTEQYXQNZVIF";
			String ivString = "IFSWYUXVOPAWOIRL";


			byte[] encryptedData = Base64.getDecoder().decode(encryptedText);
			byte[] key = keyString.getBytes(); // Asegúrate de que tu clave esté en el formato correcto
			byte[] iv = ivString.getBytes();   // Asegúrate de que tu IV esté en el formato correcto

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

			byte[] decryptedData = cipher.doFinal(encryptedData);
			String decryptedText = new String(decryptedData);

			System.out.println("Texto desencriptado: " + decryptedText);
            return encryptedText;
        }

}
