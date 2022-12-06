/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import components.FolderItemComponent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author marti
 */
public class FolderItemController implements MouseListener {

    private FolderItemComponent folderItem;
    
    public FolderItemController(FolderItemComponent folderItem) {
        this.folderItem = folderItem;
        folderItem.getComponentFolderItem().addMouseListener(this);
        System.out.println("folder cargado");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (folderItem.getComponentFolderItem().equals(e.getSource())) {
            System.out.println("Presionaste: " + folderItem.getTxtFolderName().getText());
            try {
                MainViewController.loadMails(folderItem.getTxtFolderName().getText());

                MainViewController.getMainView().getPanelMailsBox().removeAll();
                MainViewController.getMainView().getPanelMailsBox().add(MainViewController.loadMails(folderItem.getTxtFolderName().getText()));
                MainViewController.getMainView().getPanelMailsBox().repaint();
                MainViewController.getMainView().getPanelMailsBox().revalidate();
                MainViewController.getMainView().getFolderNameTitle().setText(folderItem.getTxtFolderName().getText());

            } catch (MessagingException ex) {
                Logger.getLogger(FolderItemController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FolderItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
