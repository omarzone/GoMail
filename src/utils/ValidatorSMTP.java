package utils;

import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import org.json.JSONObject;

public class ValidatorSMTP {

    public boolean validate() {
        JSONObject temp = JsonReader.getJson("src/utils/temp.txt");
        int port;
        try {
            port = Integer.valueOf(temp.getInt("port"));
        } catch (Exception e) {
            port = 0;
        }
        String host = temp.getString("host");
        String user = temp.getString("email");
        String pwd = temp.getString("password");

        try {
            Properties props = new Properties();
            // required for gmail 
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            // or use getDefaultInstance instance if desired...
            Session session = Session.getInstance(props, null);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, port, user, pwd);
            transport.close();
            return true;
        } catch (AuthenticationFailedException e) {
            System.out.println("AuthenticationFailedException - for authentication failures");
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            System.out.println("For other failures");
            e.printStackTrace();
            return false;
        }
    }
}
