/**
 * @author Sean Beckford
 */
public class ShiftVigenere extends Cipher implements Hasher {
    public String getAlgName() { return "shift+vigenere"; }
    public void init(char[] key) throws CipherException { this.shift = key; }

    // Hashing algorithm for clear
    public String hashInto(char[] pass) throws CipherException {
        char[] x = "GO_NAVY_2018^mid".toCharArray();
        Vigenere v = new Vigenere();

        // So we can encrypt later
        v.init(pass);

        // Shift+Caesar algorithm
        for (int i = 0; i <= 15; i++) {
            int k = (int) x[i] % 16;
            String s = new String(x);
            // Run Caesar encryption algorithm
            x = v.encrypt(s.substring(k) + s.substring(0, k)).toCharArray();
       }
       return new String(x);
    }
}