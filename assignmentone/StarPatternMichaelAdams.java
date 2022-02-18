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
        String tryAgain;
        do {

            // Ask and receive number of rows
            System.out.println("Enter Number of Rows:");
            int numberOfRows = input.nextInt();

            // Call printRows method, which itself calls printStars method
            printStars(numberOfRows, numberOfRows);

            // Ask user if they want to enter more grades
            System.out.println("Try Again? (Y/N):\t\t\t");
            tryAgain = input.next();
        } while (tryAgain.equalsIgnoreCase("Y"));

        input.close();
    }

    // Prints each row
    public static void printRows(int numberOfRows) {
        // base case
        if (numberOfRows < 1) {
            return;
        }

        // prints stars
        System.out.print("* ");

        // recursively calls itself
        printRows(numberOfRows - 1);
    }

    // Prints the stars
    public static void printStars(int numberOfRows, int number) {
        // base case
        if (numberOfRows < 1) {
            return;
        }

        printSpaces(numberOfRows - 1);
        printRows(number - numberOfRows + 1);
        System.out.println();

        // recursively calls itself
        printStars(numberOfRows - 1, number);
    }

    // prints the spaces
    public static void printSpaces(int numberOfRows) {
        // base case
        if (numberOfRows == 0)
            return;
        System.out.print(" ");

        // recursively calls itself
        printSpaces(numberOfRows - 1);
    }
}
