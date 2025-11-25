// Title: temperatureCollector
// Name: Ibrahim Khan
// Date: February 6, 2025

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, this program calculates the average temperature in the first quarter of a year");

        // To store the temperatures
        float[] temp;
        temp = temp1("Please give the temperature for Jan 1, Jan 2 and Jan 3");

        // Temperature for the rest of the days
        float[] restTemp = new float[88];
        for (int i = 0; i < restTemp.length; i++){
            restTemp[i] = (float) (Math.random() * 30) - 10;
        }

        // This is where we will add all the temperatures
        float avg = 0;
        for (int i = 0; i < temp.length; i++){
            avg = avg + temp[i];
        }
        for (int i = 0; i < restTemp.length; i++){
            avg = avg + restTemp[i];
        }

        float completeAvg = avg / 91;
        System.out.println(String.format("This years quarter has an average of: %.2f", completeAvg));
    }

    public static float[] temp1(String prompt){
        // To turn end the function when we have what we need
        boolean needTemp = true;

        float validTemp = 0;
        // To count how many days we got and make sure its 3
        int janCounter = 0;

        while (needTemp && janCounter < 3){
            // To track the temperatures being returned (local version)
            float[] temp = {0, 0, 0};

            System.out.print(prompt);
            Scanner input = new Scanner(System.in);

            // To make sure we get 3 days
            if (janCounter == 3){
                needTemp = false;
            }
            else {
                if (input.hasNextFloat()) {
                    validTemp = input.nextFloat();
                    temp[janCounter] = validTemp;
                    // Increases as it doubles as a tracker for what indexes have been filled
                    janCounter++;
                } else {
                    // Need to tell the use what is wrong with their input
                    System.out.println("Please give an float: ");
                }
            }
        }

        return temp1(String.valueOf(validTemp));
    }
}
