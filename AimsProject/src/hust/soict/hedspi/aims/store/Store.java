package store;

import disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
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
    }
}