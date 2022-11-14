/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author Pablo
 */

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
            LoginView LoginViewOpen = new LoginView();
            LoginViewOpen.setLocationRelativeTo(null);
            this.smtpview.setVisible(false);
            LoginViewOpen.setVisible(true);
        
        }
        
         if(this.smtpview.getBtnOutlook().equals(e.getSource())){       
            LoginView LoginViewOpen = new LoginView();
            LoginViewOpen.setLocationRelativeTo(null);
            this.smtpview.setVisible(false);
            LoginViewOpen.setVisible(true);
        
        }
        
        if(this.smtpview.getBtnPersonalized().equals(e.getSource())){       
            LoginSMTPView LoginSMTPViewOpen = new LoginSMTPView();
            LoginSMTPViewOpen.setLocationRelativeTo(null);
            this.smtpview.setVisible(false);
            LoginSMTPViewOpen.setVisible(true);
        
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
