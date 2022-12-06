package controllers;

import components.BackgroundImageComponent;
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
import javax.swing.SwingUtilities;
import models.Mail;
import org.json.JSONObject;
import utils.JsonReader;
import utils.MessageFolder;
import views.MainView;
import views.UserSettingsView;

public class MainViewController implements MouseListener{

    private static MainView vistaPrincipal;
    private JSONObject temp;
    private BackgroundImageComponent backgroundimage = new BackgroundImageComponent();
    private static Boolean searchCondition = false;
    private static final String INBOX_FOLDER = "INBOX";
    public MainViewController(MainView vistaPrincipal) {
        MainViewController.vistaPrincipal = vistaPrincipal;
        temp = new JSONObject();

        MainViewController.vistaPrincipal.getBtnCreateMail().addMouseListener(this);
        MainViewController.vistaPrincipal.getReloadMailLabel().addMouseListener(this);
        MainViewController.vistaPrincipal.getBtnSettings().addMouseListener(this);
        MainViewController.vistaPrincipal.getBtnFolders().addMouseListener(this);
        MainViewController.vistaPrincipal.getSearchBtn().addMouseListener(this);


        MainViewController.vistaPrincipal.setVisible(true);
        MainViewController.vistaPrincipal.setLocationRelativeTo(null);
        switchPanels(backgroundimage);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainViewController.vistaPrincipal.getPanelMailsBox().removeAll();
                    MainViewController.vistaPrincipal.getPanelMailsBox().add(loadMails(INBOX_FOLDER));
                    MainViewController.vistaPrincipal.getPanelMailsBox().repaint();
                    MainViewController.vistaPrincipal.getPanelMailsBox().revalidate();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        });

    }

    public static MainView getMainView() {
        return vistaPrincipal;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                MainViewController.vistaPrincipal.getPanelMailsBox().removeAll();
                MainViewController.vistaPrincipal.getPanelMailsBox().add(loadMails(INBOX_FOLDER));
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
                vistaPrincipal.getFolderNameTitle().setText("carpetas");
            } catch (Exception io) {
                System.out.println(e.toString());
            }

        }
        if (MainViewController.vistaPrincipal.getSearchBtn().equals(e.getSource())) {
            MainViewController.searchCondition = true;
            try {
                MainViewController.vistaPrincipal.getPanelMailsBox().removeAll();
                MainViewController.vistaPrincipal.getPanelMailsBox().add(loadMails(INBOX_FOLDER));
                MainViewController.vistaPrincipal.getPanelMailsBox().repaint();
                MainViewController.vistaPrincipal.getPanelMailsBox().revalidate();
            } catch (Exception i) {
                System.out.println(i.toString());
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

    public static void switchPanels(JPanel panel) {
        MainViewController.vistaPrincipal.getMailContent().removeAll();
        MainViewController.vistaPrincipal.getMailContent().add(panel);
        MainViewController.vistaPrincipal.getMailContent().repaint();
        MainViewController.vistaPrincipal.getMailContent().revalidate();
        
        System.out.println("paneles cambiados correctamente");
    }

  
    public static JScrollPane loadMails(String folderName) throws MessagingException, IOException {
        ArrayList<Mail> mails = new ArrayList<>();
        System.out.println("Cargando MAILS");
        MessageFolder messageFolder = new MessageFolder();
        if(MainViewController.searchCondition){
            System.out.println("buscador activado");
            
            mails = messageFolder.searchMails(MainViewController.vistaPrincipal.getTxtfSearch().getText());
        } else {
            mails = messageFolder.getEmails(folderName);
        }
        
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

        
        gridLayoutNotes.setRows(mails.size());
        gridNotePanel.setLayout(gridLayoutNotes);

        //Por cada item en el arraylist, agregamos un row al gridNotePanel
        for (Mail mail : mails) {
            System.out.println(mail.getEmail() + " " + mail.getSubject());
            MailItem mailItem = new MailItem();
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

        inbox.getTxtFolderName().setText(INBOX_FOLDER);
        loadMails(inbox.getTxtFolderName().getText());
        inbox.getTxtFolderMessagesCounter().setText(Integer.toString(MessageFolder.getMails().size()));
        
        
        if(LoginViewController.getProviderHost() == "smtp.gmail.com"){
            spam.getTxtFolderName().setText("[Gmail]/Spam");
        }else{
            spam.getTxtFolderName().setText("JUNK");
        }
        loadMails(spam.getTxtFolderName().getText());
        spam.getTxtFolderMessagesCounter().setText(Integer.toString(MessageFolder.getMails().size()));
        

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
