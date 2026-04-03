package Lab01;
import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main (String[] args){
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}

/*Answer questions:
    1. What happens if users choose “Cancel”?
       Khi người dùng nhấn "Cancel", hàm showConfirmDialog sẽ trả về giá trị số nguyên tương ứng với hằng số JOptionPane.CANCEL_OPTION.
       Tuy nhiên, vì biểu thức điều kiện trong mã của bạn chỉ kiểm tra YES_OPTION, nên chương trình sẽ mặc định hiển thị thông báo là "No".

    2. How to customize the options to users, e.g. only two options:
       A. “Yes” and “No”?
          Thay đổi đoạn sau:
          int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?",
                "Select an Option", JOptionPane.YES_NO_OPTION);

       B. “I do” and “I don’t”?
          Full code:
              package Lab01;
              import javax.swing.JOptionPane;
              public class ChoosingOption {
                public static void main (String[] args){
                    String[] options = {"I do", "I don't"};
                    int option = JOptionPane.showOptionDialog(null,
                        "Do you want to change to the first class ticket?", "Customizing Options",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    String choice = (option == JOptionPane.YES_OPTION) ? "I do" : "I don't";
                    JOptionPane.showMessageDialog(null, "You've chosen: " + choice);
                System.exit(0);
                }
            }
*/

