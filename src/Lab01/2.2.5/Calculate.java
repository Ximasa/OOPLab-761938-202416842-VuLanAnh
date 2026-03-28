import javax.swing.JOptionPane;
public class Calculate{
    public static void main(String[] args){
        String strnum1, strnum2;
        String strNotification1 = "Sum: ";
        String strNotification2 = "Difference: ";
        String strNotification3 = "Product: ";
        String strNotification4 = "Quotient: ";

        strnum1 = JOptionPane.showInputDialog(null, 
            "Please input the first double number: ", 
            "Input the first double number", JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, 
            "Please input the second double number: ",
            "Input the second double number", JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strnum1);
        double num2 = Double.parseDouble(strnum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        JOptionPane.showMessageDialog(null, strNotification1 + sum + "\n" +
            strNotification2 + difference + "\n" + strNotification3 + product + "\n" +
            strNotification4 + quotient + "\n", "Results", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
    }
}