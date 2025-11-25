import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun"};
        int[] temps = new int[7];
        float tempTotal = 0;
        for (int i = 0; i < temps.length; i++){
            String prompt = "Enter the temp for " + names[i] + ":";
            temps[i] = getValidInteger(prompt, -20, 20);
            tempTotal = tempTotal + temps[i];
        }
        float avgTemp = tempTotal / temps.length;

        for (int i = 0; i < temps.length; i++){
            System.out.println(String.format("%s: %d", names[i], temps[i]));
        }
        System.out.println(String.format("Weekly average: %.2f", avgTemp));
    }

    // Forgot to implement system for checking min and max
    private static int getValidInteger(String prompt, int Minimum, int Maximum) {
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
}
