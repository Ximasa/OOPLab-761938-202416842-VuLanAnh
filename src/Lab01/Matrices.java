package Lab01;
import java.util.Scanner;
import java.util.Random;
public class Matrices {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int r = keyboard.nextInt();
        System.out.print("Enter number of columns: ");
        int c = keyboard.nextInt();

        double[][] matrix1 = new double[r][c];
        double[][] matrix2 = new double[r][c];
        double[][] sum = new double[r][c];

        System.out.print("1. Manual input\n2. Random generate (Constants)\nChoose input method: ");
        int choice = keyboard.nextInt();
        if (choice == 1) {
            System.out.println("Enter Matrix 1:");
            fillMatrixManual(matrix1, keyboard);
            System.out.println("Enter Matrix 2:");
            fillMatrixManual(matrix2, keyboard);
        } else {
            fillMatrixRandom(matrix1);
            fillMatrixRandom(matrix2);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }


        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        System.out.println("Sum:");
        printMatrix(sum);

        System.exit(0);
    }

    public static void fillMatrixManual(double[][] matrix, Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextDouble();
            }
        }
    }

    public static void fillMatrixRandom(double[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Math.round(rand.nextDouble() * 100.0 * 10.0) / 10.0;
            }
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}