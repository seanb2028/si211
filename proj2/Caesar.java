/**
 * Implementation of a Caesar cipher encryption algorithm
 * using the Encryptor interface.
 * 
 * @author Sean Beckford
 */
public class Caesar extends Cipher {
    private char sc; // Shift character

    public String getAlgName() { return "caesar"; }

    // Caesar shift encryption
    public String encrypt(String plain) throws CipherException { 
        // Find the shift character
        int key_sum = 0;
        for (int i = 0; i < shift.length; i++) {
            key_sum += (int) shift[i] - 42;
        }
        // Final computation
        sc = (char) (42 + ((18 + key_sum) % 81));
        
        // Encrypt using the shift character
        char[] cipher = plain.toCharArray();
        for (int i = 0; i < cipher.length; i++) {
            checkBounds(cipher[i], "plaintext");
            int k = (int) sc - 42;
            int p = (int) cipher[i] - 42;
            int c = (p + k) % 81;
            cipher[i] = (char) (42 + c);
        }

        return new String(cipher); 
    }

    // Caesar shift decryption
    public String decrypt(String cipher) throws CipherException { 
        // Decrypt using the shift character
        char[] plain = cipher.toCharArray();
        for (int i = 0; i < plain.length; i++) {
            checkBounds(plain[i], "ciphertext");
            int k = (int) sc - 42;
            int c = (int) plain[i] - 42;
            int p = (c + (81 - k)) % 81;
            plain[i] = (char) (42 + p);
        }
        
        return new String(plain); 
    }
}