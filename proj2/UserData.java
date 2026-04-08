/**
 * @author Sean Beckford
 */
public class UserData {
    private String username;
    private String encMethod;
    private String encText;

    public UserData(String username, String encMethod, String encText) {
        this.username = username;
        this.encMethod = encMethod;
        this.encText = encText;
    }

    // Getters
    public String getUser() { return username; }
    public String getEncMethod() { return encMethod; } 
    public String getEncText() { return encText; }
}