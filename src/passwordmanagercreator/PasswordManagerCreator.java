package passwordmanagercreator;

import java.util.Random;

public class PasswordManagerCreator {
    
    private static final String PASSWORD_RANGE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertuiopasdfghjklzxcvbnm@!#";
    private static final int LIMIT = 20;
    private static String password = "";

    
    public static String getPassword() {
        return password;
    }

   
    public static void setPassword(String password) {
        PasswordManagerCreator.password = password;
    }

    
    private static void generatePassword() {
        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder(LIMIT);

        
        for (int i = 0; i < LIMIT; i++) {
            int index = random.nextInt(PASSWORD_RANGE.length());
            passwordBuilder.append(PASSWORD_RANGE.charAt(index));
        }

        
        setPassword(passwordBuilder.toString());
    }

    
    public static void main(String[] args) {
        
        generatePassword();
        System.out.println("Generated Password: " + getPassword());
    }
}
