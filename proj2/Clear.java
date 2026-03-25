/**
 * Encryptor providing the clear algorithm, which is to
 * not change the plaintext at all.
 * 
 * @author Sean Beckford
 */
public class Clear extends ShiftCipher {
  public String getAlgName() { return "clear"; }
  public String encrypt(String plain) throws CipherException { 
    char[] p = plain.toCharArray();
    for(int i = 0; i < p.length; i++) { checkBounds(p[i], "plaintext"); }
    return new String(p); 
  }
  public String decrypt(String cipher) { 
    return cipher;
  }
}