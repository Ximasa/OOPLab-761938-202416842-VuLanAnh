//Lab 4.3.1.5
package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    //Lab 5.6
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("ERROR: DVD length is 0 or less, cannot be played!");
        }
    }

    @Override
    public String toString() {
        return "DVD [ID: " + getId() + ", Title: " + getTitle() +
                ", Category: " + getCategory() +
                ", Director: " + getDirector() +
                ", Length: " + getLength() +
                ", Cost: " + getCost() + "$]";
    }
}