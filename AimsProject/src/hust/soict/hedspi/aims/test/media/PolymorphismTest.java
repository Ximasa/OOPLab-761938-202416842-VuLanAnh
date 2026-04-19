package test.media;

import java.util.ArrayList;
import java.util.List;

import disc.DigitalVideoDisc;
import media.*;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        Media cd = new CompactDisc(1, "Greatest Hits", "Music", 15.5f, 60, "Director A", "Artist B");
        Media dvd = new DigitalVideoDisc(2, "The Matrix", "Action", 20.0f, 136, "Wachowskis");
        Media book = new Book(3, "Java Programming", "Education", 45.0f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}