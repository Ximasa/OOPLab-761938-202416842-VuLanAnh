package Lab01;
import java.util.Scanner;
public class DisplayATriangle {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the height of the triangle (integer): ");
        int N = keyboard.nextInt();
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N-i; j++)
            {
                System.out.print(" ");
            }
            for(int k=1; k<=2*i-1; k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.exit(0);
    }
}
