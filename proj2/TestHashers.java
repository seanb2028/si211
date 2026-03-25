/**
 * @author Sean Beckford
 */
import java.util.*;
public class TestHashers {
    public static void main(String[] args) throws Throwable {
        // Create ArrayList of all supported encryptors
        ArrayList<Hasher> H = new ArrayList<Hasher>();
        H.add(new Padcut());
        H.add(new ShiftCaesar());
        H.add(new ShiftVigenere());

        // Get alg,psw from user
        System.out.print("algorithm: ");
        String encalg = System.console().readLine();
        System.out.print("password : ");
        char[] password = System.console().readPassword();

        // Find encryptor (throw exception if not found)
        int i = 0;
        while(i < H.size() && !H.get(i).getAlgName().equals(encalg))
            i++;
        if (i == H.size())
            throw new Exception("Unknown algorithm '"+encalg+"'.");
        Hasher hash = H.get(i);

        // Encrypt, decrypt print sumamry of results
        hash.init(password);
        String hashtext = hash.hashInto(password);
        System.out.println("password read : " + new String(password));
        System.out.println("hash computed : " + hashtext);
    }
}
