/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cryptography_project;

/**
 *
 * @author joshuatupas
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        userIDLabel = new javax.swing.JLabel();
        userIDTextField = new javax.swing.JTextField();
        userPasswordTextField = new javax.swing.JTextField();
        userPasswordLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(192, 222, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userIDLabel.setText("User ID:");
        jPanel1.add(userIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        userIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(userIDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 150, 40));
        jPanel1.add(userPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 150, 40));

        userPasswordLabel.setBackground(new java.awt.Color(0, 0, 0));
        userPasswordLabel.setText("Password:");
        jPanel1.add(userPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        loginBtn.setBackground(new java.awt.Color(107, 163, 190));
        loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add 2.png"))); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        exitBtn.setBackground(new java.awt.Color(107, 163, 190));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logout.png"))); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        //adams section
        String id = userIDTextField.getText(); //get id from txtfield
        String password = userPasswordTextField.getText(); //get password from txtfield

        UserDatabase userDatabase = new UserDatabase();

        //check if login is valid
        if (userDatabase.validateLogin(id, password)) {
            //valid login
            this.dispose();
            new Dashboard().setVisible(true);
        } else {
            //invalid login
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid ID or Password");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void userIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel userIDLabel;
    private javax.swing.JTextField userIDTextField;
    private javax.swing.JLabel userPasswordLabel;
    private javax.swing.JTextField userPasswordTextField;
    // End of variables declaration//GEN-END:variables
}
