package aims;

//15. Passing parameter
public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
    }
}

/* Trả lời câu hỏi: Is JAVA a Pass by Value or a Pass by Reference programming language?
Câu trả lời là: Java là Pass-by-Value programming language.
Lý do: 1. Khi truyền đối tượng, cái được "copy" và truyền đi chính là địa chỉ tham chiếu.
          - Hành động gán lại đối tượng (obj = newObj) bên trong hàm sẽ không ảnh hưởng ra ngoài.
          - Hành động thay đổi thuộc tính (obj.setField()) bên trong hàm sẽ ảnh hưởng ra ngoài vì
            cả hai cùng thao tác trên một vùng nhớ thực.
       2. Đối với các kiểu dữ liệu nguyên thủy (số), Java thực hiện truyền tham trị bằng cách sao chép giá trị.
          Mọi thay đổi thực hiện trên tham số bên trong phương thức hoàn toàn không ảnh hưởng đến biến gốc bên ngoài.

Trả lời câu hỏi: After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two objects still remain?
Câu trả lời là: - Java chỉ truyền bản sao của địa chỉ ô nhớ vào hàm, chứ không truyền chính biến gốc ở hàm main.
                - Việc tráo đổi trong hàm swap thực chất chỉ là tráo đổi các biến cục bộ đang giữ bản sao địa chỉ đó.
                -> Vì vậy, các biến gốc vẫn trỏ về đối tượng cũ và tiêu đề của chúng không hề bị ảnh hưởng.

Trả lời câu hỏi: After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is the title of the JungleDVD
                 changed?
Câu trả lời là: - Trong hàm changeTitle, không dùng lệnh gán (=) để đổi địa chỉ, mà dùng địa chỉ đó để truy cập
                trực tiếp vào vùng nhớ của đối tượng và gọi phương thức setTitle().
                - Vì biến cục bộ trong hàm và biến gốc ở hàm main đang cùng trỏ chung về một vùng nhớ,
                nên khi tác động vào nội dung bên trong vùng nhớ đó, đối tượng gốc sẽ bị thay đổi theo.
 */

