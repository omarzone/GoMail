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
import views.SMTPView;
public class SMTPViewController implements MouseListener{
    private SMTPView controller;

    public SMTPViewController(SMTPView controller) {
        this.controller = controller;
        this.controller.setVisible(true);
        this.controller.setLocationRelativeTo(null);
        this.controller.getGmailButton().addMouseListener(this);
        this.controller.getOutlookButton().addMouseListener(this);
        this.controller.getPersonalizedButton().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(this.controller.getGmailButton().equals(e.getSource())){
            this.controller.getGmailButton().setBackground(new Color(87,89,163));
        }
        
        if(this.controller.getOutlookButton().equals(e.getSource())){
            this.controller.getOutlookButton().setBackground(new Color(87,89,163));
        }
        
        if(this.controller.getPersonalizedButton().equals(e.getSource())){
            this.controller.getPersonalizedButton().setBackground(new Color(87,89,163));
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(this.controller.getGmailButton().equals(e.getSource())){
            this.controller.getGmailButton().setBackground(new Color(50,52,103));
        }
         
         if(this.controller.getOutlookButton().equals(e.getSource())){
            this.controller.getOutlookButton().setBackground(new Color(50,52,103));
        }
         
         if(this.controller.getPersonalizedButton().equals(e.getSource())){
            this.controller.getPersonalizedButton().setBackground(new Color(50,52,103));
        }
    }
    

}
