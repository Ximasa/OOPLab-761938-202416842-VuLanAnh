package media;

/*Lab3.10
public class Track {*/

//Lab 3.11
public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    /*@Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track tmp = (Track) obj;
            return (this.title.equals(tmp.getTitle()) && this.length == tmp.getLength());
        }
        return false;
    }*/

    //Lab 3.11
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    //Lab 3.15
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        if (this.title == null) {
            return (other.title == null) && (this.length == other.length);
        }
        return this.title.equalsIgnoreCase(other.title) && (this.length == other.length);
    }
}