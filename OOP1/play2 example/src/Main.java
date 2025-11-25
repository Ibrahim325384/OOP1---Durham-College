// Title: Play
// Name: Ibrahim Khan
// Date: February 4, 2024
public class Main {
    public static void main(String[] args) {

        // All these work but the 2nd is best
        double graded[] = {34.5, 56, 8};
        double[] grades = {67.8, 78.9,23,6};
        // Uninitialized
        double[] grade = new double[3];

        // Iterating backwards
        for (int i = grade.length - 1; i > 0; i--) {
            grade[i] = graded[i];
        }
        graded[0] = 0;

        // Grade[0] will not be changes despite the above line
        for (double g: grade){
            System.out.println(g);
        }
    }
}