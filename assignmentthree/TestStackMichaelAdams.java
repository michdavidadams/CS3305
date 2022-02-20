package assignmentthree;
// Class:			Data Structures W01

// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

import java.util.Scanner;

public class TestStackMichaelAdams {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Holds sentinel value
        int userInput;

        do {
        System.out.println("-----MAIN MENU-----");
        System.out.println("0 - Exit Program");
        System.out.println("1 – Push");
        System.out.println("2 - Pop");
        System.out.println("3 – Peek (Top)");
        System.out.println("4 - Size");
        System.out.println("5 – Is Empty?");
        System.out.println("6 – Print Stack");
        System.out.println("Choose menu:");

        userInput = input.nextInt();

        } while(userInput != 0);

        input.close();
    }

}
