package passwordmanagercreatorap;


import java.util.Random;
import javax.swing.*;


public class PasswordHandler {
/*
 For now i cant have the dtabase up for public use but im planning to in the future   
    
    
    
    
    
    */
    private static final String PASSWORD_RANGE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertuiopasdfghjklzxcvbnm@!#";
    private int limit;
    private String password;
    private String websiteName_URL;
    private String userName;
    private String email;

    public static void main(String[] args) {
        PasswordHandler manager = new PasswordHandler();

       
        manager.askForPasswordLength();
        manager.askWebsiteName();
        manager.generatePassword();
        manager.askUsername();
        manager.askEmail();

      
        JOptionPane.showMessageDialog(null, "Your App/Website Name: " + manager.getWebsiteName_URL(), "Information", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your Generated Password: " + manager.getPassword(), "Information", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your Email: " + manager.getEmail(), "Information", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your Username: " + manager.getUserName(), "Information", JOptionPane.INFORMATION_MESSAGE);

        // Save to database
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.savePasswordDetails(manager.getPassword(), manager.getWebsiteName_URL(), manager.getUserName(), manager.getEmail());
    }

     void generatePassword() {
        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder(limit);

        for (int i = 0; i < limit; i++) {
            int index = random.nextInt(PASSWORD_RANGE.length());
            passwordBuilder.append(PASSWORD_RANGE.charAt(index));
        }

        password = passwordBuilder.toString();
    }

    private void askForPasswordLength() {
        while (true) {
            try {
                limit = Integer.parseInt(JOptionPane.showInputDialog("Please specify how long your password should be (1-30):"));
                if (limit > 0 && limit <= 30) {
                    break;
                }
                JOptionPane.showMessageDialog(null, "Password length must be between 1 and 30. Try again.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    private void askWebsiteName() {
        while (true) {
            websiteName_URL = JOptionPane.showInputDialog(null, "What is the website/app/URL name?");
            if (websiteName_URL != null && !websiteName_URL.trim().isEmpty()) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Website name cannot be empty. Try again.");
        }
    }

    private void askUsername() {
        while (true) {
            userName = JOptionPane.showInputDialog(null, "What is the Username?");
            if (userName != null && !userName.trim().isEmpty()) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Username cannot be empty. Try again.");
        }
    }

    private void askEmail() {
        while (true) {
            email = JOptionPane.showInputDialog(null, "What is the associated Email?");
            if (email != null && !email.trim().isEmpty()) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Email cannot be empty. Try again.");
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsiteName_URL() {
        return websiteName_URL;
    }

    public void setWebsiteName_URL(String websiteName_URL) {
        this.websiteName_URL = websiteName_URL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
