package app;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    private static final String DB_PASSWORD="pranav@030429";
    public SignUpPage() {
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studentRadioBtn = new javax.swing.JRadioButton();
        teacherRadioBtn = new javax.swing.JRadioButton();
        backLoginBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        signupbtn = new javax.swing.JButton();
        showPassword = new javax.swing.JCheckBox();
        confirmPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setPreferredSize(new java.awt.Dimension(420, 600));

        jPanel1.setBackground(new java.awt.Color(79, 66, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 131, 255), 1, true));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(79, 66, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 56)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIGN UP");

        studentRadioBtn.setBackground(new java.awt.Color(79, 66, 255));
        buttonGroup1.add(studentRadioBtn);
        studentRadioBtn.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        studentRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        studentRadioBtn.setText("Student");
        studentRadioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        teacherRadioBtn.setBackground(new java.awt.Color(79, 66, 255));
        buttonGroup1.add(teacherRadioBtn);
        teacherRadioBtn.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        teacherRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        teacherRadioBtn.setText("Teacher");
        teacherRadioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        backLoginBtn.setBackground(new java.awt.Color(79, 66, 255));
        backLoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        backLoginBtn.setBorder(null);
        backLoginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backLoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(studentRadioBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacherRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(backLoginBtn)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentRadioBtn)
                            .addComponent(teacherRadioBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 131, 255), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(380, 355));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 66, 255));
        jLabel2.setText("Username :-");

        usernameField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        usernameField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(75, 63, 243), java.awt.Color.white));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 66, 255));
        jLabel3.setText("Password :-");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 66, 255));
        jLabel4.setText("Confirm Password :-");

        passwordField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        passwordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(75, 63, 243), java.awt.Color.white));

        confirmPasswordField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        confirmPasswordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(75, 63, 243), java.awt.Color.white));

        signupbtn.setBackground(new java.awt.Color(79, 66, 255));
        signupbtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        signupbtn.setForeground(new java.awt.Color(255, 255, 255));
        signupbtn.setText("Sign Up");
        signupbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUp(evt);
            }
        });

        showPassword.setBackground(new java.awt.Color(255, 255, 255));
        showPassword.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        showPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showPassword.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\icons8-show-password-24.png")); // NOI18N
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        confirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        confirmPassword.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        confirmPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmPassword.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Downloads\\New folder\\icons8-show-password-24.png")); // NOI18N
        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(300, 300, 300))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPassword))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPassword))
                .addGap(49, 49, 49)
                .addComponent(signupbtn)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private static void showMessageDialog(String message, String title, int messageType) {
            JOptionPane.showMessageDialog(null, message, title, messageType);
        }
    private void signUp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUp
        // TODO add your handling code here:
        String new_u1=usernameField.getText();
        String new_p1=passwordField.getText();
        String confirm_p1=confirmPasswordField.getText();
        if(!studentRadioBtn.isSelected() && !teacherRadioBtn.isSelected()){
            showMessageDialog("Please Select any one 'Student' or 'Teacher' ","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(new_u1.isEmpty() && new_p1.isEmpty() && confirm_p1.isEmpty()){
            showMessageDialog("Please fill in all fields","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else if(new_u1.isEmpty() && !new_p1.isEmpty()){
            showMessageDialog("Username cannot be Blank!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(!new_u1.isEmpty() && new_p1.isEmpty() && confirm_p1.isEmpty()){
            showMessageDialog("Password cannot be Blank!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(!new_u1.isEmpty() && !new_p1.isEmpty() && confirm_p1.isEmpty()){
            showMessageDialog("Confirm Password cannot be Blank!!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!new_u1.matches("[a-zA-Z0-9]+")) {
            showMessageDialog("Username should only contain Alphabets and Numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!new_p1.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$")) {
        showMessageDialog("Password should have at least 7 characters, one uppercase letter, one lowercase letter, one digit, and one special character", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        if(!confirm_p1.equals(new_p1)){
            try {
                showMessageDialog("Confirm Password don't match the password","Password not same",JOptionPane.ERROR_MESSAGE);
                Thread.sleep(100);
                SignUpPage s1 =new SignUpPage();
                s1.setVisible(true);
                dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        Connection con=null;
        Connection con2=null;
        PreparedStatement psInsert=null;
        PreparedStatement psCheckUserExists=null;
        PreparedStatement psInsert2=null;
        PreparedStatement psCheckUserExists2=null;
        ResultSet rs=null;
        ResultSet rs2=null;
        if(studentRadioBtn.isSelected()){
            try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root",DB_PASSWORD);
            psCheckUserExists=con.prepareStatement("SELECT * from students WHERE username = ?");
            psCheckUserExists.setString(1, new_u1);
            rs=psCheckUserExists.executeQuery();
            if(rs.isBeforeFirst()){
//                System.out.println("User already exists");
                showMessageDialog("User already exists","Error",JOptionPane.ERROR_MESSAGE);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                SignUpPage s1 =new SignUpPage();
                s1.setVisible(true);
                dispose();
                return;
//                Alert alert= new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Username already taken");
//                alert.show();
            }
            else{
                psInsert=con.prepareStatement("INSERT INTO students(username,password,confirmpassword)VALUES(?,?,?)");
                psInsert.setString(1, new_u1);
                psInsert.setString(2,new_p1);
                psInsert.setString(3,confirm_p1);
                psInsert.executeUpdate();
            }
           }catch(SQLException s){
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
                    con.close();
                }catch(SQLException s){
                    s.printStackTrace();
                    }
                }
                 try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                LoginPage L1 =new LoginPage();
                L1.setVisible(true);
                dispose();
            }
        }
        else if(teacherRadioBtn.isSelected()){
        try{
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdatabase","root",DB_PASSWORD);
            psCheckUserExists2=con2.prepareStatement("SELECT * from teachers WHERE username = ?");
            psCheckUserExists2.setString(1, new_u1);
            rs2=psCheckUserExists2.executeQuery();
            if(rs2.isBeforeFirst()){
//                System.out.println("User already exists");
                showMessageDialog("User already exists","Error",JOptionPane.ERROR_MESSAGE);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                SignUpPage s1 =new SignUpPage();
                s1.setVisible(true);
                dispose();
                return;
//                Alert alert= new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Username already taken");
//                alert.show();
            }
            else{
                psInsert2=con2.prepareStatement("INSERT INTO teachers(username,password,confirmpassword)VALUES(?,?,?)");
                psInsert2.setString(1, new_u1);
                psInsert2.setString(2,new_p1);
                psInsert2.setString(3,confirm_p1);
                psInsert2.executeUpdate();
            }
        }catch(SQLException s){
            s.printStackTrace();
        }
        finally{
            if(rs2!=null){
                try{
                    rs2.close();
                }catch(SQLException s){
                    s.printStackTrace();
                }
            }
                if(con2!=null){
                try{
                    con2.close();
                }catch(SQLException s){
                    s.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                LoginPage L1 =new LoginPage();
                L1.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_signUp

    private void backLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backLoginBtnActionPerformed
        // TODO add your handling code here:
        LoginPage l1=new LoginPage();
        l1.setVisible(true);
        dispose();
    }//GEN-LAST:event_backLoginBtnActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        // TODO add your handling code here:
        if (showPassword.isSelected()) {
            passwordField.setEchoChar((char) 0); // Show password
        } else {
            passwordField.setEchoChar('\u2022'); // Mask password
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordActionPerformed
        // TODO add your handling code here:
         if (confirmPassword.isSelected()) {
            confirmPasswordField.setEchoChar((char) 0); // Show password
        } else {
            confirmPasswordField.setEchoChar('\u2022'); // Mask password
        }
    }//GEN-LAST:event_confirmPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backLoginBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox confirmPassword;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JButton signupbtn;
    private javax.swing.JRadioButton studentRadioBtn;
    private javax.swing.JRadioButton teacherRadioBtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
