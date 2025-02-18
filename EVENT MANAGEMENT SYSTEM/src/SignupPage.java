import java.awt.*;
import javax.swing.*;

public class SignupPage extends JFrame {
    public SignupPage() {
        setTitle("Sign Up");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel header = new JLabel("Create New Account", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, BorderLayout.NORTH);

        JPanel signupPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Fields
        String[] labels = {"First Name:", "Middle Name:", "Last Name:", "Email:", "Phone Number:", "Password:", "Confirm Password:"};
        JTextField[] fields = {
            new JTextField(20),
            new JTextField(20),
            new JTextField(20),
            new JTextField(20),
            new JTextField(20),
            new JPasswordField(20),
            new JPasswordField(20)
        };

        // Add components
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            signupPanel.add(new JLabel(labels[i]), gbc);
            
            gbc.gridx = 1;
            signupPanel.add(fields[i], gbc);
        }

        JButton signupButton = new JButton("Register");
        signupButton.setBackground(new Color(76, 175, 80));
        signupButton.setForeground(Color.WHITE);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 1;
        signupPanel.add(signupButton, gbc);
        
        gbc.gridx = 1;
        signupPanel.add(cancelButton, gbc);

        add(signupPanel, BorderLayout.CENTER);

        // Signup Action
        signupButton.addActionListener(e -> {
            String firstName = fields[0].getText().trim();
            String email = fields[3].getText().trim();
            String phoneNumber = fields[4].getText().trim();
            String password = new String(((JPasswordField) fields[5]).getPassword());
            String confirmPassword = new String(((JPasswordField) fields[6]).getPassword());
            
            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "First Name is required!");
                return;
            }
            
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(this, "Enter a valid email!");
                return;
            }
            
            if (!phoneNumber.matches("^\\d{10}$")) {
                JOptionPane.showMessageDialog(this, "Enter a valid 10-digit phone number!");
                return;
            }
            
            if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
                JOptionPane.showMessageDialog(this, "Password must be at least 8 characters and include a number, an uppercase, and a lowercase letter!");
                return;
            }
            
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
                return;
            }
            
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            dispose();
            new LoginPage();
        });
        
        cancelButton.addActionListener(e -> {
            dispose(); // Close sign-up page
            new LoginPage(); // Return to login page
        });

        setVisible(true);
    }
}
