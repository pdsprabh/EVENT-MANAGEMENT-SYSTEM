import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SignupPage extends JFrame {
    // Arrays for fields and error labels to easily reference them.
    private JTextField[] fields;
    private JLabel[] errorLabels;
    
    public SignupPage() {
        setTitle("Sign Up");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        JLabel header = new JLabel("Create New Account", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, BorderLayout.NORTH);
        
        // Create a panel with GridBagLayout having three columns:
        // Column 0: Label, Column 1: Input field, Column 2: Error message.
        JPanel signupPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Field descriptions
        String[] labels = {
            "First Name:", "Middle Name:", "Last Name:",
            "Email:", "Phone Number:", "Password:", "Confirm Password:"
        };
        // Create fields: text fields for regular input, JPasswordField for passwords.
        fields = new JTextField[7];
        fields[0] = new JTextField(20); // First Name
        fields[1] = new JTextField(20); // Middle Name
        fields[2] = new JTextField(20); // Last Name
        fields[3] = new JTextField(20); // Email
        fields[4] = new JTextField(20); // Phone Number
        fields[5] = new JPasswordField(20); // Password
        fields[6] = new JPasswordField(20); // Confirm Password
        
        // Create error labels for each field.
        errorLabels = new JLabel[labels.length];
        
        // Add each field, label, and error label into the panel.
        for (int i = 0; i < labels.length; i++) {
            // Column 0: Instruction label
            gbc.gridx = 0;
            gbc.gridy = i;
            signupPanel.add(new JLabel(labels[i]), gbc);
            
            // Column 1: Input field
            gbc.gridx = 1;
            signupPanel.add(fields[i], gbc);
            
            // Column 2: Error label (initially empty; text in red)
            gbc.gridx = 2;
            errorLabels[i] = new JLabel("");
            errorLabels[i].setForeground(Color.RED);
            signupPanel.add(errorLabels[i], gbc);
        }
        
        // Attach DocumentListeners for real‑time validation.
        addDocumentListeners();
        
        // Buttons for submission and cancel.
        JButton signupButton = new JButton("Register");
        signupButton.setBackground(new Color(76, 175, 80));
        signupButton.setForeground(Color.WHITE);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);
        
        gbc.gridx = 1;
        gbc.gridy = labels.length;
        signupPanel.add(signupButton, gbc);
        
        gbc.gridx = 2;
        signupPanel.add(cancelButton, gbc);
        
        add(signupPanel, BorderLayout.CENTER);
        
        // When the "Register" button is pressed, check that no error messages are present.
        signupButton.addActionListener(e -> {
            boolean valid = true;
            for (JLabel errorLabel : errorLabels) {
                if (!errorLabel.getText().isEmpty()) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                JOptionPane.showMessageDialog(this, "Account created successfully!");
                dispose();
                new LoginPage();
            } else {
                JOptionPane.showMessageDialog(this, "Please correct the highlighted errors.");
            }
        });
        
        cancelButton.addActionListener(e -> {
            dispose();
            new LoginPage();
        });
        
        setVisible(true);
    }
    
    // Add DocumentListeners to the fields that require validation.
    private void addDocumentListeners() {
        // Validate First Name: It should not be empty.
        fields[0].getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validateFirstName(); }
            public void removeUpdate(DocumentEvent e) { validateFirstName(); }
            public void changedUpdate(DocumentEvent e) { validateFirstName(); }
        });
        
        // Validate Email: Check that it is not empty and follows a basic email format.
        fields[3].getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validateEmail(); }
            public void removeUpdate(DocumentEvent e) { validateEmail(); }
            public void changedUpdate(DocumentEvent e) { validateEmail(); }
        });
        
        // Validate Phone Number: Must be a 10-digit number.
        fields[4].getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validatePhone(); }
            public void removeUpdate(DocumentEvent e) { validatePhone(); }
            public void changedUpdate(DocumentEvent e) { validatePhone(); }
        });
        
        // Validate Password: Must be at least 8 characters long with a number, an uppercase, and a lowercase letter.
        // Also update the Confirm Password validation since it depends on Password.
        fields[5].getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validatePassword(); validateConfirmPassword(); }
            public void removeUpdate(DocumentEvent e) { validatePassword(); validateConfirmPassword(); }
            public void changedUpdate(DocumentEvent e) { validatePassword(); validateConfirmPassword(); }
        });
        
        // Validate Confirm Password: Must match the Password.
        fields[6].getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validateConfirmPassword(); }
            public void removeUpdate(DocumentEvent e) { validateConfirmPassword(); }
            public void changedUpdate(DocumentEvent e) { validateConfirmPassword(); }
        });
    }
    
    // --- Validation Methods ---
    
    private void validateFirstName() {
        String text = fields[0].getText().trim();
        if (text.isEmpty()) {
            errorLabels[0].setText("Required");
        } else {
            errorLabels[0].setText("");
        }
    }
    
    private void validateEmail() {
        String email = fields[3].getText().trim();
        if (email.isEmpty()) {
            errorLabels[3].setText("Required");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            errorLabels[3].setText("Invalid email");
        } else {
            errorLabels[3].setText("");
        }
    }
    
    private void validatePhone() {
        String phone = fields[4].getText().trim();
        if (phone.isEmpty()) {
            errorLabels[4].setText("Required");
        } else if (!phone.matches("^\\d{10}$")) {
            errorLabels[4].setText("10-digit number required");
        } else {
            errorLabels[4].setText("");
        }
    }
    
    private void validatePassword() {
        String password = new String(((JPasswordField) fields[5]).getPassword());
        if (password.isEmpty()) {
            errorLabels[5].setText("Required");
        } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            errorLabels[5].setText("Min 8 chars, include number, upper & lower");
        } else {
            errorLabels[5].setText("");
        }
    }
    
    private void validateConfirmPassword() {
        String password = new String(((JPasswordField) fields[5]).getPassword());
        String confirmPassword = new String(((JPasswordField) fields[6]).getPassword());
        if (confirmPassword.isEmpty()) {
            errorLabels[6].setText("Required");
        } else if (!confirmPassword.equals(password)) {
            errorLabels[6].setText("Passwords do not match");
        } else {
            errorLabels[6].setText("");
        }
    }
    
    // For testing purposes: a main method to run the signup page.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignupPage::new);
    }
}
