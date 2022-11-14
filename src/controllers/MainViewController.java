package controllers;

import components.CustomScrollBar;
import components.MailContentComponent;
import components.MailItem;
import components.NewMailComponent;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.Mail;
import org.json.JSONObject;
import utils.JsonReader;
import utils.MailSender;
import utils.MessageFolder;
import views.MainView;

public class MainViewController implements MouseListener, ActionListener {

    private MainView vistaPrincipal;
    private NewMailComponent newMail;
    private JSONObject temp;

    public MainViewController(MainView vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        newMail = new NewMailComponent();
        newMail.getBtnSend().addActionListener(this);
        temp = new JSONObject();

        this.vistaPrincipal.getBtnCreateMail().addMouseListener(this);

        this.vistaPrincipal.setVisible(true);
        this.vistaPrincipal.setLocationRelativeTo(null);

        try {
            loadMails();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.vistaPrincipal.getBtnCreateMail().equals(e.getSource())) {
            temp = JsonReader.getJson("src/utils/temp.txt");
            newMail.getLblUserName().setText(temp.getString("email"));
            switchPanels(newMail);

        }
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

    private void switchPanels(JPanel panel) {
        this.vistaPrincipal.getMailContent().removeAll();
        this.vistaPrincipal.getMailContent().add(panel);
        this.vistaPrincipal.getMailContent().repaint();
        this.vistaPrincipal.getMailContent().revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (newMail.getBtnSend().equals(e.getSource())) {
            System.out.println("Se ha apretado el boton de enviar");

            MailSender mailSender = new MailSender(newMail.getLblUserName().getText(), newMail.getTxtSenderName().getText(), newMail.getTxtSubject().getText(), newMail.getjTextArea1().getText(), temp.getString("password"));
            if (mailSender.envioDeCorreos()) {
                this.vistaPrincipal.getMailContent().removeAll();
                this.vistaPrincipal.getMailContent().repaint();
                this.vistaPrincipal.getMailContent().revalidate();
            }
        }
    }

    public void loadMails() throws MessagingException, IOException {

        MessageFolder messageFolder = new MessageFolder();
        ArrayList<Mail> mails = messageFolder.getEmails();
        //Creamos el scroll y seteamos propiedades
        JScrollPane scrollListNotes = new JScrollPane();
        scrollListNotes.setOpaque(false);
        scrollListNotes.getViewport().setOpaque(false);
        scrollListNotes.setViewportBorder(null);
        scrollListNotes.setBorder(null);
        scrollListNotes.setVerticalScrollBar(new CustomScrollBar());
        scrollListNotes.getVerticalScrollBar().setUnitIncrement(16);

        //Creamos el Panel y el gridLayout  que estara dentro del scroll
        JPanel gridNotePanel = new JPanel();
        gridNotePanel.setOpaque(false);
        GridLayout gridLayoutNotes = new GridLayout();
        gridLayoutNotes.setColumns(1);
        gridLayoutNotes.setVgap(15);

        //Validacion para evitar que las notas se hagan muy grandes cuando son pocas
//        if (mails.size() < 5) {
//            gridLayoutNotes.setRows(mails.size() + 3);
//            scrollListNotes.setHorizontalScrollBarPolicy(scrollListNotes.HORIZONTAL_SCROLLBAR_NEVER);
//            scrollListNotes.setVerticalScrollBarPolicy(scrollListNotes.VERTICAL_SCROLLBAR_NEVER);
//        } else {
//            gridLayoutNotes.setRows(mails.size());
//        }
//        scrollListNotes.setHorizontalScrollBarPolicy(scrollListNotes.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollListNotes.setVerticalScrollBarPolicy(scrollListNotes.VERTICAL_SCROLLBAR_NEVER);
        gridLayoutNotes.setRows(7);
        gridNotePanel.setLayout(gridLayoutNotes);

        //Por cada item en el arraylist, agregamos un row al gridNotePanel
        for (Mail mail : mails) {
            System.out.println(mail.getEmail() + " " + mail.getSubject());
            MailItem mailItem = new MailItem();
//            completeNoteItemView.setBackground(cntrlMain.getThemeApp().getNOTE_BG());
            MailItemController mailitemController = new MailItemController(mailItem, mail);
            gridNotePanel.add(mailItem);

        }

        //seteamos la vista que estara dentro del scroll
        scrollListNotes.setViewportView(gridNotePanel);

        //Agregamos el scroll al ContentPanel
        if (mails.size() < 1) {
            System.out.println("No hay emails");

        } else {
            vistaPrincipal.getPanelMailsBox().add(scrollListNotes);
        }
    }

}
