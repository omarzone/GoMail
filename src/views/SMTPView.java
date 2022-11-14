/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import components.RoundedBorders;

/**
 *
 * @author Pablo
 */
public class SMTPView extends javax.swing.JFrame {

    /**
     * Creates new form SMTP_View
     */
    public SMTPView() {
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

        smtpViewContainer = new javax.swing.JPanel();
        tittleSmtp = new javax.swing.JLabel();
        gmailButton = new components.RoundedBorders();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        outlookButton = new components.RoundedBorders();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        personalizedButton = new components.RoundedBorders();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(60, 62, 117));
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        smtpViewContainer.setBackground(new java.awt.Color(60, 62, 117));
        smtpViewContainer.setMaximumSize(new java.awt.Dimension(1000, 700));
        smtpViewContainer.setMinimumSize(new java.awt.Dimension(1000, 700));
        smtpViewContainer.setPreferredSize(new java.awt.Dimension(1000, 700));
        smtpViewContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tittleSmtp.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        tittleSmtp.setForeground(new java.awt.Color(255, 255, 255));
        tittleSmtp.setText("Selecciona el proveedor SMTP");
        smtpViewContainer.add(tittleSmtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 59, 700, -1));

        gmailButton.setBackground(new java.awt.Color(50, 52, 103));
        gmailButton.setForeground(new java.awt.Color(50, 52, 103));
        gmailButton.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Gmail_icon.png"))); // NOI18N
        gmailButton.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 104));
        jLabel2.getAccessibleContext().setAccessibleName("Gmail_icon");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gmail");
        gmailButton.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        smtpViewContainer.add(gmailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 242, 250, 250));

        outlookButton.setBackground(new java.awt.Color(50, 52, 103));
        outlookButton.setForeground(new java.awt.Color(50, 52, 103));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Office_Icon.png"))); // NOI18N
        outlookButton.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Outlook");
        outlookButton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        smtpViewContainer.add(outlookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 242, 250, 250));

        personalizedButton.setBackground(new java.awt.Color(50, 52, 103));
        personalizedButton.setForeground(new java.awt.Color(50, 52, 103));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Personalized_icon.png"))); // NOI18N
        personalizedButton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Personalizado");
        personalizedButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        smtpViewContainer.add(personalizedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 242, 250, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smtpViewContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(smtpViewContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SMTPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SMTPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SMTPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SMTPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SMTPView().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedBorders gmailButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private components.RoundedBorders outlookButton;
    private components.RoundedBorders personalizedButton;
    private javax.swing.JPanel smtpViewContainer;
    private javax.swing.JLabel tittleSmtp;
    // End of variables declaration//GEN-END:variables

    public RoundedBorders getGmailButton() {
        return gmailButton;
    }

    public void setGmailButton(RoundedBorders Gmail_button) {
        this.gmailButton = Gmail_button;
    }

    public RoundedBorders getOutlookButton() {
        return outlookButton;
    }

    public void setOutlookButton(RoundedBorders Outlook_button) {
        this.outlookButton = Outlook_button;
    }

    public RoundedBorders getPersonalizedButton() {
        return personalizedButton;
    }

    public void setPersonalizedButton(RoundedBorders Personalized_button) {
        this.personalizedButton = Personalized_button;
    }
}
