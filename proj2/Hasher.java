/**
 * @author Sean Beckford
 */
public class Hasher {
    public String getAlgName() { 
        return ""; 
    };

    public <T extends Encryptor> String hashInto(char[] pass, T enc) throws CipherException {
        char[] x = "GO_NAVY_2018^mid".toCharArray();

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