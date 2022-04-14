import java.lang.invoke.ClassSpecializer.Factory;
import java.util.Scanner;
public class RadixSortMichaelAdams {

    public static int ExtractDigit(int digit, int position) {
        for (int i=0; i <=position; i++) {
            if (i < position) {
                digit = digit / 10;
            } else {
                return digit % 10;
            }
        }
        return digit % 10;
    }

    public static int DigitCount(int digit) {
        int count = 0;
        while (digit != 0) {
            digit /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String toContinue = "Y";
        while (!toContinue.equals("N")) {
        System.out.println("How many integer numbers do you have?:");
        int numberOfInputs = input.nextInt();
        int inputs[] = new int[numberOfInputs];
        System.out.println("Enter " + numberOfInputs + " integer numbers:");
        for(int i = 0; i < numberOfInputs; i++) {
            inputs[i] = input.nextInt();
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Inputs array before sorting (radix):  ");
        for(int i = 0; i < numberOfInputs; i++) {
          if (i != numberOfInputs - 1) {
            System.out.print(inputs[i] + ", ");
          } else {
            System.out.print(inputs[i]);
          }
        }
      System.out.println("");
        
      // Queue buckets
      Queue[] buckets = new Queue[10];
      for (int i=0; i<=9; i++) {
          buckets[i] = new Queue<Integer>();
      }

      Boolean sorted = false;
      while (sorted == false) {
          
      }

        System.out.println("Inputs array after sorting (radix):  ");
        for(int i = 0; i < numberOfInputs; i++) {
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
