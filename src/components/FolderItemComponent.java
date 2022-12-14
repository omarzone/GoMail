/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import javax.swing.JLabel;

/**
 *
 * @author Pablo
 */
public class FolderItemComponent extends javax.swing.JPanel {

    /**
     * Creates new form FolderItem
     */
    public FolderItemComponent() {
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

        componentFolderItem = new components.RoundedBorders();
        txtFolderMessagesCounter = new javax.swing.JLabel();
        txtFolderName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        componentFolderItem.setBackground(new java.awt.Color(50, 52, 103));

        txtFolderMessagesCounter.setForeground(new java.awt.Color(90, 91, 128));
        txtFolderMessagesCounter.setText("15");
        componentFolderItem.add(txtFolderMessagesCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 15, -1, -1));

        txtFolderName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtFolderName.setForeground(new java.awt.Color(255, 255, 255));
        txtFolderName.setText("INBOX");
        componentFolderItem.add(txtFolderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        add(componentFolderItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 50));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedBorders componentFolderItem;
    private javax.swing.JLabel txtFolderMessagesCounter;
    private javax.swing.JLabel txtFolderName;
    // End of variables declaration//GEN-END:variables

    public RoundedBorders getComponentFolderItem() {
        return componentFolderItem;
    }

    public void setComponentFolderItem(RoundedBorders componentFolderItem) {
        this.componentFolderItem = componentFolderItem;
    }

    public JLabel getTxtFolderMessagesCounter() {
        return txtFolderMessagesCounter;
    }

    public void setTxtFolderMessagesCounter(JLabel txtFolderMessagesCounter) {
        this.txtFolderMessagesCounter = txtFolderMessagesCounter;
    }

    public JLabel getTxtFolderName() {
        return txtFolderName;
    }

    public void setTxtFolderName(JLabel txtFolderName) {
        this.txtFolderName = txtFolderName;
    }
}
