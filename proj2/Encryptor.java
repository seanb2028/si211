/**
 * Interface for objects that provide 
 * encryption functionality.
 * 
 * @author Sean Beckford
 */
public interface Encryptor {
  public String getAlgName();
  public void init(char[] key) throws CipherException;
  public String encrypt(String plain) throws CipherException;
  public String decrypt(String cipher) throws CipherException;
}