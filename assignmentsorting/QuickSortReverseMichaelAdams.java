
import java.util.Scanner;

public class QuickSortReverseMichaelAdams {
  public static void quickSort(int[] inputs) {
    quickSort(inputs, 0, inputs.length - 1);
  }


  private static void quickSort(int[] inputs, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(inputs, first, last);
      quickSort(inputs, first, pivotIndex - 1);
      quickSort(inputs, pivotIndex + 1, last);
    }
  }

  /** Partition the array inputs[first..last] */
  private static int partition(int[] inputs, int first, int last) {
    int pivot = inputs[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && inputs[low] >= pivot)
        low++;

      // Search backward from right
      while (low <= high && inputs[high] < pivot)
        high--;

      // Swap two elements in the inputs
      if (high > low) {
        int temp = inputs[high];
        inputs[high] = inputs[low];
        inputs[low] = temp;
      }
    }

    while (high > first && inputs[high] <= pivot)
      high--;

    // Swap pivot with inputs[high]
    if (pivot < inputs[high]) {
      inputs[first] = inputs[high];
      inputs[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String toContinue = "Y";
    while (!toContinue.equals("N")) {
      System.out.println("How many integer numbers do you have?:");
      int numberOfInputs = input.nextInt();
      int inputs[] = new int[numberOfInputs];
      System.out.println("Enter " + numberOfInputs + " integer numbers:");
      for (int i = 0; i < numberOfInputs; i++) {
        inputs[i] = input.nextInt();
      }
      System.out.println("------------------------------------------------------");
      System.out.println("Inputs array before sorting (quick):  ");
      for (int i = 0; i < numberOfInputs; i++) {
        if (i != numberOfInputs - 1) {
          System.out.print(inputs[i] + ", ");
        } else {
          System.out.print(inputs[i]);
        }
      }
      System.out.println("");
      quickSort(inputs);
      System.out.println("Inputs array after sorting (quick):  ");
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
