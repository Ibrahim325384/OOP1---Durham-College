// Title: Assignment 1
// Name: Ibrahim Khan
// Date: Jan 28, 2025
// Purpose: Program that calculates the users BMI
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Variables to be used in our calculations
        double weight = 0.0;
        double height = 0.0;
        double BMI = 0.0;

        System.out.print("Hello, this is a program that will calculate your BMI \n");

        weight = getWeight("Please enter your weight in pounds: ");
        height = getHeight("Please enter your height in squared inches: ");

        // Calculates BMI
        BMI = weight / height * 703;

        // Shows result
        System.out.println("You have a BMI of: " + BMI);

    }
    public static double getWeight(String prompt){

        // Used to keep user in the loop or leave it
        boolean needInput = true;
        double value = 0.0;
        while(needInput){
            System.out.print(prompt);
            Scanner input = new Scanner(System.in);
            if (input.hasNextDouble()){
               value = input.nextDouble();

               // To check if the value is equal to or over the minimum of 25 pounds
               if (value >= 25.00){
                  needInput = false;
               }
               else {
                   System.out.println("You must weigh a minimum of 25 pounds");
               }
            }
            else {
                // Tells the user what is wrong with their input
                System.out.println("Please give a decimal NUMBER");
            }
        }
        return value;
    }

    public static double getHeight(String prompt){

        // Used to keep user in the loop or leave it
        boolean needInput = true;
        double value = 0.0;
        while(needInput){
            System.out.print(prompt);
            Scanner input = new Scanner(System.in);
            if (input.hasNextDouble()){
                value = input.nextDouble();

                // To check if value is in the accepted range for the height
                if (value >= 24.00 && value <= 120){
                    needInput = false;
                }
                else {
                    System.out.println("You must have a height between 24 and 120 inches");
                }
            }
            else {
                // Informs the user of the issue with their input
                System.out.println("Please give a decimal NUMBER");
            }
        }
        return value;
    }
}