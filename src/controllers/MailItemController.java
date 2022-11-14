
package controllers;

import components.MailItem;
import models.Mail;

public class MailItemController {
    
    MailItem mailItem;
    Mail mail;
    public MailItemController(MailItem mailItem, Mail mail){
        this.mailItem = mailItem;
        this.mail = mail;
        setData();
    }
    
    public void setData(){
        String name = mail.getEmail().substring(0, mail.getEmail().indexOf('<'));
        mailItem.getEmailName().setText(name);
        mailItem.getSubject().setText(mail.getSubject());
        mailItem.getMessage().setText(mail.getMessage());
        mailItem.getLabelShortName().setText(String.valueOf(name.charAt(0)));
    }
    
    
}
