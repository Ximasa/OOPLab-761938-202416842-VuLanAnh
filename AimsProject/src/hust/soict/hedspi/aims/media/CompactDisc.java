package media;

import java.util.ArrayList;

/*Lab 3.10
public class CompactDisc extends Disc { */
public class CompactDisc extends Disc implements Playable {

    private String artist;
    //private ArrayList<Track> tracks = new ArrayList<Track>();
    private ArrayList<Track> tracks;

    public CompactDisc() {
        super();
        this.tracks = new ArrayList<Track>();
    }

    /*public CompactDisc() {
        super();
    }*/

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<Track>();
    }

    public String getArtist() { return artist; }

    /*public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' added successfully.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' removed.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' does not exist.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    //Lab 3.11
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD total length: " + this.getLength());
        System.out.println("----------");

        // Duyệt qua danh sách track và gọi hàm play() của từng track
        for (Track track : tracks) {
            track.play();
        }
    }*/

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' added successfully.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' removed.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' does not exist.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
            System.out.println("CD total length: " + this.getLength());
            System.out.println("----------");
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("ERROR: CD length is 0 or less, cannot be played!");
        }
    }

    @Override
    public String toString() {
        return "CD [ID: " + getId() + ", Title: " + getTitle() +
                ", Category: " + getCategory() +
                ", Artist: " + getArtist() +
                ", Director: " + getDirector() +
                ", Total Length: " + getLength() +
                ", Cost: " + getCost() + "$]";
    }
}

