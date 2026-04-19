package media;

public class Track {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track tmp = (Track) obj;
            return (this.title.equals(tmp.getTitle()) && this.length == tmp.getLength());
        }
        return false;
    }
}