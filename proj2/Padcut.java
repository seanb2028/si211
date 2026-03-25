/**
 * @author Sean Beckford
 */
public class Padcut extends Cipher implements Hasher {
    public String getAlgName() { return "padcut"; }
    // Hash algorithm for the password
    public String hashInto(char[] pass) {
        String hash = "";
        if (pass.length < 16) {
            hash = new String(pass); 
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