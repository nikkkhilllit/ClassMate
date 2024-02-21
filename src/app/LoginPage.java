/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    private static final String DB_PASSWORD="pranav@030429";
    public LoginPage() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        teacherRadioBtn = new javax.swing.JRadioButton();
        studentRadioBtn = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        signUp = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(400, 550));
        setSize(new java.awt.Dimension(375, 510));

        jPanel2.setBackground(new java.awt.Color(79, 66, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 131, 254), 1, true));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        teacherRadioBtn.setBackground(new java.awt.Color(79, 66, 255));
        buttonGroup1.add(teacherRadioBtn);
        teacherRadioBtn.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        teacherRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        teacherRadioBtn.setText("Teacher");
        teacherRadioBtn.setBorder(null);
        teacherRadioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        studentRadioBtn.setBackground(new java.awt.Color(79, 66, 255));
        buttonGroup1.add(studentRadioBtn);
        studentRadioBtn.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        studentRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        studentRadioBtn.setText("Student");
        studentRadioBtn.setBorder(null);
        studentRadioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setBackground(new java.awt.Color(79, 66, 255));
        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 56)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOG IN");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        user.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        user.setForeground(new java.awt.Color(79, 66, 255));
        user.setText("Username :-");

        passwordlabel.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        passwordlabel.setForeground(new java.awt.Color(79, 66, 255));
        passwordlabel.setText("Password :-");

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(54, 53, 53));
        jLabel1.setText("Doesn't have an account?");

        signUp.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        signUp.setForeground(new java.awt.Color(37, 121, 229));
        signUp.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\sign up.png")); // NOI18N
        signUp.setText("Sign Up");
        signUp.setBorder(null);
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUp(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        usernameField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(75, 63, 243), java.awt.Color.white));

        loginButton.setBackground(new java.awt.Color(79, 66, 255));
        loginButton.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPerform(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        passwordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(75, 63, 243), java.awt.Color.white));

        showPassword.setBackground(new java.awt.Color(255, 255, 255));
        showPassword.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        showPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showPassword.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\icons8-show-password-24.png")); // NOI18N
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(passwordlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(207, 207, 207))
                    .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addGap(208, 208, 208))
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameField)
                .addGap(18, 18, 18)
                .addComponent(passwordlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(showPassword)))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(studentRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(teacherRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(52, 52, 52))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(teacherRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private static void showMessageDialog(String message, String title, int messageType) {
            JOptionPane.showMessageDialog(null, message, title, messageType);
        }
    private void signUp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUp
        // TODO add your handling code here:
        SignUpPage sp=new SignUpPage();
        sp.setVisible(true);
        dispose();
    }//GEN-LAST:event_signUp

    private void loginPerform(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPerform
        // TODO add your handling code here:
        String u1=usernameField.getText();
        String p1=passwordField.getText();
        Connection con = null;
        PreparedStatement preparedstatement = null;
        ResultSet rs=null;
        if(!studentRadioBtn.isSelected() && !teacherRadioBtn.isSelected()){
            showMessageDialog("Please Select any one 'Student' or 'Teacher' ","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(u1.isEmpty() && p1.isEmpty()){
            showMessageDialog("Please fill in both the fields","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else if(u1.isEmpty() && !p1.isEmpty()){
            showMessageDialog("Username cannot be Blank!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(!u1.isEmpty() && p1.isEmpty()){
            showMessageDialog("Password cannot be Blank!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(studentRadioBtn.isSelected()){
            try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root",DB_PASSWORD);
                preparedstatement=con.prepareStatement("SELECT password FROM students WHERE username=?");
                preparedstatement.setString(1,u1);
                rs=preparedstatement.executeQuery();
                if(!rs.isBeforeFirst()){
                    showMessageDialog("User not found in database!! \nPlease Sign Up","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    while(rs.next()){
                        String reterivedPassword=rs.getString("password");
                        if(reterivedPassword.equals(p1)){
                            //new JFrame
                            MainPage m1= new MainPage(u1);
                            m1.setVisible(true);
                            m1.homePanel.setVisible(true);
                            m1.Home.setBackground(new Color(176, 189, 0));
                            m1.jpupdates.setVisible(false);
                            m1.jptimetable.setVisible(false);
                            m1.jpexam.setVisible(false);
                            dispose();
                        }
                        else{
                            showMessageDialog("Password don't match","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            catch(SQLException s){
                s.printStackTrace();
            }
            finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException s){
                    s.printStackTrace();
                }
            }
                if(con!=null){
                try{
                    rs.close();
                }catch(SQLException s){
                    s.printStackTrace();
                }
            }
        }
    }
        else if(teacherRadioBtn.isSelected()){
            try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdatabase","root",DB_PASSWORD);
                preparedstatement=con.prepareStatement("SELECT password FROM teachers WHERE username =?");
                preparedstatement.setString(1,u1);
                rs=preparedstatement.executeQuery();
                if(!rs.isBeforeFirst()){
                    showMessageDialog("User not found in database!! \nPlease Sign Up","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    while(rs.next()){
                        String reterivedPassword=rs.getString("password");
                        if(reterivedPassword.equals(p1)){
                            //new JFrame
                            MainPage m1= new MainPage(u1);
                            m1.setVisible(true);
                            m1.homePanel.setVisible(true);
                            m1.Home.setBackground(new Color(176, 189, 0));
                            m1.jpupdates.setVisible(false);
                            m1.jptimetable.setVisible(false);
                            m1.jpexam.setVisible(false);
                            dispose();
                        }
                        else{
                            showMessageDialog("Password don't match","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            catch(SQLException s){
                s.printStackTrace();
            }
            finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException s){
                    s.printStackTrace();
                }
            }
                if(con!=null){
                try{
                    rs.close();
                }catch(SQLException s){
                    s.printStackTrace();
                }
            }
        }
    }
    }//GEN-LAST:event_loginPerform

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        // TODO add your handling code here:
         if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0); // Show password
        } else {
            passwordField.setEchoChar('\u2022'); // Mask password
        }
    }//GEN-LAST:event_showPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JButton signUp;
    private javax.swing.JRadioButton studentRadioBtn;
    private javax.swing.JRadioButton teacherRadioBtn;
    private javax.swing.JLabel user;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
