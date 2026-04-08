/**
 * @author Sean Beckford
 * Where we store User Records
 */
import java.util.*;

public class UserRecord {
    private String username;
    private String hashMethod;
    private String hashedPass;
    private List<UserData> data;

    public UserRecord(String username, String hashMethod, String hashedPass) {
        this.username = username;
        this.hashMethod = hashMethod;
        this.hashedPass = hashedPass;
        this.data = new ArrayList<>();
    }

    // Getters
    public String getUser() { return username; }
    public String getHMethod() { return hashMethod; }
    public String getHPass() { return hashedPass; }
    public List<UserData> getData() { return data; }

    public void addData(UserData d) { data.add(d); }
}