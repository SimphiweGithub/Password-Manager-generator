package passwordmanagercreator;

import java.util.Random;
import javax.swing.*;

public class PasswordManagerCreator {

    private static final String PASSWORD_RANGE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertuiopasdfghjklzxcvbnm@!#";
    private int limit = 0;
    private String password = "";
    private String websiteName = "";

    public static void main(String[] args) {
        PasswordManagerCreator manager = new PasswordManagerCreator();

        manager.askForPasswordLength();
        manager.askWebsiteName();
        manager.generatePassword();
        
        System.out.println("Your App/Website Name: " + manager.getwebsiteName());
        System.out.println("Your Generated Password: " + manager.getPassword());
    }

    private void generatePassword() {
        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder(limit);

        for (int i = 0; i < limit; i++) {
            int index = random.nextInt(PASSWORD_RANGE.length());
            passwordBuilder.append(PASSWORD_RANGE.charAt(index));
        }

        password = passwordBuilder.toString();
    }

    private void askForPasswordLength() {
        try {
            limit = Integer.parseInt(JOptionPane.showInputDialog("Please specify how long your password should be:"));
            if (limit <= 0) {
                JOptionPane.showMessageDialog(null, "Password length must be greater than 0 Try Again");
                askForPasswordLength();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            askForPasswordLength();
        }
    }
    
    private void askWebsiteName(){
     websiteName = JOptionPane.showInputDialog(null, "What is the website/app name");
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

    public String getwebsiteName() {
        return websiteName;
    }

    public void setwebsiteName(String websiteURL) {
        this.websiteName = websiteURL;
    }
}
