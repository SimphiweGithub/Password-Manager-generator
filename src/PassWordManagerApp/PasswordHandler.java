package PassWordManagerApp;

import java.util.Random;
import javax.swing.*;

public class PasswordHandler {

    private static final String PASSWORD_RANGE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertuiopasdfghjklzxcvbnm@!#";
    private int limit = 0;
    private String password = "";
    private String websiteName_URL = "";
    private String UserName = "";
    private String Email = "";
    


    public static void main(String[] args) {
        PasswordHandler manager = new PasswordHandler();
        
        while(true){
           
        
        manager.askForPasswordLength();
        manager.askWebsiteName();
        manager.generatePassword();
        manager.askUsername();
        manager.askEmail();
        
JOptionPane.showMessageDialog(null, "Your App/Website Name: " + manager.getWebsiteName_URL(), "Information", JOptionPane.INFORMATION_MESSAGE);
JOptionPane.showMessageDialog(null, "Your Generated Password: " + manager.getPassword(), "Information", JOptionPane.INFORMATION_MESSAGE);
JOptionPane.showMessageDialog(null, "Your Email: " + manager.getEmail(), "Information", JOptionPane.INFORMATION_MESSAGE);
JOptionPane.showMessageDialog(null, "Your Username: " + manager.getUserName(), "Information", JOptionPane.INFORMATION_MESSAGE);


        
        }
       
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
     websiteName_URL = JOptionPane.showInputDialog(null, "What is the website/app/URL name");
    }
    private void askUsername(){
     UserName = JOptionPane.showInputDialog(null, "What is the Username");
    }
    private void askEmail(){
     Email = JOptionPane.showInputDialog(null, "What is the associated Email");
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

    public void setWebsiteName_URL(String websiteNameURL) {
        this.websiteName_URL = websiteName_URL;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    

}
