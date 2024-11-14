/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cryptography_project;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joshuatupas
 */
public class FileIntegrityJT extends javax.swing.JFrame {

    private File selectedFile;

    /**
     * Creates new form FileIntegrity
     */
    public FileIntegrityJT() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        fileButton = new javax.swing.JButton();
        fileNameTF = new javax.swing.JLabel();
        hashButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        hashTF = new javax.swing.JTextField();
        verifyButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hashrecordsTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        enterFileName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 77, 96));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fileButton.setBackground(new java.awt.Color(107, 163, 190));
        fileButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        fileButton.setText("Choose File");
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });
        jPanel1.add(fileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 170, 60));

        fileNameTF.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        fileNameTF.setText("No File Chosen");
        jPanel1.add(fileNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        hashButton.setBackground(new java.awt.Color(107, 163, 190));
        hashButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        hashButton.setText("Calculate Hash");
        hashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashButtonActionPerformed(evt);
            }
        });
        jPanel1.add(hashButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 230, 60));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("Hash Value:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        hashTF.setToolTipText("Copy the hash here");
        jPanel1.add(hashTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 660, 40));

        verifyButton.setBackground(new java.awt.Color(107, 163, 190));
        verifyButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        verifyButton.setText("Check File");
        verifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonActionPerformed(evt);
            }
        });
        jPanel1.add(verifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, 60));

        jLabel2.setBackground(new java.awt.Color(255, 0, 51));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("File Verification");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 150, 40));

        jTabbedPane1.addTab("Hash", jPanel1);

        jPanel3.setBackground(new java.awt.Color(39, 77, 96));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hashrecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "File", "Hash"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hashrecordsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(hashrecordsTable);
        if (hashrecordsTable.getColumnModel().getColumnCount() > 0) {
            hashrecordsTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 812, 278));

        searchButton.setBackground(new java.awt.Color(107, 163, 190));
        searchButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon("/Users/joshuatupas/NetBeansProjects/Cryptography_Project/src/main/java/com/mycompany/cryptography_project/images/Search.png")); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel3.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 140, 60));
        jPanel3.add(enterFileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 160, 40));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setText("Search File Name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jTabbedPane1.addTab("Records", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyButtonActionPerformed
        try {
            String verifyHash = hashTF.getText();
            //if the input is empty otherwise verify when the file and hash matches
            if (verifyHash.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Please provide a hash first");
            } else {
                if (selectedFile != null && selectedFile.exists()) {
                    byte[] encodedHash = messageDigest();
                    String currentHash = bytesToHex(encodedHash);
                    String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

                    //to avoid duplicate hash record
                    DefaultTableModel model = (DefaultTableModel) hashrecordsTable.getModel();
                    boolean isDuplicate = false;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 2) != null && model.getValueAt(i, 2).equals(currentHash)) {
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate) {
                        JOptionPane.showMessageDialog(rootPane, "This hash has already been verified!");
                    } else {//add hash record when verification successful
                        if (verifyHash.equals(currentHash)) {
                            DefaultTableModel tableModel = (DefaultTableModel) hashrecordsTable.getModel();
                            tableModel.addRow(new Object[]{
                                timestamp,
                                selectedFile.getName(),
                                currentHash
                            });
                            JOptionPane.showMessageDialog(rootPane, "The File verification successful");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "The File verification failed");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please select a file");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_verifyButtonActionPerformed

    private void hashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashButtonActionPerformed
        try {
            // MessageDigest class for SHA-256
            byte[] encodedHash = messageDigest();
            String hashValue = bytesToHex(encodedHash);
            hashTF.setText(hashValue);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please select file");
        }
    }//GEN-LAST:event_hashButtonActionPerformed

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a File");

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            fileNameTF.setText(fileName);
        }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String searchFile = enterFileName.getText().trim();
        if (searchFile.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a file name to search");
        } else {

            for (int i = 0; i < hashrecordsTable.getRowCount(); i++) {
                String fileName = hashrecordsTable.getValueAt(i, 1).toString(); // Column 1 is File name
                if (fileName.equalsIgnoreCase(searchFile)) {
                    hashrecordsTable.setRowSelectionInterval(i, i); // Highlight the matching row
                    break;
                }
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    //byte to hex converter to get the hashed value
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    //MessageDigest class for SHA-256 hashing
    private byte[] messageDigest() throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
        return digest.digest(fileBytes);
    }

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
            java.util.logging.Logger.getLogger(FileIntegrityJT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileIntegrityJT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileIntegrityJT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileIntegrityJT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileIntegrityJT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField enterFileName;
    private javax.swing.JButton fileButton;
    private javax.swing.JLabel fileNameTF;
    private javax.swing.JButton hashButton;
    private javax.swing.JTextField hashTF;
    private javax.swing.JTable hashrecordsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton verifyButton;
    // End of variables declaration//GEN-END:variables
}
