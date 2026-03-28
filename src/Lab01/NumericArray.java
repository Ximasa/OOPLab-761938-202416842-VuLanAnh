package Lab01;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class NumericArray{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of array elements: ");
        int n = keyboard.nextInt();
        double[] array = new double[n];

        System.out.println("Choose data input method:");
        System.out.println("1. Manual input");
        System.out.println("2. Machine generates random values (constant)");
        System.out.print("Please enter your choice: ");
        int choice = keyboard.nextInt();

        if (choice == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element [" + i + "]: ");
                array[i] = keyboard.nextDouble();
            }
        } else {
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                array[i] = Math.round(rand.nextDouble() * 100.0 * 10.0) / 10.0;
            }
            System.out.println("Randomly generated array: " + Arrays.toString(array));
        }

        Arrays.sort(array);
        double sum = 0;
        for (double x : array) {
            sum += x;
        }
        double average = sum / n;

        System.out.println("Result:");
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Sum: " + sum);
        System.out.println("Average value: " + average);

        System.exit(0);
    }
}