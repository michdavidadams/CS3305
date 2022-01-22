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
        String tryAgain = "";
        do {

            // Print string prompt
            System.out.println("Enter a string.");

            // User inputs string
            String str = input.next();
            // Outputs user entered string
            System.out.println("Entered string:\t\t\t" + str);

            // Reverse string
            String strReversed = printCharsReverse(str);
            // Print reversed string
            System.out.println("Reversed string:\t\t\t" + strReversed);

            // Ask user to try again
            System.out.println("Try again (Y/N):\t\t\t");
            tryAgain = input.next();
        } while(tryAgain.equalsIgnoreCase("Y"));

        input.close();
    }


    public static String printCharsReverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return printCharsReverse(str.substring(1)) + str.charAt(0);
    }
}
