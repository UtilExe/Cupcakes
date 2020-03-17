package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User(String username, String email, String password, int mobilNr ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobilNr = mobilNr;
    }


    private String username;
    private String email;
    private String password; // Should be hashed and secured
    private int mobilNr;
    private int saldo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMobilNr() {
        return mobilNr;
    }

    public void setMobilNr(int mobilNr) {
        this.mobilNr = mobilNr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
