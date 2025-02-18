import java.awt.*;
import javax.swing.*;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Header Panel
        JLabel header = new JLabel("Login to Event Management System", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, BorderLayout.NORTH);

        // Main Login Panel
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Username
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(20);
        
        // Password
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(20);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 153, 204));
        loginButton.setForeground(Color.WHITE);

        // Signup Button
        JButton signupButton = new JButton("New User? Sign Up");
        signupButton.setForeground(new Color(0, 102, 204));

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(userLabel, gbc);
        
        gbc.gridy = 1;
        loginPanel.add(passLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(userField, gbc);
        
        gbc.gridy = 1;
        loginPanel.add(passField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);
        
        gbc.gridy = 3;
        loginPanel.add(signupButton, gbc);

        // Add login panel to frame
        add(loginPanel, BorderLayout.CENTER);

        // Action Listeners
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            char[] password = passField.getPassword();
            
            // Add your authentication logic here
            if (username.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            } else {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                // Open main application window here
            }
        });

        signupButton.addActionListener(e -> {
            dispose(); // Close login page
            new SignupPage(); // Open signup page
        });

        setVisible(true);
    }
}