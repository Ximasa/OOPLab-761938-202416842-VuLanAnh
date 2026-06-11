package hust.soict.hedspi.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.hedspi.aims.media.Media;

import hust.soict.hedspi.aims.exception.LimitExceededException;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public Cart() {
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (itemsOrdered.contains(media)) {
                System.out.println("The media '" + media.getTitle() + "' is already in the cart.");
            } else {
                itemsOrdered.add(media);
                System.out.println("The media '" + media.getTitle() + "' has been added.");
            }
        } else {
            throw new LimitExceededException("ERROR: The number of media in the cart has reached the limit (" + MAX_NUMBERS_ORDERED + ")");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not in the cart.");
        }
    }

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
}