package hu.gaborbalazs.security;

public class App {

    public static void main(String[] args) {

        System.out.println(">> main");

        String password = "hello123";
        String encryptedPassword = Sha512Crypt.sha512Crypt(password, "", 0);
        
        System.out.println("Password: " + password + ", Encrypted: " + encryptedPassword);
        System.out.println("Verify: " + Sha512Crypt.verifyPassword(password, encryptedPassword));
        
        System.out.println("<< main");
    }

}
