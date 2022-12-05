/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import components.MailContentComponent;
import components.NewMailComponent;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import models.Mail;

/**
 *
 * @author polil
 */
public class MailContentComponentController implements ActionListener {

    static private MailContentComponent mailContentView;
    private Mail mail;

    public MailContentComponentController(MailContentComponent mailContentView, Mail mail) {
        System.out.println("MailContentComponentController Inicializado");
        MailContentComponentController.mailContentView = mailContentView;
        this.mail = mail;
        MailContentComponentController.mailContentView.getBtnResponse().addActionListener(this);
        setDataToTheMailContent();
    }

    public static MailContentComponent getMailContentView() {
        return mailContentView;
    }

    private void setDataToTheMailContent() {
        initJfxPanel();
        
        mailContentView.getLabelDate().setText(mail.getDateParse());
        mailContentView.getLabelTime().setText(mail.getTimeParse());
        mailContentView.getLabelShortName().setText(String.valueOf(mail.getSenderName().charAt(0)));
        mailContentView.getTxtSenderName().setText(mail.getSenderName());
        mailContentView.getTxtSubjectMail().setText(mail.getSubject());
        mailContentView.getTxtSenderMail().setText(mail.getEmail());
    }

    private void initJfxPanel() {
        final JFXPanel fxPanel = new JFXPanel();
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("InitFx Iniciado");
                mailContentView.getMailTextContent().add(fxPanel);
                initFx(fxPanel);
            }
        });
    }

    private void initFx(JFXPanel panel) {
        Scene scene = createScene();
        panel.setScene(scene);
    }

    private Scene createScene() {
        WebView myWebView = new WebView();
        WebEngine engine = myWebView.getEngine();
        engine.loadContent(mail.getMessage());
        engine.setUserAgent("Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        VBox root = new VBox();
        root.getChildren().addAll(myWebView);
        Scene scene = new Scene(root);
        return scene;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (MailContentComponentController.mailContentView.getBtnResponse().equals(e.getSource())) {
            System.out.println("Hola");
            NewMailComponent newMailComponent = new NewMailComponent();
            newMailComponent.getTxtSenderName().enable(false);
            newMailComponent.getTxtSubject().setText("RE: " + mail.getSubject());
            newMailComponent.getTxtSubject().enable(false);

            NewMailComponentController newMailComponentController = new NewMailComponentController(newMailComponent, mail.getEmail());
        }

    }

}
