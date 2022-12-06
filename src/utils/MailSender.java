package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class MailSender {

    private String correoDeOrigen;
    private String correoDeDestino;
    private String asunto;
    private String mensajeDeTexto;
    private String contrasena16Digitos;

//     public static void main(String[] args) {
//       MailSender correo = new MailSender("demo231120@outlook.com", "fredyabisaimanzanero@gmail.com", "Rapidin", "Hola martin", "VivaPeru");
//       correo.envioDeCorreos();
//     }
    
    public MailSender(String origen, String destino, String asunto,
            String txt, String contra16Digitos) {
        this.correoDeOrigen = origen;
        this.correoDeDestino = destino;
        this.asunto = asunto;
        this.mensajeDeTexto = txt;
        this.contrasena16Digitos = contra16Digitos;

    }

    public boolean envioDeCorreos() {
        return envioDeMensajes();
    }

    private boolean envioDeMensajes() {
        try {
             JSONObject data = JsonReader.getJson("src/utils/temp.txt");

        String host = data.getString("host");
        String email = data.getString("email");
        String password = data.getString("password");
            
            Properties props = new Properties();
            props.put("mail.smtp.host", data.getString("host"));
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", data.getString("host"));
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", email);
            props.setProperty("mail.smtp.auth", "true");
            Session session = Session.getInstance(props);
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(email));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDeDestino));
            mensaje.setSubject(asunto);
            mensaje.setText(mensajeDeTexto);

            Transport t = session.getTransport("smtp");
            t.connect(email, password);

            Store store = session.getStore("imaps");

// Connect to store
//            store.connect("outlook.office365.com", "demo231120@outlook.com", "VivaPeru");
            store.connect(host, email, password);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
//            session.getDebugOut();
            JOptionPane.showMessageDialog(null, "Mensaje enviado");
            return true;
        } catch (MessagingException e) {
            System.out.println(e);
        }
        return false;
    }
}
