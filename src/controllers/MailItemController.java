
package controllers;

import components.MailContentComponent;
import components.MailItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import models.Mail;

public class MailItemController implements MouseListener {
    
    MailItem mailItem;
    Mail mail;
    
    public MailItemController(MailItem mailItem, Mail mail){
        this.mailItem = mailItem;
        this.mail = mail;
        setData();
        mailItem.addMouseListener(this);
    }
    
    public void setData(){
        String name = mail.getEmail().substring(0, mail.getEmail().indexOf('<'));
        mailItem.getEmailName().setText(name);
        mailItem.getSubject().setText(mail.getSubject());
        mailItem.getMessage().setText(mail.getMessage());
        mailItem.getLabelShortName().setText(String.valueOf(name.charAt(0)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(mailItem.equals(e.getSource())){
            MailContentComponent mailContentView = new MailContentComponent();
            MailContentComponentController mailContentCntrl= new MailContentComponentController(mailContentView, mail);
            MainViewController.switchPanels(MailContentComponentController.getMailContentView());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
