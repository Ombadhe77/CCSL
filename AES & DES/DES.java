import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

class DES {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        String message = "Sanjivani College";
        byte[] myMessage = message.getBytes(); 
        
        KeyGenerator myGenerator = KeyGenerator.getInstance("DES");
        SecretKey myDesKey = myGenerator.generateKey();

        Cipher myCipher = Cipher.getInstance("DES");

        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] myEncryptedBytes = myCipher.doFinal(myMessage);

        myCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] myDecryptedBytes = myCipher.doFinal(myEncryptedBytes);

        String encryptedData = Base64.getEncoder().encodeToString(myEncryptedBytes);
        String decryptedData = new String(myDecryptedBytes);

        System.out.println("Message: " + message);
        System.out.println("Encrypted: " + encryptedData); 
        System.out.println("Decrypted Message: " + decryptedData);
    }
}
