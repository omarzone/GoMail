package models;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

public class Mail {

    private String email;
    private String subject;
    private String message;
    private String senderName;
    private Date receiveDate;
    private String shortMessage;
    private String dateParse;
    private String timeParse;

    public Mail(String email, String subject, String message, Date receiveDate) {

        this.email = email;
        this.subject = subject;
        this.message = message;
        this.receiveDate = receiveDate;

        parseSenderName();
        parseEmail();
        parseReceiveDate();
        this.shortMessage = parseShortMessage();

    }

    private void parseSenderName() {
        try {
            this.senderName = this.email.substring(0, this.email.indexOf('<'));
        } catch (Exception e) {
            this.senderName = "Desconocido";
            System.out.println(e.getMessage() + " Setting sender name error");
        }
    }

    private void parseReceiveDate() {

        try {
            DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            Date d = this.receiveDate;
            DateFormat date = new SimpleDateFormat("MM/dd/yy");
            DateFormat time = new SimpleDateFormat("hh:mm a");

            this.dateParse = date.format(d);
            this.timeParse = time.format(d);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       

    }

    private void parseEmail() {
        try {
            Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(this.email);
            while (m.find()) {
                this.email = m.group();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private String parseShortMessage() {
        try {
            Reader inputString = new StringReader(this.message);
            BufferedReader reader = new BufferedReader(inputString);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String textOnly = Jsoup.parse(sb.toString()).text();
            return textOnly;
        } catch (Exception e) {
            return "Error Parsing Html Content";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getDateParse() {
        return dateParse;
    }

    public void setDateParse(String dateParse) {
        this.dateParse = dateParse;
    }

    public String getTimeParse() {
        return timeParse;
    }

    public void setTimeParse(String timeParse) {
        this.timeParse = timeParse;
    }

}
