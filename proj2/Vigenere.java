import javax.crypto.Cipher;

/**
 * Implementation of a Vigenere cipher encryption algorithm
 * using the Encryptor interface.
 * 
 * @author Sean Beckford
 */
public class Vigenere extends Cipher {
    public String getAlgName() { return "vigenere"; }

    protected int getShiftAt(int index) {
        return (int) shift[index % shift.length] - 42;
    }
}