/**
 * Encryptor providing the clear algorithm, which is to
 * not change the plaintext at all.
 * 
 * @author Sean Beckford
 */
public class Clear extends Cipher {
  public String getAlgName() { return "clear"; }
  public String encrypt(String plain) { return plain; }
  public String decrypt(String cipher){ return cipher; }
}