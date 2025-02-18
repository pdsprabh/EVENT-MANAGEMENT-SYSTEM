import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a BackgroundPanel with the specified image path
        BackgroundPanel backgroundPanel = new BackgroundPanel("D:/EVENT MANAGEMENT SYSTEM/EVENT MANAGEMENT SYSTEM/src/data/background.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Header Panel (opaque so it shows its purple background)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(128, 0, 128));
        headerPanel.setLayout(new BorderLayout());
        JLabel headerLabel = new JLabel("ONLINE EVENT MANAGEMENT SYSTEM", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        backgroundPanel.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel using GridBagLayout to center content both vertically and horizontally
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false); // Transparent panel so the background image shows through
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        
        // Top spacer panel to push components toward the center vertically
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        JPanel topSpacer = new JPanel();
        topSpacer.setOpaque(false);
        contentPanel.add(topSpacer, gbc);

        // Title Label
        JLabel titleLabel = new JLabel("Transforming Ideas into Flawless Events", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.BLACK);
        gbc.gridy = 1;
        gbc.weighty = 0;
        contentPanel.add(titleLabel, gbc);

        // Tagline Label
        JLabel taglineLabel = new JLabel("Seamless Events, Unforgettable Moments!", SwingConstants.CENTER);
        taglineLabel.setForeground(Color.WHITE);
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        taglineLabel.setOpaque(true);
        taglineLabel.setBackground(Color.BLACK);
        gbc.gridy = 2;
        contentPanel.add(taglineLabel, gbc);

        // Get Started Button
        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setFont(new Font("Arial", Font.BOLD, 18));
        getStartedButton.setBackground(Color.YELLOW);
        gbc.gridy = 3;
        contentPanel.add(getStartedButton, gbc);

        // Bottom spacer panel to push components toward the center vertically
        gbc.gridy = 4;
        gbc.weighty = 1.0;
        JPanel bottomSpacer = new JPanel();
        bottomSpacer.setOpaque(false);
        contentPanel.add(bottomSpacer, gbc);

        // MouseListener for hover effect on the button
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

        // Action listener for button click
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close front page
                new LoginPage(); // Open login page (ensure LoginPage class is defined)
            }
        });

        backgroundPanel.add(contentPanel, BorderLayout.CENTER);

        // Set the custom background panel as the content pane
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
    }
}

// Custom JPanel that paints a background image
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        // Load the image from the specified path
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image scaled to fill the panel
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
