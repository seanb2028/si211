/**
 * @author Sean Beckford
 */
public class ShiftCaesar extends ShiftHasher {
    protected Encryptor getEncryptor() { return new Caesar(); }

    public String getAlgName() { return "shift+caesar"; }
}