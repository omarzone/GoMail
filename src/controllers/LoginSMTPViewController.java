package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import utils.JsonReader;
import utils.JsonWriter;
import utils.ValidatorSMTP;
import views.LoginSMTPView;
import views.MainView;

public class LoginSMTPViewController implements ActionListener {

    JsonWriter jsonwriter = new JsonWriter();

    private LoginSMTPView loginSMTPView;

    public LoginSMTPViewController(LoginSMTPView loginSMTPView) {
        this.loginSMTPView = loginSMTPView;
        loginSMTPView.getBtnLogin().addActionListener(this);

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
}
