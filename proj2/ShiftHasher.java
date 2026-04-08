/**
 * This is the bridge for ShiftCaesar and ShiftVigenere
 * @author Sean Beckford
 */
public abstract class ShiftHasher extends Cipher implements Hasher {
    protected abstract Encryptor getEncryptor();

    public String hashInto(char[] pass) throws CipherException {
        char[] x = "GO_NAVY_2018^mid".toCharArray();
        Encryptor enc = getEncryptor();

        // So we can encrypt later
        enc.init(pass);

        // Shift+Caesar algorithm
        for (int i = 0; i <= 15; i++) {
            int k = (int) x[i] % 16;
            String s = new String(x);
            // Run Caesar encryption algorithm
            x = enc.encrypt(s.substring(k) + s.substring(0, k)).toCharArray();
       }
       return new String(x);
    }
}