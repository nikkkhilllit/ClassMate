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
    private JPanel mainPanel;
    private JPanel messagePanel;
    private JTextField inputField;
    private JTextField messageTextField;
    private Connection conn;
    private static final Logger LOGGER = Logger.getLogger(UpdatePanelExample.class.getName());
    private TrayIcon trayIcon;

    public UpdatePanelExample() {
        setTitle("Update Panel Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(messagePanel);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        mainPanel.add(inputField, BorderLayout.NORTH);

        JButton switchPanelButton = new JButton("Switch Panel");
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
        JPanel messageInputPanel = new JPanel(new BorderLayout());

        messageTextField = new JTextField();
        messageInputPanel.add(messageTextField, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
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
        mainPanel.add(inputField, BorderLayout.NORTH);
        
        JButton switchPanelButton = new JButton("Switch Panel");
        switchPanelButton.addActionListener(e -> switchToMessagePanel());
        mainPanel.add(switchPanelButton, BorderLayout.SOUTH);

        mainPanel.add(new JScrollPane(messagePanel), BorderLayout.CENTER);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void addMessage(String newText, String timestamp) {
        JPanel messageBox = createMessageBox(newText, timestamp);
        messagePanel.add(messageBox, 0);// Add message box at index 0 (bottom)
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
        messageBox.setBackground(new Color(255, 255, 255));
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
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
