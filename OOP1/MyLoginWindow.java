// Author: Steve Senter
// Date: March 20, 2025
// Purpose: Design a Login window with no Layout (use SetBounds)

// AODA requires that we consider:
// 1) Font size, colour and contrast - several methods including setFont (not addressed here)
// 2) Tab order - setNextFocusableComponent method is available to override default tab order
// 3) Hot Keys - setMnemonic, setDisplayedMnemonic, setFocusAccelerator methods are available
// 4) Tool Tips - setToolTipText method is available for most controls

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyLoginWindow {
    private JFrame window;

    public MyLoginWindow() {
        final char PASSWORD_ACCELERATOR = 'P';
        final char USERNAME_MNEMONIC = 'U';
        final char LOGIN_BUTTON_MNEMONIC = KeyEvent.VK_L;
        final String WINDOW_TITLE = "My First Swing App";
        final String PASSWORD_LABEL_TEXT = "Password:";
        final String USERNAME_TEXT = "User:";
        final String LOGIN_BUTTON_TEXT = "Login";
        final String USERNAME_ERROR_MSG = "Need a userID to attempt login!";
        final String PASSWORD_ERROR_MSG = "Need a password to attempt login!";
        final String USERNAME_TOOLTIP = "Enter the userID for the login.";
        final String PASSWORD_TOOLTIP = "Enter the password for the login.";
        final String LOGIN_TOOLTIP = "Attempt login using the ID and password provided.";
        final String ACTION_TEXT_TEMPLATE = "Login Attempted by %s (%s)!"; // userName and password
        final String EASTER_EGG_MSG = "Look out - Zombie attack!";
        final boolean ERROR_TYPE = true;  // true for dialog, false for label

        // Construct the window
        window = new JFrame();
        window.setTitle(WINDOW_TITLE);                              // Text displayed at the top of the window
        window.setSize(480, 220);                      // Set initial size of the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // End the application on exit from the window
        window.setLocationRelativeTo(null);                        // Centre the application on the screen
        window.setLayout(null);                                    // Allow controls to be located on window via SetBounds
        window.setResizable(false);                                // Prevent the user from changing the window size

        // Construct the control(s) for the window

        JLabel usernameLabel = new JLabel(USERNAME_TEXT);               // Label for the user ID entry field
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);    // Right justify the text within the label

        JTextField usernameField = new JTextField();                   // Text field for the user ID entry

        JLabel passwordLabel = new JLabel(PASSWORD_LABEL_TEXT);          // Label for the password entry field
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);    // Right justify the text within the label

        JPasswordField passwordField = new JPasswordField();           // Password text field for the password entry
        passwordField.setEchoChar('#');                                // Display # instead of the typed character

        JLabel errorMessage = new JLabel("");                      // Label for displaying error messages

        JButton loginButton = new JButton(LOGIN_BUTTON_TEXT);             // Button to execute login attempt
        loginButton.addActionListener(new ActionListener() {            // Connect the mouse click on button to an action
            @Override
            public void actionPerformed(ActionEvent e) {                // Define the action of the button
                if (usernameField.getText().isEmpty()) {            // Check for data entry for the userID
                    if (ERROR_TYPE) {
                        JOptionPane.showMessageDialog(window, USERNAME_ERROR_MSG);
                    }
                    else {
                        errorMessage.setText(USERNAME_ERROR_MSG);
                    }
                }
                else if (passwordField.getText().isEmpty()) {       // Check for data entry for the password
                    if (ERROR_TYPE) {
                        JOptionPane.showMessageDialog(window, PASSWORD_ERROR_MSG);
                    }
                    else {
                        errorMessage.setText(PASSWORD_ERROR_MSG);
                    }
                }
                else {                                                  // Perform the action
                    System.out.println(String.format(ACTION_TEXT_TEMPLATE,
                            usernameField.getText(), passwordField.getText()));
                    errorMessage.setText("");                           // Clear any error messages previously set
                }
            }
        });

        // Set the position and size of all the controls on the window
        usernameLabel.setBounds(50, 50, 100, 30 );
        usernameField.setBounds(160, 50, 100, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(160, 100, 100, 30);
        errorMessage.setBounds(50, 150, 200, 30);
        loginButton.setBounds(300, 50, 100, 80);

        // Add all the controls to the window
        window.add(usernameLabel);
        window.add(usernameField);
        window.add(passwordLabel);
        window.add(passwordField);
        window.add(errorMessage);
        window.add(loginButton);

        // Establish the tab order through all controls that can have focus
        usernameField.setNextFocusableComponent(passwordField);
        passwordField.setNextFocusableComponent(loginButton);
        loginButton.setNextFocusableComponent(usernameField);

        // Establish the hot keys 'L' for Login button press, 'U' for userID field focus and 'P' for password field focus
        loginButton.setMnemonic(LOGIN_BUTTON_MNEMONIC);               // Hot Key Alt-L to activate button
        usernameLabel.setDisplayedMnemonic(USERNAME_MNEMONIC);    // 'U' underlined in username label text
        usernameField.setFocusAccelerator(USERNAME_MNEMONIC);     // Alt-'U' changes focus to userID field
        passwordLabel.setDisplayedMnemonic(PASSWORD_ACCELERATOR);    // 'P' underlined in password label text
        passwordField.setFocusAccelerator(PASSWORD_ACCELERATOR);     // Alt-'P' change focus to password field

        // Establish the tooltips for all controls that can have focus
        usernameField.setToolTipText(USERNAME_TOOLTIP);
        passwordField.setToolTipText(PASSWORD_TOOLTIP);
        loginButton.setToolTipText(LOGIN_TOOLTIP);

        // Intercept the ENTER and ESCAPE keys as Login and Exit
        // Create a key press handler
        KeyAdapter myKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Check for ENTER and press the login button
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
                // Check for ESCAPE and exit the application
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    window.dispose();
                }
                // Check for ctrl-z and show an easter egg message
                else if (e.getKeyCode() == KeyEvent.VK_Z && e.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
                    JOptionPane.showMessageDialog(window, EASTER_EGG_MSG);
                }
                // Pass the keystroke along for actual handling
                else {
                    super.keyPressed(e);
                }
            }
        };
        // Add the new keystroke listener to ALL controls that can have focus
        window.addKeyListener(myKeyAdapter);
        usernameField.addKeyListener(myKeyAdapter);
        passwordField.addKeyListener(myKeyAdapter);
        loginButton.addKeyListener(myKeyAdapter);
    }

    public void show() {
        window.setVisible(true);        // Start the window
    }
}
