package controllers;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.LoginSMTPView;
import views.LoginView;
import views.SMTPView;
public class SMTPViewController implements MouseListener{
    private final SMTPView smtpview;

    public SMTPViewController(SMTPView controller) {
        this.smtpview = controller;
        this.smtpview.setVisible(true);
        this.smtpview.setLocationRelativeTo(null);
        this.smtpview.getBtnGmail().addMouseListener(this);
        this.smtpview.getBtnOutlook().addMouseListener(this);
        this.smtpview.getBtnPersonalized().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if(this.smtpview.getBtnGmail().equals(e.getSource())){       
            LoginView loginView = new LoginView();
            loginView.setLocationRelativeTo(null);
            LoginViewController loginViewController = new LoginViewController(loginView, "gmail");
            this.smtpview.setVisible(false);
            loginView.setVisible(true);
        
        }
        
         if(this.smtpview.getBtnOutlook().equals(e.getSource())){       
            LoginView loginView = new LoginView();
            LoginViewController loginViewController = new LoginViewController(loginView, "outlook");
            loginView.setLocationRelativeTo(null);
            this.smtpview.setVisible(false);
            loginView.setVisible(true);
        
        }
        
        if(this.smtpview.getBtnPersonalized().equals(e.getSource())){       
            LoginSMTPView loginSMTPView = new LoginSMTPView();
            LoginSMTPViewController loginSMTPViewController = new LoginSMTPViewController(loginSMTPView);
            loginSMTPView.setLocationRelativeTo(null);
            this.smtpview.setVisible(false);
            loginSMTPView.setVisible(true);
        
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(this.smtpview.getBtnGmail().equals(e.getSource())){
            this.smtpview.getBtnGmail().setBackground(new Color(87,89,163));
        }
        
        if(this.smtpview.getBtnOutlook().equals(e.getSource())){
            this.smtpview.getBtnOutlook().setBackground(new Color(87,89,163));
        }
        
        if(this.smtpview.getBtnPersonalized().equals(e.getSource())){
            this.smtpview.getBtnPersonalized().setBackground(new Color(87,89,163));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(this.smtpview.getBtnGmail().equals(e.getSource())){
            this.smtpview.getBtnGmail().setBackground(new Color(50,52,103));
        }
         
         if(this.smtpview.getBtnOutlook().equals(e.getSource())){
            this.smtpview.getBtnOutlook().setBackground(new Color(50,52,103));
        }
         
         if(this.smtpview.getBtnPersonalized().equals(e.getSource())){
            this.smtpview.getBtnPersonalized().setBackground(new Color(50,52,103));
        }
    }    
}
