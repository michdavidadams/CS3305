package assignmentone;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	2
// IDE: 			Visual Studio Code 1.63.2

import java.util.Scanner;
public class AverageGradeMichaelAdams {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Will continue looping program until user enters "N"
        String enterMoreGrades = "";
        do {

            // Ask and receive class size
            System.out.println("What is the class size?");
            int classSize = input.nextInt();

            // Ask and receive grades
            System.out.println("Enter grades.");
            double[] grades = new double[classSize];
            // Loop for grades; only receive the number of grades per class size
            for (int i = classSize - 1; i >= 0; i--) {
                grades[i] = input.nextDouble();
            }

            // Call findAverage method
            Double average = findAverage(grades);

            // Print everything
            System.out.println("Class size:\t\t\t" + classSize + "\nEntered grades:\t\t\t" + grades.toString() + "\nClass average:\t\t\t" + average);


            // Ask user if they want to enter more grades
            System.out.println("Enter more grades (Y/N):\t\t\t");
            enterMoreGrades = input.next();
        } while (enterMoreGrades.equalsIgnoreCase("Y"));

        input.close();
    }

    // Find Average method
    public static Double findAverage(double[] grades) {

        // Base case, if grades array is 0
        if (grades.length == 0) {
            return 0.0;
        }

        // Double to hold first grade from grades
        double grade = grades[0];

        // If there is only 1 grade, that is the average
        if (grades.length == 1) {
            return grade;
        }

        // temporary array to hold grades, with length of 1 less than grades
        double[] tempGrades = new double[grades.length - 1];
        // Copies grades array into tempGrades array
        System.arraycopy(grades, 1, tempGrades, 0, tempGrades.length);
        // returns average grade
        return (grade + findAverage(tempGrades) * tempGrades.length) / grades.length;

    }
}
