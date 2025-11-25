// Name: Ibrahim Khan
// Date: March 18, 2024
// Description: An example of how to make a window class

import javax.swing.*;
// Needed for grid layout
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyWindow {
    private JFrame window;

    // Constructor
    public MyWindow(){

        window = new JFrame();
        window.setTitle("My First Swing App in a Class");
        window.setSize(400, 300);
        // Window will exit when closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Making a panel
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password"));
        JTextField passwordField = new JTextField();
        panel.add(passwordField);


        // Construct the controls for the window
        JButton loginButton = new JButton("Login");
        panel.add(loginButton);
        // Tooltip
        loginButton.setToolTipText("Login");
        // For hotkey of Alt + L, VK refers to Alt specifically
        loginButton.setMnemonic(KeyEvent.VK_L);
        // Add control to the window
        window.add(panel);
        window.getContentPane().add(loginButton);
    }

    // Shows the window
    public void show(){
        window.setVisible(true);
    }
}
