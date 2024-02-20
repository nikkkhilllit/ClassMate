package app;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import java.awt.TrayIcon.MessageType;

public class UpdatePanelExample extends JFrame {
      
    private Connection conn;
    private static final Logger LOGGER = Logger.getLogger(UpdatePanelExample.class.getName());
    private TrayIcon trayIcon;

    public UpdatePanelExample() {
        setTitle("Update Panel Example");
        setSize(610, 490);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(messagePanel);

        mainPanel.add(scrollPane, BorderLayout.CENTER);


        JButton switchPanelButton = new JButton("Edit");
        switchPanelButton.setBackground(new Color(204, 204, 255));
        switchPanelButton.addActionListener(e -> switchToMessagePanel());
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Align the button to the left
        buttonPanel.add(switchPanelButton);
    
        mainPanel.add(switchPanelButton, BorderLayout.SOUTH);

        add(mainPanel);

        connectToDatabase();
        createTable();
        loadMessagesFromDatabase();

        createSystemTrayIcon();
        
    }

    private void connectToDatabase() {
        try {
            LOGGER.info("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Messages","ckt","ckt");
            LOGGER.info("Connected to database.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error connecting to database", e);
            JOptionPane.showMessageDialog(this, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS messages (id INTEGER PRIMARY KEY AUTOINCREMENT, text TEXT, timestamp TIMESTAMP)");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error creating table in database", e);
            JOptionPane.showMessageDialog(this, "Error creating table in database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadMessagesFromDatabase() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");
            while (rs.next()) {
                String messageText = rs.getString("text");
                String timestamp = rs.getString("timestamp");
                addMessage(messageText, timestamp);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading messages from database", e);
            JOptionPane.showMessageDialog(this, "Error loading messages from database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void switchToMessagePanel() {
        JPanel messageInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        messageInputPanel.setBackground(new Color(204, 204, 255));
        name7=new JLabel("                                                                                                                                                                   ");
        messageInputPanel.add(name7);
        name4=new JLabel("                          Notice Edit Mode");
        name4.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
        name4.setForeground(new Color(102, 102, 255));
        messageInputPanel.add(name4);
        name3=new JLabel("                                                                                                                                                                                                                                                                                                                                                                        ");
        messageInputPanel.add(name3);
        name5=new JLabel("                                                                                                                                                                                                                                                                                                                                                                        ");
        messageInputPanel.add(name5);
        name6=new JLabel("                                                                                                                                                                                                                                                                                                                                                                        ");
        messageInputPanel.add(name6);
        name=new JLabel("Enter Notice or Message (It will be Permenant) :                                    ");
        messageInputPanel.add(name);
        name8=new JLabel("                                                                                                                                                                   ");
        messageInputPanel.add(name8);
        messageTextField = new JTextField();
        messageTextField.setPreferredSize(new Dimension(400, 100));
        messageInputPanel.add(messageTextField);
        
        name1=new JLabel("                                                                                                                                                            ");
        name2=new JLabel("                                                                                                                                                                   ");
        messageInputPanel.add(name1);
        messageInputPanel.add(name2);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(153, 153, 255));
        submitButton.setPreferredSize(new Dimension(80, 30));
        
        submitButton.addActionListener(e -> {
            String messageText = messageTextField.getText().trim();
            if (!messageText.isEmpty()) {
                addMessage(messageText);
                saveMessageToDatabase(messageText);
                showNotification("New Message", messageText); // Show notification
                messageTextField.setText(""); // Clear the input field after adding text
                switchToMainPanel(); // Switch back to the main panel after submitting the message
            }
        });

        messageInputPanel.add(submitButton);

        mainPanel.removeAll();
        mainPanel.add(messageInputPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void switchToMainPanel() {
        mainPanel.removeAll();
        
        JButton switchPanelButton = new JButton("Edit");
        switchPanelButton.setBackground(new Color(153, 153, 255));
        switchPanelButton.addActionListener(e -> switchToMessagePanel());
        mainPanel.add(switchPanelButton, BorderLayout.SOUTH);

        mainPanel.add(new JScrollPane(messagePanel), BorderLayout.CENTER);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void addMessage(String newText, String timestamp) {
        JPanel messageBox = createMessageBox(newText, timestamp);
        messagePanel.add(messageBox,0);// Add message box at index 0 (bottom)
        messagePanel.add(Box.createVerticalStrut(10),1);// Add spacing between message boxes
        messagePanel.add(Box.createHorizontalStrut(10));
        messagePanel.revalidate();
        messagePanel.repaint(); // Ensure proper rendering
        
    }

    private void addMessage(String newText) {
        addMessage(newText, getCurrentTime());
    }
    
    private JPanel createMessageBox(String messageText, String timestamp) {
        JPanel messageBox = new JPanel(new BorderLayout());
        messageBox.setPreferredSize(new Dimension(340, 30));
        messageBox.setBackground(new Color(204, 204, 255));
         messageBox.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createEmptyBorder(5, 10, 5, 10), // Top, left, bottom, right
        BorderFactory.createLineBorder(Color.BLACK) // Border color
    ));

        JLabel messageLabel = new JLabel(messageText);
        messageLabel.setForeground(Color.BLACK);

        JLabel timeLabel = new JLabel(timestamp);
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(timeLabel.getFont().deriveFont(Font.PLAIN, 10));

        messageBox.add(timeLabel, BorderLayout.EAST);
        messageBox.add(messageLabel, BorderLayout.WEST);
        
        return messageBox;
    }
    

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return dateFormat.format(new Date());
    }
    



    private void saveMessageToDatabase(String messageText) {
        try {
            LOGGER.info("Saving message to database...");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO messages (text, timestamp) VALUES (?, ?)");
            stmt.setString(1, messageText);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
            LOGGER.info("Message saved to database.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error saving message to database", e);
            JOptionPane.showMessageDialog(this, "Error saving message to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createSystemTrayIcon() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage("D:\\Programming\\logo.webp"); // Replace "icon.png" with your icon file path
        trayIcon = new TrayIcon(image, "New Message");
        trayIcon.setImageAutoSize(true);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
    }

    private void showNotification(String title, String message) {
        if (SystemTray.isSupported() && trayIcon != null) {
            trayIcon.displayMessage(title, message, MessageType.INFO);
        } else {
            JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UpdatePanelExample example = new UpdatePanelExample();
            example.setVisible(true);
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        messagePanel = new javax.swing.JPanel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        name6 = new javax.swing.JLabel();
        name7 = new javax.swing.JLabel();
        name8 = new javax.swing.JLabel();
        switchPanelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        messageTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        name1.setText("jLabel1");

        name2.setText("jLabel1");

        name3.setText("jLabel1");

        name4.setText("jLabel1");

        name5.setText("jLabel1");

        name6.setText("jLabel1");

        name7.setText("jLabel1");

        name8.setText("jLabel2");

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messagePanelLayout.createSequentialGroup()
                .addGap(0, 169, Short.MAX_VALUE)
                .addComponent(name5)
                .addGap(107, 107, 107)
                .addComponent(name3)
                .addGap(183, 183, 183))
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(name2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name4)
                .addGap(87, 87, 87))
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(name1))
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(name7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messagePanelLayout.createSequentialGroup()
                        .addComponent(name6)
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messagePanelLayout.createSequentialGroup()
                        .addComponent(name8)
                        .addGap(106, 106, 106))))
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(name6)
                .addGap(27, 27, 27)
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name2)
                    .addComponent(name4))
                .addGap(46, 46, 46)
                .addComponent(name1)
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(name3))
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(name5)))
                .addGap(19, 19, 19)
                .addComponent(name7)
                .addGap(18, 18, 18)
                .addComponent(name8)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        switchPanelButton.setBackground(new java.awt.Color(204, 204, 255));
        switchPanelButton.setText("Edit");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(switchPanelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(messagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(switchPanelButton)
                .addContainerGap())
        );

        messageTextField.setText("jTextField1");
        messageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageTextFieldActionPerformed(evt);
            }
        });

        submitButton.setBackground(new java.awt.Color(204, 204, 255));
        submitButton.setText("Submit");

        name.setText("Enter Notice : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(submitButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void messageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JLabel name7;
    private javax.swing.JLabel name8;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton switchPanelButton;
    // End of variables declaration//GEN-END:variables
}
