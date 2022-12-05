package views;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.*;

public class MainView extends javax.swing.JFrame {

    public MainView() {
      

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        mailContainer = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        txtfSearch = new javax.swing.JTextField();
        refreshPanel = new javax.swing.JPanel();
        reloadMailLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelMailsBox = new javax.swing.JPanel();
        mailContent = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        btnSettings = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCreateMail = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnFolders = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnUserProfile = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        container.setBackground(new java.awt.Color(248, 248, 255));
        container.setMinimumSize(new java.awt.Dimension(1000, 700));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mailContainer.setBackground(new java.awt.Color(60, 62, 117));
        mailContainer.setMinimumSize(new java.awt.Dimension(402, 700));
        mailContainer.setPreferredSize(new java.awt.Dimension(402, 700));
        mailContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBackground(new java.awt.Color(57, 59, 114));
        searchPanel.setOpaque(false);
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfSearch.setBackground(new java.awt.Color(57, 59, 114));
        txtfSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtfSearch.setToolTipText("Buscar");
        txtfSearch.setBorder(null);
        txtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfSearchActionPerformed(evt);
            }
        });
        searchPanel.add(txtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        refreshPanel.setOpaque(false);
        refreshPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reloadMailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloadMailLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-actualizar.png"))); // NOI18N
        reloadMailLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshPanel.add(reloadMailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        searchPanel.add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 30, 30));

        mailContainer.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("INBOX");
        mailContainer.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        panelMailsBox.setOpaque(false);
        panelMailsBox.setLayout(new java.awt.CardLayout());
        mailContainer.add(panelMailsBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 380, 580));

        container.add(mailContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 402, 700));

        mailContent.setBackground(new java.awt.Color(248, 248, 255));
        container.add(mailContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 560, 700));

        optionPanel.setBackground(new java.awt.Color(56, 58, 110));
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSettings.setBackground(new java.awt.Color(56, 58, 110));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-ajustes.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(42, 42));
        jLabel1.setMinimumSize(new java.awt.Dimension(42, 42));
        jLabel1.setPreferredSize(new java.awt.Dimension(42, 42));

        javax.swing.GroupLayout btnSettingsLayout = new javax.swing.GroupLayout(btnSettings);
        btnSettings.setLayout(btnSettingsLayout);
        btnSettingsLayout.setHorizontalGroup(
            btnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnSettingsLayout.setVerticalGroup(
            btnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        optionPanel.add(btnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, -1, -1));

        btnCreateMail.setBackground(new java.awt.Color(56, 58, 110));
        btnCreateMail.setMinimumSize(new java.awt.Dimension(42, 42));
        btnCreateMail.setPreferredSize(new java.awt.Dimension(42, 42));
        btnCreateMail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-más.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setMaximumSize(new java.awt.Dimension(42, 42));
        jLabel3.setMinimumSize(new java.awt.Dimension(42, 42));
        jLabel3.setPreferredSize(new java.awt.Dimension(42, 42));
        btnCreateMail.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 30, 40));

        optionPanel.add(btnCreateMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 40));

        btnFolders.setBackground(new java.awt.Color(56, 58, 110));
        btnFolders.setMaximumSize(new java.awt.Dimension(42, 42));
        btnFolders.setMinimumSize(new java.awt.Dimension(42, 42));
        btnFolders.setPreferredSize(new java.awt.Dimension(42, 42));
        btnFolders.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/folder-svgrepo-com.png"))); // NOI18N
        jLabel4.setMaximumSize(new java.awt.Dimension(42, 42));
        jLabel4.setMinimumSize(new java.awt.Dimension(42, 42));
        jLabel4.setPreferredSize(new java.awt.Dimension(42, 42));
        btnFolders.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        optionPanel.add(btnFolders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 40));

        btnUserProfile.setBackground(new java.awt.Color(56, 58, 110));
        btnUserProfile.setPreferredSize(new java.awt.Dimension(42, 42));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/profile-svgrepo-com.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(42, 42));
        jLabel2.setMinimumSize(new java.awt.Dimension(42, 42));
        jLabel2.setPreferredSize(new java.awt.Dimension(42, 42));

        javax.swing.GroupLayout btnUserProfileLayout = new javax.swing.GroupLayout(btnUserProfile);
        btnUserProfile.setLayout(btnUserProfileLayout);
        btnUserProfileLayout.setHorizontalGroup(
            btnUserProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUserProfileLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnUserProfileLayout.setVerticalGroup(
            btnUserProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUserProfileLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        optionPanel.add(btnUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        container.add(optionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            System.out.println("SOUTAP");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    public JLabel getReloadMailLabel() {
        return reloadMailLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCreateMail;
    private javax.swing.JPanel btnFolders;
    private javax.swing.JPanel btnSettings;
    private javax.swing.JPanel btnUserProfile;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel mailContainer;
    private javax.swing.JPanel mailContent;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JPanel panelMailsBox;
    private javax.swing.JPanel refreshPanel;
    private javax.swing.JLabel reloadMailLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField txtfSearch;
    // End of variables declaration//GEN-END:variables

    public JPanel getBtnCreateMail() {
        return btnCreateMail;
    }

    public void setBtnCreateMail(JPanel btnCreateMail) {
        this.btnCreateMail = btnCreateMail;
    }

    public JPanel getBtnFolders() {
        return btnFolders;
    }

    public void setBtnFolders(JPanel btnFolders) {
        this.btnFolders = btnFolders;
    }

    public JPanel getBtnSettings() {
        return btnSettings;
    }

    public void setBtnSettings(JPanel btnSettings) {
        this.btnSettings = btnSettings;
    }

    public JPanel getBtnUserProfile() {
        return btnUserProfile;
    }

    public void setBtnUserProfile(JPanel btnUserProfile) {
        this.btnUserProfile = btnUserProfile;
    }

    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return reloadMailLabel;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.reloadMailLabel = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JPanel getPanelMailsBox() {
        return panelMailsBox;
    }

    public void setPanelMailsBox(JPanel panelMailsBox) {
        this.panelMailsBox = panelMailsBox;
    }


    public JPanel getMailContainer() {
        return mailContainer;
    }

    public void setMailContainer(JPanel mailContainer) {
        this.mailContainer = mailContainer;
    }

    public JPanel getMailContent() {
        return mailContent;
    }

    public void setMailContent(JPanel mailContent) {
        this.mailContent = mailContent;
    }

    public JPanel getOptionPanel() {
        return optionPanel;
    }

    public void setOptionPanel(JPanel optionPanel) {
        this.optionPanel = optionPanel;
    }

    public JPanel getRefreshPanel() {
        return refreshPanel;
    }

    public void setRefreshPanel(JPanel refreshPanel) {
        this.refreshPanel = refreshPanel;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public JTextField getTxtfSearch() {
        return txtfSearch;
    }

    public void setTxtfSearch(JTextField txtfSearch) {
        this.txtfSearch = txtfSearch;
    }



    
}
