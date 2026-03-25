/**
 * @author Sean Beckford
 */
public abstract class ShiftCipher extends Cipher implements Encryptor {
    public abstract String encrypt(String plain) throws CipherException;
    public abstract String decrypt(String cipher) throws CipherException;
}