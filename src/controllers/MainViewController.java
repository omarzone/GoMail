/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import components.MailContentComponent;
import components.NewMailComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import org.json.JSONObject;
import utils.JsonReader;
import utils.MailSender;
import views.MainView;

/**
 *
 * @author PC GOOSE
 */
public class MainViewController implements MouseListener, ActionListener{
    private MainView vistaPrincipal;
    private NewMailComponent newMail;
    private JSONObject temp;

    public MainViewController(MainView vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        newMail = new NewMailComponent();
        newMail.getBtnSend().addActionListener(this);
        temp = new JSONObject();

        
        this.vistaPrincipal.getBtnCreateMail().addMouseListener(this);
        
        this.vistaPrincipal.setVisible(true);
        this.vistaPrincipal.setLocationRelativeTo(null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
      if(this.vistaPrincipal.getBtnCreateMail().equals(e.getSource())){
            temp = JsonReader.getJson("src/utils/temp.txt");
            newMail.getLblUserName().setText(temp.getString("email"));
            switchPanels(newMail);
            
            
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

    
    private void switchPanels(JPanel panel) {
        this.vistaPrincipal.getMailContent().removeAll();
        this.vistaPrincipal.getMailContent().add(panel);
        this.vistaPrincipal.getMailContent().repaint();
        this.vistaPrincipal.getMailContent().revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(newMail.getBtnSend().equals(e.getSource())){
            System.out.println("Se ha apretado el boton de enviar");

            MailSender mailSender = new MailSender(newMail.getLblUserName().getText(), newMail.getTxtSenderName().getText(), newMail.getTxtSubject().getText(), newMail.getjTextArea1().getText(),temp.getString("password"));
            if(mailSender.envioDeCorreos()){
                this.vistaPrincipal.getMailContent().removeAll();
                this.vistaPrincipal.getMailContent().repaint();
                this.vistaPrincipal.getMailContent().revalidate();
            }
        }
    }
    
}
