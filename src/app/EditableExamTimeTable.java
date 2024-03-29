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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class EditableExamTimeTable extends javax.swing.JFrame {

    /**
     * Creates new form EditableExamTimeTable
     */
    private String loginUsername;
    private static final String DB_PASSWORD="pranav@030429";
    public EditableExamTimeTable(String u1) {
        loginUsername=u1;
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

        jScrollPane2 = new javax.swing.JScrollPane();
        examTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EditExamTimeTable");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(620, 320));

        examTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        examTable.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sr No.", "Date", "S.Y.B.Sc. C.S"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        examTable.setColumnSelectionAllowed(true);
        examTable.setGridColor(new java.awt.Color(0, 0, 0));
        examTable.setName(""); // NOI18N
        examTable.setShowGrid(true);
        examTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(examTable);

        addBtn.setBackground(new java.awt.Color(79, 66, 255));
        addBtn.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\icons8-add-file-24.png")); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.setIconTextGap(8);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(79, 66, 255));
        backBtn.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\back_btn.png")); // NOI18N
        backBtn.setText("Back");
        backBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(79, 66, 255));
        saveBtn.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\icons8-save-24.png")); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backBtn)
                        .addComponent(saveBtn)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
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
                JOptionPane.showMessageDialog(null,"You are not allowed to edit","Error",JOptionPane.WARNING_MESSAGE);
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        if(addBtn.isEnabled()){
            String[] columnNames = {"Sr No.", "Date", "S.Y.B.Sc.C.S"};
            DefaultTableModel model = new DefaultTableModel(null, columnNames);
            examTable.setModel(model);

            File excelFile;
            FileInputStream excelFIS = null;
            BufferedInputStream excelBIS = null;
            Workbook excelImportToJTable = null; // Use Workbook instead of XSSFWorkbook
            String defaultCurrentDirectoryPath = "C:\\Users\\admin\\OneDrive\\Documents\\NetBeansProjects\\ClassMate";
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
                    } else if (excelFile.getName().endsWith("csv")) {
                        excelImportToJTable = new HSSFWorkbook(excelBIS);
                    }
                    else {
                        // Handle unsupported file types
                        JOptionPane.showMessageDialog(null, "Unsupported file type. Please select a valid Excel file.");
                        return;
                    }
                    Sheet excelSheet = (Sheet) excelImportToJTable.getSheetAt(0);

                    for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                        Row excelRow = excelSheet.getRow(row);
                        Cell excelSrNO = excelRow.getCell(0);
                        Cell excelDate = excelRow.getCell(1);
                        Cell excelSycs = excelRow.getCell(2);
                        model.addRow(new Object[]{excelSrNO, excelDate, excelSycs});
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

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        try {
        DefaultTableModel bulkModel = (DefaultTableModel) examTable.getModel();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examdatabase", "root", DB_PASSWORD);
        // Begin a transaction to ensure atomicity
        con.setAutoCommit(false);
        // Define the SQL query for deleting existing data
        String deleteQuery = "DELETE FROM examtimetable";

        try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
            // Execute the delete query
            deleteStatement.executeUpdate();

            // Define the SQL query for batch insertion
            String bulkQuery = "INSERT INTO examtimetable (`Sr No.`, `Date`, `S.Y.B.Sc.C.S`) VALUES (?, ?, ?)";

            // Create a PreparedStatement for batch execution
            try (PreparedStatement pstmt = con.prepareStatement(bulkQuery)) {
                for (int i = 0; i < bulkModel.getRowCount(); i++) {
                    // Extract values from the table model for each column
                    String SrNo = bulkModel.getValueAt(i, 0).toString();
                    Cell excelDateCell = (Cell) bulkModel.getValueAt(i, 1); // Get the date cell
                    String CS = bulkModel.getValueAt(i, 2).toString();

                    // Convert the date cell to java.sql.Date using the helper method
                    java.sql.Date sqlDate = convertExcelDateToSQLDate(excelDateCell);

                    // Set the parameters for the PreparedStatement
                    pstmt.setString(1, SrNo);
                    pstmt.setDate(2, sqlDate);
                    pstmt.setString(3, CS);

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
    private java.sql.Date convertExcelDateToSQLDate(Cell excelDateCell) {
    try {
        switch (excelDateCell.getCellType()) {
            case STRING:
                // If the cell type is STRING, directly get the string value
                String excelDateString = excelDateCell.getStringCellValue();
                SimpleDateFormat excelDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                Date parsedDate = excelDateFormat.parse(excelDateString);

                // Convert to 'YYYY-MM-DD' format
                SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String sqlDateString = sqlDateFormat.format(parsedDate);

                // Return as java.sql.Date
                return java.sql.Date.valueOf(sqlDateString);

            case NUMERIC:
                // If the cell type is NUMERIC, get the date as a numeric value
                // and use DateUtil to convert it to java.util.Date
                Date numericDate = excelDateCell.getDateCellValue();

                // Convert to 'YYYY-MM-DD' format
                SimpleDateFormat sqlNumericDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String sqlNumericDateString = sqlNumericDateFormat.format(numericDate);

                // Return as java.sql.Date
                return java.sql.Date.valueOf(sqlNumericDateString);

            default:
                // Handle other cell types or return null as appropriate
                System.out.println("Unsupported cell type: " + excelDateCell.getCellType());
                return null;
        }
    } catch (ParseException e) {
        e.printStackTrace();
        // Handle parsing errors
        return null;
    }
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
            java.util.logging.Logger.getLogger(EditableExamTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditableExamTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditableExamTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditableExamTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditableExamTimeTable("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTable examTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
