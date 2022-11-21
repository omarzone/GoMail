/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import components.MailContentComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Mail;

/**
 *
 * @author polil
 */
public class MailContentComponentController implements ActionListener{

    static private MailContentComponent mailContentView;
    private Mail mail;
    public MailContentComponentController(MailContentComponent mailContentView, Mail mail) {
        MailContentComponentController.mailContentView = mailContentView;
        this.mail = mail;
        MailContentComponentController.mailContentView.getBtnResponse().addActionListener(this);
        setDataToTheMailContent();
    }

    public static MailContentComponent getMailContentView() {
        return mailContentView;
    }
    private void setDataToTheMailContent(){
        mailContentView.getaTxtMailText().setText(mail.getMessage());
        mailContentView.getTxtSubjectMail().setText(mail.getSubject());
        mailContentView.getTxtSenderMail().setText(mail.getEmail());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(MailContentComponentController.mailContentView.getBtnResponse().equals(e.getSource())){
            JOptionPane.showMessageDialog(null, "mensaje pa responder");
        }
        
    }
    
    
}
