/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.AnnouncementUploader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UploaderUI extends javax.swing.JFrame {

    private List< String > announceList = new ArrayList<>();
    private int num = 1;
    
    /**
     * Creates new form UploaderUI
     */
    public UploaderUI() {
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

        btn_generate = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_announcement = new javax.swing.JTextArea();
        lbl_announceNum = new javax.swing.JLabel();
        cmb_month = new javax.swing.JComboBox();
        cmb_year = new javax.swing.JComboBox();
        cmb_day = new javax.swing.JComboBox();
        opt_append = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_generate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_generate.setText("Generate File");
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, 150, 40));

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_add.setText("Add Announcement");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 210, 80));

        txt_announcement.setColumns(20);
        txt_announcement.setLineWrap(true);
        txt_announcement.setRows(5);
        txt_announcement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_announcementMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_announcement);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 590, 380));

        lbl_announceNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_announceNum.setText("Enter Announcement 1:");
        getContentPane().add(lbl_announceNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        cmb_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmb_month.setToolTipText("");
        getContentPane().add(cmb_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 140, -1));

        cmb_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));
        getContentPane().add(cmb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 110, -1));

        cmb_day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmb_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_dayActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 110, -1));

        opt_append.setSelected(true);
        opt_append.setText("Add to Existing");
        getContentPane().add(opt_append, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 750, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        Writer writer = null;
 
        try {
            String text = "This is a text file";
            String userHomeFolder = System.getProperty("user.home");
            File file = new File(userHomeFolder + "/Desktop", "Announcements.xml");
            
            if(opt_append.isSelected()){
                writer = new BufferedWriter(new java.io.FileWriter(file, true));
            }else{
                writer = new BufferedWriter(new java.io.FileWriter(file, false));
            }
            
            writer.write("\n<date>" + getDate() + "</date>");
            for (int i = 0; i < announceList.size(); i++){
                writer.write("\n<announcement>" + announceList.get(i) + "</announcement>");
              
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Uploaded to: " + System.getProperty("user.home") + "\\Desktop", "Success!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_btn_generateActionPerformed

    private void txt_announcementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_announcementMouseClicked
        //
    }//GEN-LAST:event_txt_announcementMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        announceList.add(txt_announcement.getText());
        txt_announcement.setText("");
        num +=1;
        lbl_announceNum.setText("Enter Announcement: " + num);
    }//GEN-LAST:event_btn_addActionPerformed

    private void cmb_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_dayActionPerformed

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
            java.util.logging.Logger.getLogger(UploaderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UploaderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UploaderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UploaderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UploaderUI().setVisible(true);
            }
        });
    }
    
    public String getDate(){
        String month = String.valueOf(cmb_month.getSelectedItem());
        String day = String.valueOf(cmb_day.getSelectedItem());
        String year = String.valueOf(cmb_year.getSelectedItem());
        
        return month + " " + day + ", " + year;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_generate;
    private javax.swing.JComboBox cmb_day;
    private javax.swing.JComboBox cmb_month;
    private javax.swing.JComboBox cmb_year;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_announceNum;
    private javax.swing.JRadioButton opt_append;
    private javax.swing.JTextArea txt_announcement;
    // End of variables declaration//GEN-END:variables
}
