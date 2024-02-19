/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EditableTimeTable extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private String loginUsername;
    private static final String DB_PASSWORD="pranav@030429";
    public EditableTimeTable(String u1) {
        initComponents();
        
        //User Login Name from login page 
        loginUsername=u1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit TImeTable");
        setPreferredSize(new java.awt.Dimension(720, 565));

        jTable1.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Start Time ", "End Time ", "Monday ", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        addBtn.setBackground(new java.awt.Color(79, 66, 255));
        addBtn.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(79, 66, 255));
        saveBtn.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(79, 66, 255));
        backBtn.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static void showMessageDialog(String message, String title, int messageType) {
            JOptionPane.showMessageDialog(null, message, title, messageType);
        }
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        Connection con=null;
        PreparedStatement preparedstatement=null;
        ResultSet rs=null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root",DB_PASSWORD);
            preparedstatement=con.prepareStatement("SELECT username FROM students WHERE username=?");
            preparedstatement.setString(1,loginUsername);
            rs=preparedstatement.executeQuery();
            if(rs.next()){
                addBtn.setEnabled(false);
                try {
                    Thread.sleep(4);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EditableTimeTable.class.getName()).log(Level.SEVERE, null, ex);
                }
                showMessageDialog("You are not allowed to edit","Error",JOptionPane.WARNING_MESSAGE);
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        if(addBtn.isEnabled()){
            String[] columnNames = {"Start Time", "End Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            DefaultTableModel model = new DefaultTableModel(null, columnNames);
            jTable1.setModel(model);

            File excelFile;
            FileInputStream excelFIS = null;
            BufferedInputStream excelBIS = null;
            Workbook excelImportToJTable = null; // Use Workbook instead of XSSFWorkbook
            String defaultCurrentDirectoryPath = "C:\\Windows\\system32";
            JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
            excelFileChooser.setDialogTitle("Select Excel File");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm", "csv");
            excelFileChooser.setFileFilter(fnef);
            int excelChooser = excelFileChooser.showOpenDialog(null);
            if (excelChooser == JFileChooser.APPROVE_OPTION) {
                try {
                    excelFile = excelFileChooser.getSelectedFile();
                    //jExcelFilePath.setText(excelFile.toString());
                    excelFIS = new FileInputStream(excelFile);
                    excelBIS = new BufferedInputStream(excelFIS);

                    // Determine the type of Excel file (XLS or XLSX)
                    if (excelFile.getName().endsWith("xlsx")) {
                        excelImportToJTable = new XSSFWorkbook(excelBIS);
                    } else if (excelFile.getName().endsWith("xls")) {
                        excelImportToJTable = new HSSFWorkbook(excelBIS);
                    } else {
                        // Handle unsupported file types
                        JOptionPane.showMessageDialog(null, "Unsupported file type. Please select a valid Excel file.");
                        return;
                    }

                    Sheet excelSheet = excelImportToJTable.getSheetAt(0);

                    for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                        Row excelRow = excelSheet.getRow(row);
                        Cell excelStartTime = excelRow.getCell(0);
                        Cell excelEndTime = excelRow.getCell(1);
                        Cell excelMonday = excelRow.getCell(2);
                        Cell excelTuesday = excelRow.getCell(3);
                        Cell excelWednesday = excelRow.getCell(4);
                        Cell excelThursday = excelRow.getCell(5);
                        Cell excelFriday = excelRow.getCell(6);
                        Cell excelSaturday = excelRow.getCell(7);
                        model.addRow(new Object[]{excelStartTime, excelEndTime, excelMonday, excelTuesday, excelWednesday, excelThursday, excelFriday, excelSaturday});
                    }
                    JOptionPane.showMessageDialog(null, "Excel File Imported Successfully !!.....");
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                } finally {
                    try {
                        if (excelFIS != null) {
                            excelFIS.close();
                        }
                        if (excelBIS != null) {
                            excelBIS.close();
                        }
                        if (excelImportToJTable != null) {
                            excelImportToJTable.close();
                        }
                    } catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, iOException.getMessage());
                    }
                 }
                }
            }
    }//GEN-LAST:event_addBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
            try {
                DefaultTableModel bulkModel = (DefaultTableModel) jTable1.getModel();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lecturedatabase", "root", DB_PASSWORD);
                // Begin a transaction to ensure atomicity
                con.setAutoCommit(false);
                // Define the SQL query for deleting existing data
                String deleteQuery = "DELETE FROM timetable";

                try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
                    // Execute the delete query
                    deleteStatement.executeUpdate();

                    // Define the SQL query for batch insertion
                    String bulkQuery = "INSERT INTO timetable (`Start Time`, `End Time`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    // Create a PreparedStatement for batch execution
                    try (PreparedStatement pstmt = con.prepareStatement(bulkQuery)) {
                        for (int i = 0; i < bulkModel.getRowCount(); i++) {
                            // Extract values from the table model for each column
                            String startTime = bulkModel.getValueAt(i, 0).toString();
                            String endTime = bulkModel.getValueAt(i, 1).toString();
                            String monday = bulkModel.getValueAt(i, 2).toString();
                            String tuesday = bulkModel.getValueAt(i, 3).toString();
                            String wednesday = bulkModel.getValueAt(i, 4).toString();
                            String thursday = bulkModel.getValueAt(i, 5).toString();
                            String friday = bulkModel.getValueAt(i, 6).toString();
                            String saturday = bulkModel.getValueAt(i, 7).toString();

                            // Set the parameters for the PreparedStatement
                            pstmt.setString(1, startTime);
                            pstmt.setString(2, endTime);
                            pstmt.setString(3, monday);
                            pstmt.setString(4, tuesday);
                            pstmt.setString(5, wednesday);
                            pstmt.setString(6, thursday);
                            pstmt.setString(7, friday);
                            pstmt.setString(8, saturday);

                            // Add the statement to the batch
                            pstmt.addBatch();
                        }

                        // Execute the batch
                        int[] rowsInserted = pstmt.executeBatch();

                        // Commit the transaction
                        con.commit();

                        // Display success message
                        showMessageDialog("Data Inserted Successfully!\nRows Inserted: " + rowsInserted.length, "Success", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            Thread.sleep(500);
                            MainPage m1= new MainPage(loginUsername);
                            m1.setVisible(true);
                            m1.homePanel.setVisible(true);
                            m1.Home.setBackground(new java.awt.Color(176, 189, 0));
                            m1.jpupdates.setVisible(false);
                            m1.jptimetable.setVisible(false);
                            m1.jpexam.setVisible(false);
                            dispose();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EditableTimeTable.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Rollback the transaction in case of an error
                        con.rollback();
                        showMessageDialog("Error: " + ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    showMessageDialog("Error: " + ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Ensure auto-commit is re-enabled
                    con.setAutoCommit(true);
                    // Close the connection
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                showMessageDialog("Error connecting to the database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        MainPage m1= new MainPage(loginUsername);
        m1.setVisible(true);
        m1.homePanel.setVisible(true);
        m1.Home.setBackground(new java.awt.Color(176, 189, 0));
        m1.jpupdates.setVisible(false);
        m1.jptimetable.setVisible(false);
        m1.jpexam.setVisible(false);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditableTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditableTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditableTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditableTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditableTimeTable("Default Value").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
