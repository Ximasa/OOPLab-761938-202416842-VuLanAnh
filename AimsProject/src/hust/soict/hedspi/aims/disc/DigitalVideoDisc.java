package disc;

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

    //Lab03.4
    public boolean isMatch(String title) {
        String lowerTitle = this.getTitle().toLowerCase();
        String lowerInput = title.toLowerCase();
        String[] keywords = lowerInput.split("\\s+");

        for (String word : keywords) {
            if (lowerTitle.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
                + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}