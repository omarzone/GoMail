
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
        mailItem.getEmailName().setText(mail.getEmail());
        mailItem.getSubject().setText(mail.getSubject());
        mailItem.getMessage().setText(mail.getMessage());
    }
    
    
}
