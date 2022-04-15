// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	Assignment Sorting Part 2
// IDE: 			Visual Studio Code 1.66.2
import java.util.Scanner;

public class RadixSortMichaelAdams {

  // Extracts the digit at the specified position
  public static int ExtractDigit(int digit, int position) {
    int result = 1;
    for (int i = 0; i <= position; i++) {
      result *= 10;
    }
    return (digit / result) % 10;
  }

  // Finds the number of digits in a given integer
  public static int DigitCount(int digit) {
    int count = 0;
    while (digit != 0) {
      digit /= 10;
      ++count;
    }
    return count;
  }

  // Radix sort method using queue buckets
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Continue program until user enters "N"
    String toContinue = "Y";
    while (!toContinue.equals("N")) {

      // Ask user for number of ints
      System.out.println("How many integer numbers do you have?:");
      int numberOfInputs = input.nextInt();
      int inputs[] = new int[numberOfInputs];
      // Ask user to enter integer numbers
      System.out.println("Enter " + numberOfInputs + " integer numbers:");
      // Loop to add user-inputted integers to array
      for (int i = 0; i < numberOfInputs; i++) {
        inputs[i] = input.nextInt();
      }

      // Print integers before sorting
      System.out.println("------------------------------------------------------");
      System.out.println("Inputs array before sorting (radix):  ");
      for (int i = 0; i < numberOfInputs; i++) {
        if (i != numberOfInputs - 1) {
          System.out.print(inputs[i] + ", ");
        } else {
          System.out.print(inputs[i]);
        }
      }
      System.out.println("");

      // Get largest number
      int maxDigits = 0;
      for (int i = 0; i < numberOfInputs; i++) {
        int currentDigitCount = DigitCount(inputs[i]);
        if (currentDigitCount > maxDigits) {
          maxDigits = currentDigitCount;
        }
      }

      // Create queue buckets
      Queue bucket0 = new Queue<>();
      Queue bucket1 = new Queue<>();
      Queue bucket2 = new Queue<>();
      Queue bucket3 = new Queue<>();
      Queue bucket4 = new Queue<>();
      Queue bucket5 = new Queue<>();
      Queue bucket6 = new Queue<>();
      Queue bucket7 = new Queue<>();
      Queue bucket8 = new Queue<>();
      Queue bucket9 = new Queue<>();

      // Sort list digits into buckets
      for (int i = 0; i < maxDigits; i++) {
        // i is current digit, j is location in list
        for (int j = 0; j < numberOfInputs; j++) {
          int currentDigit = ExtractDigit(inputs[j], i);
          switch (currentDigit) {
            case 0:
              bucket0.enqueue(inputs[j]);
              break;
            case 1:
              bucket1.enqueue(inputs[j]);
              break;
            case 2:
              bucket2.enqueue(inputs[j]);
              break;
            case 3:
              bucket3.enqueue(inputs[j]);
              break;
            case 4:
              bucket4.enqueue(inputs[j]);
              break;
            case 5:
              bucket5.enqueue(inputs[j]);
              break;
            case 6:
              bucket6.enqueue(inputs[j]);
              break;
            case 7:
              bucket7.enqueue(inputs[j]);
              break;
            case 8:
              bucket8.enqueue(inputs[j]);
              break;
            case 9:
              bucket9.enqueue(inputs[j]);
              break;
            default:
              break;
          }
        }

        // empty buckets
        int count = 0;
        for (int k = 0; k <= 9; k++) {
          while (!bucket0.isEmpty()) {
            inputs[count] = ((int) bucket0.dequeue());
            count++;
          }
          while (!bucket1.isEmpty()) {
            inputs[count] = ((int) bucket1.dequeue());
            count++;
          }
          while (!bucket2.isEmpty()) {
            inputs[count] = ((int) bucket2.dequeue());
            count++;
          }
          while (!bucket3.isEmpty()) {
            inputs[count] = ((int) bucket3.dequeue());
            count++;
          }
          while (!bucket4.isEmpty()) {
            inputs[count] = ((int) bucket4.dequeue());
            count++;
          }
          while (!bucket5.isEmpty()) {
            inputs[count] = ((int) bucket5.dequeue());
            count++;
          }
          while (!bucket6.isEmpty()) {
            inputs[count] = ((int) bucket6.dequeue());
            count++;
          }
          while (!bucket7.isEmpty()) {
            inputs[count] = ((int) bucket7.dequeue());
            count++;
          }
          while (!bucket8.isEmpty()) {
            inputs[count] = ((int) bucket8.dequeue());
            count++;
          }
          while (!bucket9.isEmpty()) {
            inputs[count] = ((int) bucket9.dequeue());
            count++;
          }
        }

      }

      // Print sorted integers
      System.out.println("Inputs array after sorting (radix):  ");
      for (int i = 0; i < numberOfInputs; i++) {
        if (i != numberOfInputs - 1) {
          System.out.print(inputs[i] + ", ");
        } else {
          System.out.print(inputs[i]);
        }
      }

      // Ask to run again
      System.out.println("");
      System.out.println("Do you want to continue? (Y/N):");
      toContinue = input.next();
    }
    input.close();
  }

}
