package controllers;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.LoginSMTPView;
import views.LoginView;
import views.SMTPView;
public class SMTPViewController implements MouseListener{
    private static SMTPView smtpview;

    public SMTPViewController(SMTPView controller) {
        SMTPViewController.smtpview = controller;
        SMTPViewController.smtpview.setVisible(true);
        SMTPViewController.smtpview.setLocationRelativeTo(null);
        SMTPViewController.smtpview.getBtnGmail().addMouseListener(this);
        SMTPViewController.smtpview.getBtnOutlook().addMouseListener(this);
        SMTPViewController.smtpview.getBtnPersonalized().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

         if(SMTPViewController.smtpview.getBtnGmail().equals(e.getSource())){       
            LoginView loginViewOpen = new LoginView();
            loginViewOpen.setLocationRelativeTo(null);
            LoginViewController loginViewController = new LoginViewController(loginViewOpen, "gmail");
            SMTPViewController.smtpview.setVisible(false);
            loginViewOpen.setVisible(true);

        
        }
        
         if(this.smtpview.getBtnOutlook().equals(e.getSource())){       
            LoginView loginView = new LoginView();
            LoginViewController loginViewController = new LoginViewController(loginView, "outlook");
            loginView.setLocationRelativeTo(null);
            this.smtpview.setVisible(false);
            loginView.setVisible(true);
        
        }
        

        if(SMTPViewController.smtpview.getBtnPersonalized().equals(e.getSource())){       
            LoginSMTPView loginSMTPViewOpen = new LoginSMTPView();
            LoginSMTPViewController loginSMTPViewController = new LoginSMTPViewController(loginSMTPViewOpen);
            loginSMTPViewOpen.setLocationRelativeTo(null);
            SMTPViewController.smtpview.setVisible(false);
            loginSMTPViewOpen.setVisible(true);

        
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(SMTPViewController.smtpview.getBtnGmail().equals(e.getSource())){
            SMTPViewController.smtpview.getBtnGmail().setBackground(new Color(87,89,163));
        }
        
        if(SMTPViewController.smtpview.getBtnOutlook().equals(e.getSource())){
            SMTPViewController.smtpview.getBtnOutlook().setBackground(new Color(87,89,163));
        }
        
        if(SMTPViewController.smtpview.getBtnPersonalized().equals(e.getSource())){
            SMTPViewController.smtpview.getBtnPersonalized().setBackground(new Color(87,89,163));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(SMTPViewController.smtpview.getBtnGmail().equals(e.getSource())){
            SMTPViewController.smtpview.getBtnGmail().setBackground(new Color(50,52,103));
        }
         
         if(SMTPViewController.smtpview.getBtnOutlook().equals(e.getSource())){
            SMTPViewController.smtpview.getBtnOutlook().setBackground(new Color(50,52,103));
        }
         
         if(SMTPViewController.smtpview.getBtnPersonalized().equals(e.getSource())){
            SMTPViewController.smtpview.getBtnPersonalized().setBackground(new Color(50,52,103));
        }
    }    

    public static SMTPView getSmtpview() {
        return smtpview;
    }
    
}
