/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import components.BackgroundImageComponent;
import components.NewMailComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JPanel;
import org.json.JSONObject;
import utils.JsonReader;
import utils.MailSender;
import views.MainView;
/**
 *
 * @author PC GOOSE
 */
public class NewMailComponentController implements ActionListener {
    private NewMailComponent newMailComponent;
    private String senderMail;
    private final JSONObject temp = JsonReader.getJson("src/utils/temp.txt");

    public NewMailComponentController(NewMailComponent newMailComponent, String senderMail) {
        this.newMailComponent = newMailComponent;
        this.senderMail = senderMail;
        this.initActions(this.newMailComponent);
        
        MainViewController.switchPanels(newMailComponent);
    }
    
    public NewMailComponentController(NewMailComponent newMailComponent) {
        this.newMailComponent = newMailComponent;
        this.senderMail = "";
        this.initActions(this.newMailComponent);
        
        MainViewController.switchPanels(newMailComponent);
    }
    
    private void initActions(NewMailComponent newMailComponent){ //Se realizo refactorización de hide method
        newMailComponent.getBtnSend().addActionListener(this); 
        newMailComponent.getBtnCancel().addActionListener(this);
        newMailComponent.getTxtSenderName().setText(senderMail);
        newMailComponent.getLblUserName().setText(temp.getString("email"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (newMailComponent.getBtnSend().equals(e.getSource())) {
            System.out.println("Se ha apretado el boton de enviar");
            System.out.println(newMailComponent.getLblUserName().getText()+ newMailComponent.getTxtSenderName().getText() +newMailComponent.getTxtSubject().getText() + newMailComponent.getjTextArea1().getText() + temp.getString("password"));

            MailSender mailSender = new MailSender(newMailComponent.getLblUserName().getText(), newMailComponent.getTxtSenderName().getText(), newMailComponent.getTxtSubject().getText(), newMailComponent.getjTextArea1().getText(), temp.getString("password"));
            if (mailSender.envioDeCorreos()) {
                setBackgroundImage();
            }
        }
        
        if (newMailComponent.getBtnCancel().equals(e.getSource())) { //En esta parte se realizo la refactorización de consolidate code fragment
            System.out.println("Se ha apretado el boton de Cancelar");
            this.setBackgroundImage();
        }
    }
    
    
    private void setBackgroundImage(){
        BackgroundImageComponent backgroundImage = new BackgroundImageComponent();
        MainViewController.switchPanels(backgroundImage);
    }

    

    
    
    
   
    
}
