package controllers;

import components.CustomScrollBar;
import components.MailItem;
import components.FolderItemComponent;
import components.NewMailComponent;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.Mail;
import org.json.JSONObject;
import utils.JsonReader;
import utils.MessageFolder;
import views.MainView;
import views.UserSettingsView;

public class MainViewController implements MouseListener{

    static private MainView vistaPrincipal;
    private JSONObject temp;

    public MainViewController(MainView vistaPrincipal) {
        MainViewController.vistaPrincipal = vistaPrincipal;
        temp = new JSONObject();

        MainViewController.vistaPrincipal.getBtnCreateMail().addMouseListener(this);


        MainViewController.vistaPrincipal.getReloadMailLabel().addMouseListener(this);

        MainViewController.vistaPrincipal.getBtnSettings().addMouseListener(this);
        

        MainViewController.vistaPrincipal.getBtnFolders().addMouseListener(this);


        MainViewController.vistaPrincipal.setVisible(true);
        MainViewController.vistaPrincipal.setLocationRelativeTo(null);

        try {
            loadMails("INBOX");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    static public MainView getMainView() {
        return vistaPrincipal;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (MainViewController.vistaPrincipal.getBtnCreateMail().equals(e.getSource())) {
            temp = JsonReader.getJson("src/utils/temp.txt");
            NewMailComponent newMail = new NewMailComponent();
            newMail.getLblUserName().setText(temp.getString("email"));
            NewMailComponentController newMainControllerComponent = new NewMailComponentController(newMail);
        }
        if(MainViewController.vistaPrincipal.getBtnSettings().equals(e.getSource())){
            UserSettingsView userSettingsView = new UserSettingsView();
            UserSettingsViewController userSettingsViewController = new UserSettingsViewController(userSettingsView);

        }
        if (MainViewController.vistaPrincipal.getReloadMailLabel().equals(e.getSource())) {
            try {

                //loadMails();
                //MainViewController.vistaPrincipal.getPanelMailsBox().updateUI();
                MainViewController.vistaPrincipal.getPanelMailsBox().removeAll();
                MainViewController.vistaPrincipal.getPanelMailsBox().add(loadMails("INBOX"));
                MainViewController.vistaPrincipal.getPanelMailsBox().repaint();
                MainViewController.vistaPrincipal.getPanelMailsBox().revalidate();
            } catch (Exception i) {
                System.out.println(i.toString());
            } 
        }

        if (MainViewController.vistaPrincipal.getBtnFolders().equals(e.getSource())) {
            System.out.println("presionaste el botón de carpetas");

            try {
                loadFolder();
            } catch (Exception io) {
                System.out.println(e.toString());
            }

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

    static public void switchPanels(JPanel panel) {
        MainViewController.vistaPrincipal.getMailContent().removeAll();
        MainViewController.vistaPrincipal.getMailContent().add(panel);
        MainViewController.vistaPrincipal.getMailContent().repaint();
        MainViewController.vistaPrincipal.getMailContent().revalidate();
    }

  
    public static JScrollPane loadMails(String folderName) throws MessagingException, IOException {

        System.out.println("Cargando MAILS");
        MessageFolder messageFolder = new MessageFolder();
        ArrayList<Mail> mails = messageFolder.getEmails(folderName);
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
        gridLayoutNotes.setRows(mails.size());
        gridNotePanel.setLayout(gridLayoutNotes);

        //Por cada item en el arraylist, agregamos un row al gridNotePanel
        for (Mail mail : mails) {
            System.out.println(mail.getEmail() + " " + mail.getSubject());
            MailItem mailItem = new MailItem();
//          completeNoteItemView.setBackground(cntrlMain.getThemeApp().getNOTE_BG());
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
        return scrollListNotes;

    }

    public void loadFolder() throws MessagingException, IOException {

        FolderItemComponent spam = new FolderItemComponent();
        FolderItemComponent inbox = new FolderItemComponent();
        System.out.println("Cargando folders");

        inbox.getTxtFolderName().setText("INBOX");
        inbox.getTxtFolderMessagesCounter().setText("69");
        spam.getTxtFolderName().setText("JUNK");
        spam.getTxtFolderMessagesCounter().setText("2");

        FolderItemController folderInboxController = new FolderItemController(inbox);
        FolderItemController folderSpamController = new FolderItemController(spam);

        MainViewController.vistaPrincipal.getPanelMailsBox().removeAll();

        JScrollPane scrollListNotes = new JScrollPane();
        scrollListNotes.setOpaque(false);
        scrollListNotes.getViewport().setOpaque(false);
        scrollListNotes.setViewportBorder(null);
        scrollListNotes.setBorder(null);
        scrollListNotes.setVerticalScrollBar(new CustomScrollBar());
        scrollListNotes.getVerticalScrollBar().setUnitIncrement(16);

        JPanel gridFolderPanel = new JPanel();
        gridFolderPanel.setOpaque(false);
        GridLayout gridLayoutNotes = new GridLayout();
        gridLayoutNotes.setColumns(1);
        gridLayoutNotes.setVgap(15);

        gridLayoutNotes.setRows(8);
        gridFolderPanel.setLayout(gridLayoutNotes);

        gridFolderPanel.add(inbox.getComponentFolderItem());
        gridFolderPanel.add(spam.getComponentFolderItem());

        scrollListNotes.setViewportView(gridFolderPanel);

        //Agregamos el scroll al ContentPanel
        vistaPrincipal.getPanelMailsBox().add(scrollListNotes);
        MainViewController.vistaPrincipal.getPanelMailsBox().repaint();
        MainViewController.vistaPrincipal.getPanelMailsBox().revalidate();
    }

}
