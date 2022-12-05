
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import utils.JsonReader;
import views.LoginView;
import utils.JsonWriter;
import views.MainView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.SMTPView;

public class LoginViewController implements ActionListener, MouseListener{
    
    JsonWriter jsonwriter = new JsonWriter();
    private LoginView loginView;

    public LoginViewController(LoginView loginView) {
        this.loginView = loginView;
        loginView.getbtnLogin().addActionListener(this);
        loginView.getLabelBackButton().addMouseListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
                
        
               if(loginView.getbtnLogin().equals(e.getSource())){
                   
                   if (loginView.gettxtEmail().getText().length() > 0 && loginView.getpassfieldPassword().getText().length() > 0){
                       
                       JSONObject temp = JsonReader.getJson("src/utils/temp.txt");
                        temp.put("password", loginView.getpassfieldPassword().getText());
                        temp.put("email", loginView.gettxtEmail().getText());
                        
                        jsonwriter.Write("src/utils/temp.txt", temp);
                        
                        MainView mainview = new MainView();
                        mainview.setVisible(true);
                        mainview.setLocationRelativeTo(null);
                        MainViewController mainviewcontroller = new MainViewController(mainview);
                        loginView.setVisible(false);
                        
 
                   }else {
                        JOptionPane.showMessageDialog(null, "Ingresar todos los datos");
                   }
                   
               }
            }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.loginView.getLabelBackButton().equals(e.getSource())){       
            
            this.loginView.setVisible(false);
            SMTPViewController.getSmtpview().setVisible(true);
            SMTPViewController.getSmtpview().setAlwaysOnTop(true);
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
    
    
   
