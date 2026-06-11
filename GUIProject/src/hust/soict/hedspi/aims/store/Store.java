package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {
        this.itemsInStore = new ArrayList<Media>();
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsInStore.size() < 100) {
            if (!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
            } else {
                System.out.println("The media '" + media.getTitle() + "' is already in the store.");
            }
        } else {
            throw new LimitExceededException("ERROR: The store is full!");
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