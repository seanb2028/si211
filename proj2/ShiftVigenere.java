/**
 * @author Sean Beckford
 */
public class ShiftVigenere extends ShiftHasher {
    protected Encryptor getEncryptor() { return new Vigenere(); }

    public String getAlgName() { return "shift+vigenere"; }
}