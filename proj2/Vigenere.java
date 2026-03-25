/**
 * Implementation of a Vigenere cipher encryption algorithm
 * using the Encryptor interface.
 * 
 * @author Sean Beckford
 */
public class Vigenere extends ShiftCipher {
    public String getAlgName() { return "vigenere"; }

    // Vigenere shift encryption
    public String encrypt(String plain) throws CipherException {
        char[] cipher = plain.toCharArray();
        for (int i = 0; i < cipher.length; i++) {
            checkBounds(cipher[i], "plaintext");
            int k = (int) shift[i % shift.length] - 42; // To handle keys smaller than plaintext
            int p = (int) cipher[i] - 42;
            int c = (p + k) % 81;
            cipher[i] = (char) (42 + c);
        }

        return new String(cipher);
    }

    // Vigenere shift decryption
    public String decrypt(String cipher) throws CipherException {
        char[] plain = cipher.toCharArray();
        for (int i = 0; i < plain.length; i++) {
            checkBounds(plain[i], "ciphertext");
            int k = (int) shift[i % shift.length] - 42; // To handles keys smaller than ciphertext
            int c = (int) plain[i] - 42;
            int p = (c + (81 - k)) % 81;
            plain[i] = (char) (42 + p);
        }

        return new String(plain);
    }
}