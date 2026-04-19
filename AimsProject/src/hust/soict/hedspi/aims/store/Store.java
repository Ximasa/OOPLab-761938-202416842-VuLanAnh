package store;

import disc.DigitalVideoDisc;
import media.Media;

import java.util.ArrayList;

public class Store {
    /*Lab 3.5
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("DVD '" + dvd.getTitle() + "' has been added to the store.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd)) {
            itemsInStore.remove(dvd);
            System.out.println("DVD '" + dvd.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("DVD '" + dvd.getTitle() + "' is not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("\n**********STORE**********");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("*************************\n");
    }*/

    //Lab 3.13
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}