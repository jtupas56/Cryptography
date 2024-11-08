/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cryptography_project;

import com.mycompany.cryptography_project.Records.RecordsSecurity;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author domas
 */
public class records extends javax.swing.JFrame
{
    String columns[];
    ArrayList<ArrayList<String[]>> recordsData;
    /**
     * Creates new form records
     */
    public records()
    {
        try 
        {
            recordsData = RecordsSecurity.retrieveData();
            setTableColumns();
            initComponents();
            setTableRows();
            disableTableEditing();


        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void disableTableEditing()
    {

        for (int i = 0; i < recordsTable.getColumnCount(); i++) 
        {
            TableColumn column = recordsTable.getColumnModel().getColumn(i);
            //prevents resizing of columns
            column.setResizable(false);
        }
        //prevents repositining of columns
        recordsTable.getTableHeader().setReorderingAllowed(false);
        //prevents user from editing values of the cells
        recordsTable.setDefaultEditor(Object.class, null); 
        
    }
    

    
    private void setTableColumns() throws IOException
    {
        ArrayList<String[]> innerData = recordsData.get(0);
        columns = new String[innerData.size()];
        
        for (int i = 0; i < innerData.size(); i++)
        {
            columns[i] = innerData.get(i)[0];
        }
    }
    
    private void setTableRows()
    {
        DefaultTableModel model = (DefaultTableModel) recordsTable.getModel();
        
        for (ArrayList<String[]> patientInfo : recordsData)
        {
            Object[] newRow = new Object[patientInfo.size()];
            
            for (int i = 0; i < patientInfo.size(); i++)
            {
                newRow[i] = patientInfo.get(i)[1];
            }
            model.addRow(newRow);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        recordsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        recordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            columns
        ));
        jScrollPane1.setViewportView(recordsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recordsTable;
    // End of variables declaration//GEN-END:variables
}
