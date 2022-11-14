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
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp-mail.outlook.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correoDeOrigen);
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(correoDeOrigen));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDeDestino));
            mensaje.setSubject(asunto);
            mensaje.setText(mensajeDeTexto);

            Transport t = s.getTransport("smtp");
            t.connect(correoDeOrigen, contrasena16Digitos);

            Store store = s.getStore("imaps");

// Connect to store
            store.connect("outlook.office365.com", "demo231120@outlook.com", "VivaPeru");

            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Mensaje enviado");
            return true;
        } catch (MessagingException e) {
            System.out.println(e);
        }
        return false;
    }
}
