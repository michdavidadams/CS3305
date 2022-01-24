package assignmentone;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	1
// IDE: 			IntelliJ IDEA 2021.3.1

import java.util.Scanner;
public class PrintReverseMichaelAdams {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Will continue looping program until user enters "N"
        String tryAgain;
        do {

            // Print string prompt
            System.out.println("Enter a string.");

            // User inputs string
            String str = input.nextLine();
            // Outputs user entered string
            System.out.println("Entered string:\t\t\t\t" + str);

            // Reverse string
            String strReversed = printCharsReverse(str);
            // Print reversed string
            System.out.println("Reversed string:\t\t\t" + strReversed);

            // Ask user to try again
            System.out.println("Try again (Y/N):\t\t\t");
            tryAgain = input.nextLine();
        } while(tryAgain.equalsIgnoreCase("Y"));

        input.close();
    }

    // Print Characters Reversed method
    public static String printCharsReverse(String str) {

        // base case, if string is empty then return the string because it cannot be reversed
        if (str.isEmpty()) {
            return str;
        }

        // returns a substring with the string's first character to the printCharsReverse() method
        return printCharsReverse(str.substring(1)) + str.charAt(0);
    }
}
