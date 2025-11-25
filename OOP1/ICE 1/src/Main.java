// Name: Ibrahim Khan
// Date: 1/24/2025
// Description: Shows logic constructs

// Needed to get user input
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome! \n");
        System.out.print("This program will determine if you are old enough to buy beer \n");

        int age = 0;
        age = GetValidInt("Please enter your age: ");

        System.out.printf("You are %d years old. \n", age);

        // We need to see if age is over 18, to see if they can buy beer
        if (age > 18){
            System.out.print("You are old enough to buy beer");
        }
        else{
            System.out.print("You aren't old enough to buy beer");
        }
    }
    // Prompt refers to GetValidInt on line 15
    public static int GetValidInt(String prompt){
        // To help with exiting the loop when we have an int
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
                // Need to tell the use what is wrong with their input
                System.out.println("Please give an integer: ");
            }
        }
        return value;
    }
}
