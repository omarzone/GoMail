
package test;

import com.formdev.flatlaf.FlatDarkLaf;
import controllers.SMTPViewController;
import views.SMTPView;

public class RunSMTPSelector {
    
     public static void main(String args[]) {
        FlatDarkLaf.setup();
        SMTPView smtpView = new SMTPView();
        smtpView.setVisible(true);
        smtpView.setLocationRelativeTo(null);
        
        SMTPViewController SMTPViewController = new SMTPViewController(smtpView);
        
        
        
    }
    
    
}
