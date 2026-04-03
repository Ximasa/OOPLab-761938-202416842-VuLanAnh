package Lab01;
import java.util.Scanner;
public class DisplayNumberOfDays{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String strMonth;
        int year = -1;
        int days = -1;

        while (true) {
            System.out.print("Enter month: ");
            strMonth = keyboard.nextLine().toLowerCase();
            System.out.print("Enter year: ");
            String strYear = keyboard.nextLine();

            if (strYear.matches("\\d+") && strYear.length() >= 4) {
                year = Integer.parseInt(strYear);
            } else {
                System.out.println("Invalid year. Year must be a non-negative number with all digits (e.g., 1999).");
                continue;
            }

            days = getDays(strMonth, year);
            if (days != -1) {
                System.out.println("Number of days: " + days);
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }
        System.exit(0);
    }

    public static int getDays(String m, int y) {
        if (m.matches("january|jan\\.|jan|1|march|mar\\.|mar|3|may|may\\.|5|july|jul\\.|jul|7|august|aug\\.|aug|8|october|oct\\.|oct|10|december|dec\\.|dec|12"))
            return 31;
        if (m.matches("april|apr\\.|apr|4|june|jun|jun\\.|6|september|sept\\.|sept|sep\\.|sep|9|november|nov\\.|nov|11"))
            return 30;
        if (m.matches("february|feb\\.|feb|2")) {
            if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                return 29; // Leap year [cite: 801, 803]
            } else {
                return 28; // Common year [cite: 801, 803]
            }
        }
        return -1;
    }
}