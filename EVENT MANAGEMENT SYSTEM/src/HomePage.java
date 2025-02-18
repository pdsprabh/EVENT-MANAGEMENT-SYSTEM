import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HomePage extends JFrame {
    public HomePage() {
        setTitle("Select Position");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel header = new JLabel("What position do you want to play?", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        add(header, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20)); // Center alignment
        
        // Load icons
        ImageIcon userIcon = new ImageIcon("user.png"); // Ensure the image file exists in the project directory
        ImageIcon organizerIcon = new ImageIcon("organizer.png");

        // Create buttons with icons
        JButton userButton = new JButton("User", userIcon);
        JButton organizerButton = new JButton("Organizer", organizerIcon);

        // Adjust button size
        userButton.setFont(new Font("Arial", Font.BOLD, 14));
        organizerButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        userButton.setPreferredSize(new Dimension(120, 60));
        organizerButton.setPreferredSize(new Dimension(120, 60));

        userButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        userButton.setHorizontalTextPosition(SwingConstants.CENTER);
        organizerButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        organizerButton.setHorizontalTextPosition(SwingConstants.CENTER);

        buttonPanel.add(userButton);
        buttonPanel.add(organizerButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners for buttons
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You selected User role!");
                // Open User Dashboard
            }
        });

        organizerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You selected Organizer role!");
                // Open Organizer Dashboard
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}