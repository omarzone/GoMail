package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import utils.JsonReader;
import views.LoginView;
import utils.JsonWriter;
import utils.ValidatorSMTP;
import views.MainView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.SMTPView;


public class LoginViewController implements ActionListener, MouseListener{
    
    JsonWriter jsonwriter = new JsonWriter();

    private LoginView loginView;
    private String providerHost;
    private final String providerPort = "587";

    public LoginViewController(LoginView loginView, String provider) {
        this.loginView = loginView;
        setDefaultHost(provider);
        loginView.getbtnLogin().addActionListener(this);

        loginView.getLabelBackButton().addMouseListener(this);
        
        


    }

    private void setDefaultHost(String provider) {
        if (provider.equals("outlook")) {
            System.out.println("Seteando Outlook como proveedor de mails");
            providerHost = "smtp-mail.outlook.com";
        } else if (provider.equals("gmail")) {
            System.out.println("Seteando Gmail como proveedor de mails");
            providerHost = "smtp.gmail.com";
        } else {
            providerHost = "unknownHost";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
                
        
        if (loginView.getbtnLogin().equals(e.getSource())) {
            JSONObject temp = JsonReader.getJson("src/utils/temp.txt");
            ValidatorSMTP validator = new ValidatorSMTP();
            if (validateFields()) {

                temp.put("password", loginView.getpassfieldPassword().getText());
                temp.put("email", loginView.gettxtEmail().getText());
                temp.put("host", providerHost);
                temp.put("port", providerPort);
                jsonwriter.Write("src/utils/temp.txt", temp);
                if (validator.validate()) {
                    JOptionPane.showMessageDialog(null, "Login Correcto");
                    MainView mainview = new MainView();
                    mainview.setVisible(true);
                    mainview.setLocationRelativeTo(null);
                    MainViewController mainviewcontroller = new MainViewController(mainview);
                    loginView.setVisible(false);
                    temp.put("logged", true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Incorrecto");
                    temp.put("logged", false);
                }
                jsonwriter.Write("src/utils/temp.txt", temp);

            } else {
                JOptionPane.showMessageDialog(null, "Ingresar todos los datos");
            };

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

    
    
   

        

    public boolean validateFields() {
        if (loginView.gettxtEmail().getText().length() > 0 && loginView.getpassfieldPassword().getText().length() > 0) {
            return true;
        }
        return false;
    }
}

