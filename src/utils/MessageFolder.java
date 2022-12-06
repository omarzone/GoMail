package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.SearchTerm;
import models.Mail;
import org.json.JSONObject;
import utils.JsonReader;

public class MessageFolder {

    private static String host;
    private static String email;
    private static String password;
    private static ArrayList<Mail> mails;
    private static Folder folder;

    public ArrayList<Mail> getEmails(String folderName) throws MessagingException, IOException {
        MessageFolder.mails = new ArrayList<Mail>();
        JSONObject data = JsonReader.getJson("src/utils/temp.txt");
        host = data.getString("host");
        email = data.getString("email");
        password = data.getString("password");

        // Create empty properties
        Properties props = new Properties();

        // Get session
        Session session = Session.getDefaultInstance(props, null);

        // Get the store
        Store store = session.getStore("imaps");

        // Connect to store
        store.connect(host, email, password);

        Folder[] f = store.getDefaultFolder().list("*");
        for (Folder fd : f) {
            System.out.println(">> " + fd.getName());
        }
        // Get folder
        MessageFolder.folder = store.getFolder(folderName);

        // Open read-only
        folder.open(Folder.READ_ONLY);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Message messages[] = folder.getMessages();
        System.out.println(messages.length);
        for (int i = 0, n = messages.length; i < n; i++) {
            Message temp = messages[i];
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
            mails.add(new Mail(temp.getFrom()[0].toString(), temp.getSubject(), messageContent, temp.getSentDate()));
        }
        return reverseList(mails);

    }

    public static ArrayList<Mail> getMails() {
        return mails;
    }

    public static void setMails(ArrayList<Mail> mails) {
        MessageFolder.mails = mails;
    }
    
    public static ArrayList<Mail> searchMails(String term) throws MessagingException, IOException {
        MessageFolder.mails = new ArrayList<Mail>();
        JSONObject data = JsonReader.getJson("src/utils/temp.txt");
        host = data.getString("host");
        email = data.getString("email");
        password = data.getString("password");

        // Create empty properties
        Properties props = new Properties();

        // Get session
        Session session = Session.getDefaultInstance(props, null);

        // Get the store
        Store store = session.getStore("imaps");

        // Connect to store
        store.connect(host, email, password);
        SearchTerm searchTerm = new SearchTerm() {
            @Override
            public boolean match(Message msg) {
                try {
                    return msg.getSubject().contains(term);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
        Message[] messages = MessageFolder.folder.search(searchTerm);
        System.out.println(messages.length);
        for (int i = 0, n = messages.length; i < n; i++) {
            Message temp = messages[i];
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
            mails.add(new Mail(temp.getFrom()[0].toString(), temp.getSubject(), messageContent, temp.getSentDate()));
        }
        return reverseList(mails);
    }


    public static <T> ArrayList<T> reverseList(ArrayList<T> list) {
        ArrayList<T> reverse;
        reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }
}
