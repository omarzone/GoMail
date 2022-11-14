package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import models.Mail;
import org.json.JSONObject;
import utils.JsonReader;

public class MessageFolder {

    private String host;
    private String email;
    private String password;
    private ArrayList<Mail> mails = new ArrayList<Mail>();

    public ArrayList<Mail> getEmails() throws MessagingException, IOException {
        JSONObject data = JsonReader.getJson("src/utils/temp.txt");

        host = data.getString("host");
        email = data.getString("email");
        password = data.getString("password");

        // Create empty properties
        Properties props = new Properties();

        // Get session
        Session session = Session.getDefaultInstance(props, null);

        // Get the store
        Store store = session.getStore("pop3s");

        // Connect to store
        store.connect(host, email, password);

        // Get folder
        Folder folder = store.getFolder("INBOX");

        // Open read-only
        folder.open(Folder.READ_ONLY);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Message messages[] = folder.getMessages();

        for (int i = 0, n = messages.length; i < n; i++) {
            Message temp = messages[i];

            // Display from field and subject
//            System.out.println(i + ": " + messages[i].getFrom()[0]
//                    + "\t" + messages[i].getSubject());
//
//            System.out.println(messages[i].getContent());
            String contentType = messages[i].getContentType();
            String messageContent = "";

            if (contentType.contains("multipart")) {
                Multipart multiPart = (Multipart) messages[i].getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    messageContent = part.getContent().toString();
                }
            } else if (contentType.contains("text/plain")
                    || contentType.contains("text/html")) {
                Object content = messages[i].getContent();
                if (content != null) {
                    messageContent = content.toString();
                }
            }
//            System.out.println(" Message: " + messageContent);
            mails.add(new Mail(temp.getFrom()[0].toString(), temp.getSubject(), messageContent));
        }

        // Close connection 
        folder.close(false);
        store.close();

        return mails;

    }
}
