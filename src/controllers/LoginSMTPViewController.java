package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import utils.JsonReader;
import utils.JsonWriter;
import utils.ValidatorSMTP;
import views.LoginSMTPView;
import views.MainView;

public class LoginSMTPViewController implements ActionListener, MouseListener {

    JsonWriter jsonwriter = new JsonWriter();

    private LoginSMTPView loginSMTPView;

    public LoginSMTPViewController(LoginSMTPView loginSMTPView) {
        this.loginSMTPView = loginSMTPView;
        loginSMTPView.getBtnLogin().addActionListener(this);
        loginSMTPView.getLabelBackButton().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (loginSMTPView.getBtnLogin().equals(e.getSource())) {
            JSONObject temp = JsonReader.getJson("src/utils/temp.txt");
            ValidatorSMTP validator = new ValidatorSMTP();
            if (validateFields()) {

                temp.put("password", loginSMTPView.getPassfieldPassword().getText());
                temp.put("email", loginSMTPView.getTxtEmail().getText());
                temp.put("port", loginSMTPView.getTxtPort().getText());
                temp.put("host", loginSMTPView.getTxtHost().getText());
                jsonwriter.Write("src/utils/temp.txt", temp);
                

                if (validator.validate()) {
                    JOptionPane.showMessageDialog(null, "Login Correcto");
                    temp.put("logged", true);
                    MainView mainview = new MainView();
                    mainview.setVisible(true);
                    mainview.setLocationRelativeTo(null);
                    MainViewController mainviewcontroller = new MainViewController(mainview);
                    loginSMTPView.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Incorrecto");
                    temp.put("logged", false);
                }
                
            } else {

                JOptionPane.showMessageDialog(null, "Porfavor complete todos los campos");
                temp.put("logged", false);

            };
            jsonwriter.Write("src/utils/temp.txt", temp);

        }
    }

    public boolean validateFields() {
        if (loginSMTPView.getTxtEmail().getText().length() > 0 && loginSMTPView.getPassfieldPassword().getText().length() > 0 && loginSMTPView.getTxtHost().getText().length() > 0 && loginSMTPView.getTxtPort().getText().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.loginSMTPView.getLabelBackButton().equals(e.getSource())){       
            
            this.loginSMTPView.setVisible(false);
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
