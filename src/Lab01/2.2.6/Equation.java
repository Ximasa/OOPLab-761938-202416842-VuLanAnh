import javax.swing.JOptionPane;
public class Equation{
    public static void main(String[] args)
    {
        String stra, strb;
        String stra11, stra12, stra21, stra22, strb1, strb2;
        String str_a, str_b, str_c;
        String strnum;
        strnum = JOptionPane.showInputDialog(null,
            "1. The first-degree equation (linear equation) with one variable.\n2. The system of first-degree equations (linear system) with two variables.\n3. The second-degree equation with one variable.\nPlease choose which equation you want to solve: ", "Choosing equation", JOptionPane.INFORMATION_MESSAGE);

        int num = Integer.parseInt(strnum);
        switch(num)
        {
            case 1: {
                stra = JOptionPane.showInputDialog(null,
                "ax+b=0\nEnter a: ", "ax+b=0", JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(stra);

                strb = JOptionPane.showInputDialog(null,
                "ax+b=0\nEnter b: ", "ax+b=0", JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(strb);

                if(a==0 && b==0){
                    JOptionPane.showMessageDialog(null, "Infinite solutions","Result", JOptionPane.INFORMATION_MESSAGE);  
                }              
                else if(a==0) {
                    JOptionPane.showMessageDialog(null, "No solution","Result", JOptionPane.INFORMATION_MESSAGE);     
                }           
                else{
                    double x =-b/a;
                    JOptionPane.showMessageDialog(null, "x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            case 2:{
                stra11 = JOptionPane.showInputDialog(null,
                "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\nEnter a11: ", "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
                double a11 = Double.parseDouble(stra11);

                stra12 = JOptionPane.showInputDialog(null,
                "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\nEnter a12: ", "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
                double a12 = Double.parseDouble(stra12);

                stra21 = JOptionPane.showInputDialog(null,
                "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\nEnter a21: ", "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
                double a21 = Double.parseDouble(stra21);

                stra22 = JOptionPane.showInputDialog(null,
                "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\nEnter a22: ", "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
                double a22 = Double.parseDouble(stra22);

                strb1 = JOptionPane.showInputDialog(null,
                "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\nEnter b1: ", "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
                double b1 = Double.parseDouble(strb1);

                strb2 = JOptionPane.showInputDialog(null,
                "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2\nEnter b2: ", "a11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
                double b2 = Double.parseDouble(strb2);

                double D = a11*a22 - a12*a21;
                double D1 = a22*b1 - a12*b2;
                double D2 = a11*b2 - a21*b1;

                if(D==0 && D1==0 && D2==0){
                    JOptionPane.showMessageDialog(null, "Infinite solutions","Result", JOptionPane.INFORMATION_MESSAGE);                
                } 
                else if(D==0){
                    JOptionPane.showMessageDialog(null, "No solution","Result", JOptionPane.INFORMATION_MESSAGE);  
                } 
                else{
                    double x1 = D1/D;
                    double x2 = D2/D;
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\n" + "x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            case 3: {
                str_a = JOptionPane.showInputDialog(null, 
                "ax^2 + bx + c = 0\nEnter a: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(str_a);

                str_b = JOptionPane.showInputDialog(null, 
                "ax^2 + bx + c = 0\nEnter b: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(str_b);

                str_c = JOptionPane.showInputDialog(null, 
                "ax^2 + bx + c = 0\nEnter c: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
                double c = Double.parseDouble(str_c);

                double delta = b*b - 4*a*c;
                if(a==0){
                    if(b==0 && c==0){
                    JOptionPane.showMessageDialog(null, "Infinite solutions","Result", JOptionPane.INFORMATION_MESSAGE);  
                    }              
                    else if(b==0) {
                        JOptionPane.showMessageDialog(null, "No solution","Result", JOptionPane.INFORMATION_MESSAGE);     
                    }           
                    else{
                        double x =-c/b;
                        JOptionPane.showMessageDialog(null, "x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(delta<0){
                    JOptionPane.showMessageDialog(null, "No real roots","Result", JOptionPane.INFORMATION_MESSAGE);    
                } 
                else if(delta==0){
                    double x = -b/(2*a);
                    JOptionPane.showMessageDialog(null, "Double root: x = " + x,"Result", JOptionPane.INFORMATION_MESSAGE);                
                }
                else{
                    double sqrtdelta = Math.sqrt(delta);
                    double x1 = (-b+sqrtdelta)/(2*a);
                    double x2 = (-b-sqrtdelta)/(2*a);
                    JOptionPane.showMessageDialog(null, "Two distinct roots:\nx1 = " + x1 + "\n" + "x2= " + x2,"Result", JOptionPane.INFORMATION_MESSAGE);                
                }
                break;
            }
        }
        System.exit(0);
    }
}