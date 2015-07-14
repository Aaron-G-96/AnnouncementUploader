package my.AnnouncementUploader;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;


public class UploaderUI extends javax.swing.JFrame {
    
    //Writer is the object that allows stuff to be written to a text file
    private Writer writer = null;
    //The list of announcements going to be added
    private List< String > announceList = new ArrayList<>();
    //The announcement number that we're on
    private int num = 0;
    
    //Needs this to save an .xml to the Desktop of any computer. 
    private String userHomeFolder = System.getProperty("user.home");
    private File file = new File(userHomeFolder + "/Desktop", "Announcements.xml");

    public UploaderUI() {
        initComponents();
        
    }


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
        chk_append = new javax.swing.JCheckBox();
        btn_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Announcement Uploader");
        setPreferredSize(new java.awt.Dimension(1024, 1024));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onExit(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_generate.setFont(btn_generate.getFont().deriveFont(btn_generate.getFont().getSize()+5f));
        btn_generate.setText("Generate File");
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 680, 150, 40));

        btn_add.setFont(btn_add.getFont().deriveFont(btn_add.getFont().getSize()+5f));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 140, 80));

        txt_announcement.setColumns(20);
        txt_announcement.setLineWrap(true);
        txt_announcement.setRows(5);
        txt_announcement.setToolTipText("Only one announcement should be added at a time. ");
        txt_announcement.setWrapStyleWord(true);
        txt_announcement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_announcementMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_announcement);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 590, 380));

        lbl_announceNum.setFont(lbl_announceNum.getFont().deriveFont(lbl_announceNum.getFont().getSize()+5f));
        lbl_announceNum.setText("Enter Announcement 1:");
        getContentPane().add(lbl_announceNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        cmb_month.setFont(cmb_month.getFont());
        cmb_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmb_month.setToolTipText("");
        Calendar cal = Calendar.getInstance();
        cmb_month.setSelectedIndex(cal.get(Calendar.MONTH));
        getContentPane().add(cmb_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 140, -1));

        cmb_year.setFont(cmb_year.getFont());
        cmb_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));
        int year = cal.get(Calendar.YEAR);
        switch (year){
            case 2015:
            cmb_year.setSelectedIndex(0);
            break;
            case 2016:
            cmb_year.setSelectedIndex(1);
            break;
            case 2017:
            cmb_year.setSelectedIndex(2);
            break;
            case 2018:
            cmb_year.setSelectedIndex(3);
            break;
            case 2019:
            cmb_year.setSelectedIndex(4);
            break;
            case 2020:
            cmb_year.setSelectedIndex(5);
            break;
            default:
            cmb_year.setSelectedIndex(0);
            break;
        }
        getContentPane().add(cmb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 110, -1));

        cmb_day.setFont(cmb_day.getFont());
        cmb_day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmb_day.setSelectedIndex(cal.get(Calendar.DATE) -1);
        cmb_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_dayActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 110, -1));

        chk_append.setSelected(true);
        chk_append.setText("Append to existing");
        getContentPane().add(chk_append, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 750, -1, -1));

        btn_edit.setFont(btn_edit.getFont().deriveFont(btn_edit.getFont().getSize()+5f));
        btn_edit.setText("Edit");
        btn_edit.setEnabled(false);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 680, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
 
        /*Writes either a new file or appends to an existing one depending on
        *which option is checked. 
        */
        try {   
            if(chk_append.isSelected()){
                writeAppend();
            }else{
                writeNew();    
            }  
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(rootPane, "Woah. Something weird just "
                    + "happened. Please tell those ComSci people, so they can "
                    + "fix me.", "FileNotFound",
                JOptionPane.ERROR_MESSAGE);
           
        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, "Woah. Something weird just "
                    + "happened. Please tell those ComSci people, so they can "
                    + "fix me.", "IOException1",
                JOptionPane.ERROR_MESSAGE);
            
        } finally {
            try {
                if (writer != null) 
                    writer.close(); 
            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "Woah. Something weird just "
                    + "happened. Please tell those ComSci people, so they can "
                    + "fix me.", "IOException2",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //A basic message box letting the user know something good happened.
        JOptionPane.showMessageDialog(rootPane, "Uploaded to: " + 
                System.getProperty("user.home") + "\\Desktop", "Success!", 
                JOptionPane.INFORMATION_MESSAGE);
        
        //Optional code below to open the default browser to a specific page
        
        /*
        try {
            Runtime.getRuntime().exec("explorer.exe /select," + file);
            //openWebpage("http://forums.netbeans.org/topic27075.html");        
        } catch (IOException ex) {
            Logger.getLogger(UploaderUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        System.exit(0);
    }//GEN-LAST:event_btn_generateActionPerformed

    private void txt_announcementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_announcementMouseClicked
        //PLEASE DELTE ME!!!
    }//GEN-LAST:event_txt_announcementMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        //When the 'Next' button is clicked, it adds what is in the textbox
        //to the current announceList. It also keeps track of the announcement
        //number. 
        
        announceList.add(txt_announcement.getText());
        txt_announcement.setText("");
        num +=1;
        lbl_announceNum.setText("Enter Announcement: " + num);
        btn_edit.setEnabled(true);
        
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void cmb_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_dayActionPerformed
        //PLEASE DELETE ME. I really hate myself... I shouldn't exist. I was a mistake. 
    }//GEN-LAST:event_cmb_dayActionPerformed

    private void onExit(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onExit
        //If the user tries to close the program before generating a file, 
        //this program will be like, 'you sure, bro?'
        int confirm = JOptionPane.showOptionDialog(
             null, "Close Application without generating a file?", 
             "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
             JOptionPane.WARNING_MESSAGE, null, null, null);
        if (confirm == 0) {
           System.exit(0);
        }
    }//GEN-LAST:event_onExit

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        
        
    }//GEN-LAST:event_btn_editActionPerformed


    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
    
    public void writeAppend() throws IOException{
        if (file.isFile() == true){
            //file is the path where we're writing
            String fileString = FileUtils.readFileToString(file);
            System.out.println(fileString);
            //the boolean in the below line indicates if we should append or not
            writer = new BufferedWriter(new java.io.FileWriter(file, false));
            writer.write("\n<group>");
            writer.write("\n<date>" + getDate() + "</date>");
            for (String announceList1 : announceList) {
                writer.write("\n<announcement>" + announceList1 + "</announcement>");
            }
            writer.write("\n</group>");
            writer.write(fileString);
        }else{
            writeNew();
        }
        
    }
    
    public void writeNew() throws IOException{
        writer = new BufferedWriter(new java.io.FileWriter(file, false));
        writer.write("\n<group>");
        writer.write("\n<date>" + getDate() + "</date>");
        for (String announceList1 : announceList) {
            writer.write("\n<announcement>" + announceList1 + "</announcement>");
        }
        writer.write("\n</group>");
    }
    
    

public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_generate;
    private javax.swing.JCheckBox chk_append;
    private javax.swing.JComboBox cmb_day;
    private javax.swing.JComboBox cmb_month;
    private javax.swing.JComboBox cmb_year;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_announceNum;
    private javax.swing.JTextArea txt_announcement;
    // End of variables declaration//GEN-END:variables
}
