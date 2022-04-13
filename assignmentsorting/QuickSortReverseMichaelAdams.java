
import java.util.Scanner;
public class QuickSortReverseMichaelAdams {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many integer numbers do you have?:");
        int numberOfInputs = input.nextInt();
        int inputs[] = new int[numberOfInputs];
        System.out.println("Enter " + numberOfInputs + " integer numbers:");
        for(int i = 0; i < numberOfInputs; i++) {
            inputs[i] = input.nextInt();
        }

        input.close();
    }
}
