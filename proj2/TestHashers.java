/**
 * @author Sean Beckford
 */
import java.util.*;
public class TestHashers {
    public static void main(String[] args) {
        // Create ArrayList of all supported encryptors
        ArrayList<Encryptor> E = new ArrayList<Encryptor>();
        // E.add(new Clear());

        // Get alg,psw from user
        System.out.print("algorithm: ");
        String encalg = System.console().readLine();
        System.out.print("password : ");
        char[] password = System.console().readPassword();

        // Find encryptor (throw exception if not found)
        int i = 0;
        while(i < E.size() && !E.get(i).getAlgName().equals(encalg))
        i++;
        if (i == E.size())
        throw new Exception("Unknown algorithm '"+encalg+"'.");
        Encryptor enc = E.get(i);

        // Encrypt, decrypt print sumamry of results
        enc.init(password);
        String hashtext = enc.hash(password);
        System.out.println("password read : " + new String(password));
        System.out.println("cipher: " + ciphertext);
    }
}
