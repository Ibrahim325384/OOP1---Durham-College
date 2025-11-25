// Name: Ibrahim Khan
// Date: April 10, 2025
// Desc: Program creates GUI with an encryption program

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import java.util.Arrays;

public class TextWindow {
    private JFrame window;

    public TextWindow(){
        window = new JFrame();
        window.setTitle("Encryption / Decryption");
        window.setSize(400, 300);
        // Window will exit when closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // To inform the user what the program does
        JLabel lblGreeting = new JLabel("This program encrypts or decrypts text");
        lblGreeting.setBounds(15,5,150,30);
        window.add(lblGreeting);

        JTextArea message = new JTextArea("Enter the text you would like to encrypt / decrypt here: ");
        String input = message.getText();
        message.setBounds(75, 50, 150, 90);
        message.setToolTipText("Enter the text you would like to encrypt here");

        JTextArea result = new JTextArea();
        result.setBounds(30, 25, 150, 90);
        String newWord = result.getText();
        result.setToolTipText("The result of the encryption / decryption: ");

        JTextArea shiftNum = new JTextArea("Enter your shift number here: ");
        String shift = shiftNum.getText();
        shiftNum.setBounds(50, 75, 150, 90);
        shiftNum.setToolTipText("The number by which the letters shall move in the cipher");

        JTextArea complexityKey = new JTextArea("Enter the complexity key here: ");
        complexityKey.setBounds(25, 100, 150, 90);
        complexityKey.setToolTipText("The key of how complex the cipher is");

        // To allow the user to close the window
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(235, 60,110, 40);
        btnExit.setMnemonic(KeyEvent.VK_X);
        btnExit.setToolTipText("Exits the application");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application by closing the window
                window.dispose();
            }
        });

        // The button for encryption
        JButton Encrypt = new JButton("Decrypt");
        Encrypt.setBounds(225, 50, 100, 30);
        Encrypt.setMnemonic(KeyEvent.VK_0);
        Encrypt.setToolTipText("Encrypts text plain text to hide its meaning");
        Encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                // Calls on a function to encrypt text when clicked on
                encrypt(input, shift, newWord);
            }
        });

        // The button for decryption
        JButton Decrypt = new JButton("Decrypt");
        Decrypt.setBounds(225, 150, 100, 30);
        Decrypt.setMnemonic(KeyEvent.VK_1);
        Decrypt.setToolTipText("Decrypts text that has been encrypted");
        Decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent click) {
                // Calls on a function to encrypt text when clicked on
                decrypt(input, shift, newWord);
            }
        });

        // Making sure that all the buttons are added to the window
        window.add(message);
        window.add(result);
        window.add(shiftNum);
        window.add(complexityKey);
        window.add(btnExit);
        window.add(Encrypt);
        window.add(Decrypt);
    }
    // Allows the user to see the window
    public void show(){
        window.setVisible(true);
    }

    public static String encrypt(String input, String shift, String newWord){
        String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int newShift = 0;

        // To make sure shift is a number and turn it into a string if so
        for (int i = 0; i <= stringList.length; i++) {
            if (!shift.equalsIgnoreCase(stringList[i])) {
                newShift = Integer.parseInt(shift);
            }
            else {
                System.out.println("Give me a number please");
            }
        }
        // Encryption code borrowed from assignment 2
        String[] wordBuild = input.split("");
        for (int i = 0; i < wordBuild.length; i++){
            if (wordBuild[i] == stringList[i]){
                // To force the shift to go to the beginning of the array for the remainder of the shift number when
                // the shift number forces it to go over length, example if the letter is y and the shift is 3
                if (stringList[i + newShift].length() > stringList.length){
                    int leftOverShift = stringList[i + newShift].length() - stringList.length;
                    wordBuild[i] = stringList[leftOverShift];
                }
                else {
                    wordBuild[i] = stringList[i + newShift];
                }
            }
        }
        newWord = input;
        System.out.println(newWord);
        return newWord;
    }

    public static String decrypt(String input, String shift, String newWord){
        String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int newShift = 0;

        // To make sure shift is a number and turn it into a string if so
        for (int i = 0; i <= stringList.length; i++) {
            if (!shift.equalsIgnoreCase(stringList[i])) {
                newShift = Integer.parseInt(shift);
            }
            else {
                System.out.println("Give me a number please");
            }
        }
        // Decryption code borrowed from assignment 2
        String[] wordBuild = input.split("");
        for (int i = 0; i < wordBuild.length; i++){
            if (wordBuild[i] == stringList[i]){
                // To force the shift to go to the beginning of the array for the remainder of the shift number when
                // the shift number forces it to go over length, example if the letter is y and the shift is 3
                if (stringList[i - newShift].length() < 0){
                    int leftOverShift = stringList[i + newShift].length() - stringList.length;
                    // .valueOf is needed because stringList is a list of strings
                    wordBuild[i] = String.valueOf(stringList.length - leftOverShift);
                }
                else {
                    wordBuild[i] = stringList[i - newShift];
                }
            }
        }
        newWord = input;
        System.out.println(newWord);
        return newWord;
    }
}


