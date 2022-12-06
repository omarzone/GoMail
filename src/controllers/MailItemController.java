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

    public MailItemController(MailItem mailItem, Mail mail) {
        this.mailItem = mailItem;
        this.mail = mail;
        setData();
        mailItem.addMouseListener(this);
    }

    public void setData() {
        mailItem.getLabelDate().setText(mail.getDateParse());
        mailItem.getLabelTime().setText(mail.getTimeParse());
        mailItem.getLabelSenderName().setText(mail.getSenderName());
        mailItem.getLabelSubject().setText(mail.getSubject());
        mailItem.getLabelShortMessage().setText(mail.getShortMessage());
        mailItem.getLabelShortName().setText(String.valueOf(mail.getSenderName().charAt(0)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (mailItem.equals(e.getSource())) {
            MailContentComponent mailContentView = new MailContentComponent();
            MailContentComponentController mailContentCntrl = new MailContentComponentController(mailContentView, mail);
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
