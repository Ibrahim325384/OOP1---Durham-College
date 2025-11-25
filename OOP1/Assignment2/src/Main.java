// Title: Assignment 2
// Name: Ibrahim Khan
// Date: February 11, 2024
// Description: Program takes text from user nad encrypts / decrypts it

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, this program will decipher or encrypt text based on your desire");

        // To make sure when user is choosing whether to encrypt or decrypt thy put in an integer
        int userChoice = 0;
        userChoice = GetValidInt("Please enter 1 to decrypt, or 2 to encrypt: ");

        // Will be used later for holding the text to be encrypted / decrypted and the shift number for the translation cipher
        String text = "";
        int shift = 0;

        // To help the program what to do based on the user's choice
        if (userChoice == 1){
            // userChoice is reset to 0, so we can reuse GetValidInt with a different prompt, this is also done in the else if
            text = getValidText("Please enter the text you would like to decrypt: ");
            userChoice = 0;
            userChoice = GetValidInt("Please enter 1 or 2 based on the cipher used to encrypt this text, 1 - substitution, 2 - translation");
            if (userChoice == 1){
                text = getValidText("Please enter the text you would like to decrypt: ");
                String[] unscrambledText = text.split("");
                for (int i = 0; i < unscrambledText.length; i++){
                    
                    // These are to compare with each other and put the corresponding letter in the scrambled word
                    String[] scramble = {"Y", "W", "L", "R", "A", "S", "K", "T", "E", "Z", "G", "M", "V", "H", "Q", "B", "X", "N", "C", "D", "I", "J", "F", "U", "O", "P"};
                    String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                    for (i = 0; i < stringList.length; i++){
                        if (unscrambledText[i].equalsIgnoreCase(scramble[i])){
                            unscrambledText[i] = stringList[i];
                        }
                    }
                }// Converts the substring array to a string so that it can be printed 
                System.out.println("The decrypted text is: " + Arrays.toString(unscrambledText));

            } else if (userChoice == 2) {
                text = getValidText("Please enter the text you would like to decrypt: ");
                String[] scrambledText = text.split("");
                shift = GetValidShift("Please enter the shift number for this decryption: ");
                String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                String[] wordBuild = text.split("");
                for (int i = 0; i < wordBuild.length; i++){
                    if (wordBuild[i] == stringList[i]){
                        // To force the shift to go to the beginning of the array for the remainder of the shift number when
                        // the shift number forces it to go over length, example if the letter is y and the shift is 3
                        if (stringList[i - shift].length() < 0){
                            int leftOverShift = stringList[i + shift].length() - stringList.length;
                            // .valueOf is needed because stringList is a list of strings
                            wordBuild[i] = String.valueOf(stringList.length - leftOverShift);
                        }
                        else {
                            wordBuild[i] = stringList[i - shift];
                        }
                    }
                }
                System.out.println("The decrypted text is: " + Arrays.toString(wordBuild));

            }
        } else if (userChoice == 2) {
            userChoice = 0;
            userChoice = GetValidInt("To decide how your text shall be encrypted, press 1 to use a substitution cipher or 2 to use a translation cipher: ");
            if (userChoice == 1){
                text = getValidText("Please enter the text you would like to encrypt: ");
                // The word is turned into a substring so that we can modify  it
                String[] scrambledText = text.split("");
                for (int i = 0; i < scrambledText.length; i++){
                    // These are to compare with each other and put the corresponding letter in the scrambled word
                    String[] scramble = {"Y", "W", "L", "R", "A", "S", "K", "T", "E", "Z", "G", "M", "V", "H", "Q", "B", "X", "N", "C", "D", "I", "J", "F", "U", "O", "P"};
                    String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                    if (scrambledText[i].equalsIgnoreCase(stringList[i])){
                        scrambledText[i] = scramble[i];
                    }
                }
                System.out.println("The encrypted text is: " + Arrays.toString(scrambledText));

            } else if (userChoice == 2) {
                text = getValidText("Please enter the text you would like to encrypt: ");
                String[] scrambledText = text.split("");
                shift = GetValidShift("Please enter the shift number for this encryption: ");
                String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
                String[] wordBuild = text.split("");
                for (int i = 0; i < wordBuild.length; i++){
                    if (wordBuild[i] == stringList[i]){
                        // To force the shift to go to the beginning of the array for the remainder of the shift number when
                        // the shift number forces it to go over length, example if the letter is y and the shift is 3
                        if (stringList[i + shift].length() > stringList.length){
                            int leftOverShift = stringList[i + shift].length() - stringList.length;
                            wordBuild[i] = stringList[leftOverShift];
                        }
                        else {
                            wordBuild[i] = stringList[i + shift];
                        }
                    }
                }
                System.out.println("The encrypted text is: " + Arrays.toString(wordBuild));
            }
        }
    }

    // The GetValidInt is modified from the original so that the user to select options and only permits the numbers 1 and 2, henceforth
    // I had to copy and paste original GetValidInt from the weeklyTemps to make sure the user enters a number for the shift number
    private static int GetValidShift(String prompt) {
        boolean needInteger = true;
        int value = 0;
        while (needInteger){
            System.out.print(prompt);
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()){
                value = input.nextInt();
                needInteger = false;
            }
            else{
                System.out.println("Please give an integer: ");
            }
        }
        return value;
    }


    private static String getValidText(String promptText) {
        // Maybe will use a loop (delete if so)
        boolean needString = true;
        // An array that will be compared with user input in order to see if it is a string, has both CAPS and non CAPS because .equals is case sensitivie
        String[] stringList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String value = "";
        while (needString){
            System.out.print(promptText);
            Scanner input = new Scanner(System.in);
            // For comparing with stringList and seeing if the user has entered a letter or not
            for (int i = 0; i < stringList.length; i++){
                if (input.equals(stringList[i])){
                    value = input.next();
                    needString = false;
                }
                else {
                    System.out.println("Please give a String that is a letter: ");
                }
            }
        }
        // Value was set to what the user entered and it is now being returned
        return value;
    }

    // A slightly altered version of getting a valid integer function that was demonstrated in class
    public static int GetValidInt(String prompt){
        // To help with exiting the loop when we have an int
        boolean needInteger = true;
        int value = 0;
        while (needInteger){
            System.out.print(prompt);
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()){
                // Since it is a number all that is left is to make sure that it is 1 or 2
                value = input.nextInt();
                if (value == 1 || value == 2){
                    needInteger = false;
                }
                else{
                    System.out.println("Please do not give a number besides 1 or 2: ");
                }
            }
            else{
                // Need to tell the user what is wrong with their input
                System.out.println("Please give an integer: ");
            }
        }
        return value;
    }
}