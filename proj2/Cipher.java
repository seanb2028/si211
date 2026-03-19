/**
 * This class serves as a base class for the
 * Caesar and Vigenere ciphers to eliminate 
 * duplication of code.
 * 
 * @author Sean Beckford
 */
public abstract class Cipher implements Encryptor {
    protected char[] shift;

    public void checkBounds(char c, String type) throws CipherException {
        if (42 > (int) c || (int) c > 122) throw new CipherException("error " + c + " not allowed in " + type);
    }

    public void init(char[] key) throws CipherException { 
        for (int i = 0; i < key.length; i++) { checkBounds(key[i], "key"); }
        this.shift = key; 
    }
}