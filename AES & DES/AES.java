import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

class AES {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        String message = "Sanjivani College"; 
        byte[] myMessage = message.getBytes(); 

        KeyGenerator myGenerator = KeyGenerator.getInstance("AES");
        myGenerator.init(128); 
        SecretKey myAesKey = myGenerator.generateKey();

        Cipher myCipher = Cipher.getInstance("AES");

        myCipher.init(Cipher.ENCRYPT_MODE, myAesKey);
        byte[] myEncryptedBytes = myCipher.doFinal(myMessage);

        myCipher.init(Cipher.DECRYPT_MODE, myAesKey);
        byte[] myDecryptedBytes = myCipher.doFinal(myEncryptedBytes);

        
        String encryptedData = Base64.getEncoder().encodeToString(myEncryptedBytes);
        String decryptedData = new String(myDecryptedBytes);

        
        System.out.println("Message: " + message);
        System.out.println("Encrypted : " + encryptedData); 
        System.out.println("Decrypted Message: " + decryptedData);
    }
}
