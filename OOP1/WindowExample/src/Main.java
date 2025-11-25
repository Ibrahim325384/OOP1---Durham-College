// Name: Ibrahim Khan
// Date: March 18, 2024
// Description: An example of how to make a window with the Swing library in Java

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Establish the window environment
        JFrame frame = new JFrame("My First Swing App");
        frame.setSize(400, 300);
        // Window will exit when closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Construct the controls for the window
        JButton button = new JButton("Click Me");
        // Add control to the window
        frame.getContentPane().add(button);
        // Start the window
        frame.setVisible(true);

        // Above code is making a window without a class
        // The below code is what is put in main when you do make it in a class

        MyWindow w = new MyWindow();
        w.show();
    }
}