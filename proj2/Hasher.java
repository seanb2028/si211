/**
 * @author Sean Beckford
 */
public interface Hasher {
  public String getAlgName();
  public void init(char[] key) throws CipherException;
  public String hashInto(char[] pass) throws CipherException;
}