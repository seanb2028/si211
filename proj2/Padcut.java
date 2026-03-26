/**
 * @author Sean Beckford
 */
public class Padcut extends Hasher {
    public String getAlgName() { 
        return "padcut"; 
    }

    // Hash algorithm for the password
    public <T extends Encryptor> String hashInto(char[] pass, T enc) throws CipherException {
        String hash = "";
        if (pass.length < 16) {
            // Clear encryption (does nothing
            hash = enc.encrypt(new String(pass)); 
            for (int i = pass.length; i < 16; i++)
                hash += "x";
        }
        else {
            for (int i = 0; i < 16; i++) 
                hash += pass[i];
        }
        // Result
        return hash;
    }
}