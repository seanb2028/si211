/**
 * This class serves as a pure abstract base 
 * class that provides shared implementation
 * for all ciphers to eliminate duplication of code.
 * 
 * @author Sean Beckford
 */
import java.util.*;

public abstract class Cipher {
    protected char[] shift;

    public void checkBounds(char c, String type) throws CipherException {
        if (42 > (int) c || (int) c > 122) {
            throw new CipherException("error " + c + " not allowed in " + type);
        }
    }

    public void init(char[] key) throws CipherException { 
        for (int i = 0; i < key.length; i++) { 
            checkBounds(key[i], "key"); 
        }
        this.shift = key; 
    }
}