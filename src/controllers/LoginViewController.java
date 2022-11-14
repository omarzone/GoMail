
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import utils.JsonReader;
import views.LoginView;
import utils.JsonWriter;
import views.MainView;

public class LoginViewController implements ActionListener {
    
    JsonWriter jsonwriter = new JsonWriter();
    
    private LoginView loginView;

    public LoginViewController(LoginView loginView) {
        this.loginView = loginView;
        loginView.getbtnLogin().addActionListener(this);
        
        
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
                   };
                   
               }
            }
    }
    
    
   
