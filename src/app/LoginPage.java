/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

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

        user.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        user.setForeground(new java.awt.Color(79, 66, 255));
        user.setText("Username :-");

        passwordlabel.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        passwordlabel.setForeground(new java.awt.Color(79, 66, 255));
        passwordlabel.setText("Password :-");

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(54, 53, 53));
        jLabel1.setText("Doesn't have an account?");

        signUp.setFont(new java.awt.Font("Dubai Medium", 0, 15)); // NOI18N
        signUp.setForeground(new java.awt.Color(37, 121, 229));
        signUp.setText("Sign Up");
        signUp.setBorder(null);
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUp(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
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

        passwordField.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        passwordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(75, 63, 243), java.awt.Color.white));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73)
                        .addComponent(signUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(passwordlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(207, 207, 207))
                    .addComponent(usernameField)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(208, 208, 208))
                    .addComponent(passwordField))
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordlabel)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(signUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(studentRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teacherRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)))
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
                            .addComponent(studentRadioBtn)
                            .addComponent(teacherRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108))
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
        sp.show();
        dispose();
    }//GEN-LAST:event_signUp
    public String returnInfo(){
            String u1=usernameField.getText();
            return u1;
        }
    private void loginPerform(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPerform
        // TODO add your handling code here:
        String u1=usernameField.getText();
        String p1=passwordField.getText();
        Connection con=null;
        PreparedStatement preparedstatement=null;
        ResultSet rs=null;
        if(!studentRadioBtn.isSelected() && !teacherRadioBtn.isSelected()){
            showMessageDialog("Please Select any one 'Student' or 'Teacher' ","Warning",JOptionPane.WARNING_MESSAGE);
        }
        if(studentRadioBtn.isSelected()){
            try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","root","pranav@030429");
                preparedstatement=con.prepareStatement("SELECT password FROM users WHERE username=?");
                preparedstatement.setString(1,u1);
                rs=preparedstatement.executeQuery();
                if(!rs.isBeforeFirst()){
                    showMessageDialog("User not found in database \nPlease Sign Up","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    while(rs.next()){
                        String reterivedPassword=rs.getString("password");
                        if(reterivedPassword.equals(p1)){
                            //new JFrame
                            MainPage m1= new MainPage(u1);
                            m1.show();
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
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdatabase","root","pranav@030429");
                preparedstatement=con.prepareStatement("SELECT password FROM teachers WHERE username =?");
                preparedstatement.setString(1,u1);
                rs=preparedstatement.executeQuery();
                if(!rs.isBeforeFirst()){
                    showMessageDialog("User not found in database","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    while(rs.next()){
                        String reterivedPassword=rs.getString("password");
                        if(reterivedPassword.equals(p1)){
                            //new JFrame
                            MainPage m1= new MainPage(u1);
                            m1.setVisible(true);
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
    private javax.swing.JButton signUp;
    private javax.swing.JRadioButton studentRadioBtn;
    private javax.swing.JRadioButton teacherRadioBtn;
    private javax.swing.JLabel user;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
