/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import utils.JsonReader;
import utils.JsonWriter;
import views.UserSettingsView;

/**
 *
 * @author PC GOOSE
 */
public class UserSettingsViewController implements ActionListener, MouseListener{
    private UserSettingsView userSettingsView;
    private JSONObject profileInfo;

    public UserSettingsViewController(UserSettingsView userSettingsView) {
        this.userSettingsView = userSettingsView;
        this.profileInfo = JsonReader.getJson("src/utils/temp.txt");
        this.initActions();
        this.setData();
        userSettingsView.getLabelBackButton().addMouseListener(this);
        
        MainViewController.getMainView().setVisible(false);
        this.userSettingsView.setVisible(true);
        this.userSettingsView.setLocationRelativeTo(null);

    }
    
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.userSettingsView.getBtnDeleteData().equals(e.getSource())){
            JsonWriter jsonwriter = new JsonWriter();
            profileInfo.put("host", "");
            profileInfo.put("email", "");
            profileInfo.put("port", "");
            profileInfo.put("password", "");
            profileInfo.put("logged", false);
            jsonwriter.write("src/utils/temp.txt", profileInfo);
            JOptionPane.showMessageDialog(null, "Debe reiniciar la aplicación");
            System.exit(0);
        }
        
        
    }
    
    private void initActions(){
        this.userSettingsView.getBtnDeleteData().addActionListener(this);

    }
   
    private void setData(){
        this.userSettingsView.getTxtHost().setText(profileInfo.getString("host"));
        this.userSettingsView.getTxtHost().enable(false);
        this.userSettingsView.getTxtEmail().setText(profileInfo.getString("email"));
        this.userSettingsView.getTxtEmail().enable(false);
        this.userSettingsView.getTxtPort().setText(String.valueOf(profileInfo.getInt("port")));
        this.userSettingsView.getTxtPort().enable(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.userSettingsView.getLabelBackButton().equals(e.getSource())){       
            
            this.userSettingsView.setVisible(false);
            MainViewController.getMainView().setVisible(true);
            MainViewController.getMainView().setAlwaysOnTop(true);
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
