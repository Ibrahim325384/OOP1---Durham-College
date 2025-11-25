import java.util.Scanner;


public void main() {

}

private static String getValidCharacter(String promptText) {
    // Maybe will use a loop (delete if so)
    boolean needString = true;
    // An array that will be compared with user input in order to see if it is a string, has both CAPS and non CAPS because .equals is case sensitivie
    String[] stringList = {"y", String.valueOf('y'), "n", "N"};
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
