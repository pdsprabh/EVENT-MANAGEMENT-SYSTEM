import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(128, 0, 128));
        headerPanel.setLayout(new BorderLayout());
        JLabel headerLabel = new JLabel("ONLINE EVENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("Transforming Ideas into Flawless Events", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel taglineLabel = new JLabel("Seamless Events, Unforgettable Moments!", SwingConstants.CENTER);
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setFont(new Font("Arial", Font.BOLD, 18));
        getStartedButton.setBackground(Color.YELLOW);
        getStartedButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // MouseListener for hover effect
        getStartedButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getStartedButton.setBackground(Color.ORANGE); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getStartedButton.setBackground(Color.YELLOW); // Revert to original color
            }
        });

        // Add action listener for button click
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close front page
                new LoginPage(); // Open login page
            }
        });

        contentPanel.add(Box.createVerticalStrut(100));
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(taglineLabel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(getStartedButton);

        frame.add(contentPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
