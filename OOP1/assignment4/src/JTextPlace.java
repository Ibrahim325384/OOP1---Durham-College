// Name: Ibrahim Khan
// Date: March 25, 2025
// Description: Program creates a window that is a multiline text editor

import javax.swing.*;
import java.awt.event.*;

public class JTextPlace {

        private JFrame window;

        // This is a text area, it was made in this manner so that it could be added to the window
        static JTextArea textArea;

        public JTextPlace() {
            final char ENTER_MNEMONIC = '1';
            final char SAVE_MNEMONIC = '2';
            final char OPEN_MNEMONIC = '3';
            final char EXIT_MNEMONIC = '4';

            // Needed to bind hotkeys
            final char LOGIN_BUTTON_MNEMONIC = KeyEvent.VK_L;
            final String WINDOW_TITLE = "Text Editor";
            final String ENTER_TEXT_LABEL = "Enter Text";
            final String SAVE_BUTTON_TEXT = "Save";
            final String OPEN_BUTTON_TEXT = "Open";
            final String EXIT_BUTTON_TEXT = "Exit";

            // To help the user understand what various buttons do
            final String ENTER_TOOLTIP = "Press to enter the text typed in to the field";
            final String EXIT_TOOLTIP = "Leaves and closes the window";
            final String SAVE_TOOLTIP = "Saves the changes made to the currently opened text file";
            final String OPEN_TOOLTIP = "Opens a new file to edit";
            final String USER_ENTRY_ERROR = "Please enter some text";
            final boolean ERROR_TYPE = true;  // true for dialog, false for label

            // All the basic window stats
            window = new JFrame();
            window.setTitle(WINDOW_TITLE);
            window.setSize(480, 220);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLocationRelativeTo(null);
            window.setLayout(null);
            window.setResizable(false);

            // A label to show where to enter the text
            JLabel textLabel = new JLabel(ENTER_TEXT_LABEL);
            textLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            textArea = new JTextArea("Enter Your Text Here Please: ", 1, 3);

            // For if the user doesn't enter anything
            JLabel errorMessage = new JLabel("");

            // Adding our buttons
            JButton saveButton = new JButton(SAVE_BUTTON_TEXT);
            JButton exitButton = new JButton(EXIT_BUTTON_TEXT);
            JButton openButton = new JButton(OPEN_BUTTON_TEXT);
            JButton enterButton = new JButton(ENTER_TEXT_LABEL);

            // Needed to help us open a new file
            JFileChooser newFile = new JFileChooser();

            // Just in case the user doesn't give us any text
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent click) {

                    // The getLineCount function is used to see how many lines are present in the text box
                    if (textArea.getLineCount() == 0) {
                        errorMessage.setText(USER_ENTRY_ERROR);
                    }
                }
            });

            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent click) {
                    // Opens to current directory
                    JFileChooser openFile = new JFileChooser();
                }
            });

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent click) {
                    // Save
                    int save = newFile.showSaveDialog(null);
                }
            });

            // Closes the window when pressed
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent click) {
                    window.dispose();
                }
            });

            // Set the position and size of all the controls on the window
            textLabel.setBounds(50, 50, 100, 30 );
            textArea.setBounds(50, 150, 100, 30);
            enterButton.setBounds(200, 50, 100, 30);
            saveButton.setBounds(200, 150, 100, 30);
            openButton.setBounds(200, 200, 100, 30);
            exitButton.setBounds(200, 250, 100, 30);
            errorMessage.setBounds(50, 150, 200, 30);

            // Add all the controls to the window
            window.add(textLabel);
            window.add(textArea);
            window.add(errorMessage);
            window.add(enterButton);
            window.add(saveButton);
            window.add(openButton);
            window.add(exitButton);

            // Establish the tab order through all controls that can have focus
            textArea.setNextFocusableComponent(enterButton);
            enterButton.setNextFocusableComponent(saveButton);
            saveButton.setNextFocusableComponent(openButton);
            openButton.setNextFocusableComponent(exitButton);

            // Establish the tooltips for all controls that can have focus
            enterButton.setToolTipText(ENTER_TOOLTIP);
            saveButton.setToolTipText(SAVE_TOOLTIP);
            openButton.setToolTipText(OPEN_TOOLTIP);
            exitButton.setToolTipText(EXIT_TOOLTIP);
        }

        public void show() {
            // Opens the window and makes it visible
            window.setVisible(true);
        }


}
