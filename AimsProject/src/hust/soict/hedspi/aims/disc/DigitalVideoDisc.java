package hust.soict.hedspi.aims.disc;

//8. Create the DigitalVideoDisc class and its attributes
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    //16. Classifier Member and Instance Member
    private static int nbDigitalVideoDiscs = 0;
    private int id;

//9. Create accessors and mutators for the class DigitalVideoDisc
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

//10. Create Constructor method
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        //16. Classifier Member and Instance Member
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;

        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

//15. Passing parameter
    public void setTitle(String title) {
        this.title = title;
    }

//16. Classifier Member and Instance Member
    public int getId() {
        return id;
    }
}

/*Trả lời câu hỏi: If you create a constructor method to build a DVD by title then create a constructor method to build
a DVD by category. Does JAVA allow you to do this?
Câu trả lời là: Java không cho phép tạo hai hàm khởi tạo chỉ cùng nhận một tham số kiểu String như title và category.
Lý do:
1. Em đã thử và không thể tạo constructor method cho category sau khi đã tạo cho title trước đó,
   chương trình báo constructor đã tồn tại.
2. Trình biên dịch dựa vào Method Signature — gồm số lượng, kiểu dữ liệu và thứ tự tham số — để phân biệt các hàm nạp
   chồng.
   Vì cả hai thuộc tính đều là String, Java sẽ gặp lỗi trùng lặp chữ ký và không thể xác định giá trị truyền vào thuộc
   về title hay category khi khởi tạo đối tượng.
*/
