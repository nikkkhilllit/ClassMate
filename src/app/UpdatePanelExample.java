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
    private static final String DB_PASSWORD="pranav@030429";
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root",DB_PASSWORD);
            LOGGER.info("Connected to database.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error connecting to database", e);
            JOptionPane.showMessageDialog(this, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS messages (id INT PRIMARY KEY AUTOINCREMENT, text VARCHAR(45), timestamp TIMESTAMP)");
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
        JPanel messageInputPanel = new JPanel(new BorderLayout());
        name=new JLabel("Enter Notice or Message (It will be Permenant) : ");
        messageInputPanel.add(name,BorderLayout.NORTH);
        messageTextField = new JTextField();
        messageInputPanel.add(messageTextField,BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(204, 204, 255));
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

        messageInputPanel.add(submitButton, BorderLayout.EAST);

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
        messagePanel.add(messageBox);// Add message box at index 0 (bottom)
        messagePanel.add(Box.createVerticalStrut(5));// Add spacing between message boxes
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
        messageBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

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
        switchPanelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        messageTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JButton submitButton;
    private javax.swing.JButton switchPanelButton;
    // End of variables declaration//GEN-END:variables
}
