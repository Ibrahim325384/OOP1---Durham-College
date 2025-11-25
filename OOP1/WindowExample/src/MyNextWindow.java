// Name: Ibrahim Khan
// Date: March 18, 2024
// Description: An example of how to make a window class, difference from MyWindow is in the panel stuff

import javax.swing.*;
// Needed for grid layout
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyNextWindow {
    private JFrame window;

    // Constructor
    public MyNextWindow(){

        window = new JFrame();
        window.setTitle("My First Swing App in a Class");
        window.setSize(400, 300);
        // Window will exit when closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Manually adding labels
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        window.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 50, 100, 30);
        window.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(150, 50, 100, 30);
        window.add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 50, 100, 30);
        window.add(passwordField);

    }

    // Shows the window
    public void show(){
        window.setVisible(true);
    }
}
