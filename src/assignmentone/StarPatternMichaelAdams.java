package assignmentone;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.63.2

import java.util.Scanner;
public class StarPatternMichaelAdams {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Will continue looping program until user enters "N"
        String tryAgain = "";
        do {

            // Ask and receive number of rows
            System.out.println("Enter Number of Rows:");
            int numberOfRows = input.nextInt();

            // Call printRows method, which itself calls printStars method
            printStars(numberOfRows);

            // Ask user if they want to enter more grades
            System.out.println("Try Again? (Y/N):\t\t\t");
            tryAgain = input.next();
        } while (tryAgain.equalsIgnoreCase("Y"));

        input.close();
    }
    // Prints the spaces
    public static void printSpaces(int numberOfRows) {
        if (numberOfRows < 1) {
            return;
        }
        System.out.print(" ");
        printSpaces(numberOfRows - 1);
    }

    // Prints each row
    public static void printRow(int numberOfRows) {
        if (numberOfRows < 1) {
            return;
        }
        System.out.print("*");
        printRow(numberOfRows - 1);
    }

    public static void printStars(int numberOfRows) {
        int currentRow = 0;
        // Prints pattern
        if (numberOfRows < 1) {
            return;
        }
        printSpaces(numberOfRows);
        printRow(numberOfRows);
        System.out.println();
        printStars(currentRow++);
    }
}
