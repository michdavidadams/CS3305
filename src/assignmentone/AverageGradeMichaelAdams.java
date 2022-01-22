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
            for (int i = classSize - 1; i >= 0; i--) {
                grades[i] = input.nextDouble();
            }

            // Call findAverage method
            Double average = findAverage(grades);

            // Print everything
            System.out.println("Class size:\t\t" + classSize + "\nEntered grades:\t\t" + grades.toString() + "\nClass average:\t\t" + average);


            // Ask user if they want to enter more grades
            System.out.println("Enter more grades (Y/N):\t\t\t");
            enterMoreGrades = input.next();
        } while (enterMoreGrades.equalsIgnoreCase("Y"));

        input.close();
    }

    public static Double findAverage(double[] grades) {
        if (grades.length == 0) {
            return 0.0;
        }

        double grade = grades[0];

        if (grades.length == 1) {
            return grade;
        }

        double[] tempGrades = new double[grades.length - 1];
        System.arraycopy(grades, 1, tempGrades, 0, tempGrades.length);
        return (grade + findAverage(tempGrades) * tempGrades.length) / grades.length;

    }
}
