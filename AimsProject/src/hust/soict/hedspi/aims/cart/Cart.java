package cart;
import disc.DigitalVideoDisc;
import java.util.ArrayList;
import media.Media;

public class Cart {
    //11. Create the Cart class to work with DigitalVideoDisc
    public static final int MAX_NUMBERS_ORDERED = 20;
    //private disc.DigitalVideoDisc itemsOrdered[] = new disc.DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    //private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
    /*private int qtyOrdered = 0;


    public void addDigitalVideoDisc(disc.DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc '" + disc.getTitle() + "' has been added.\n");
        } else {
            System.out.println("The cart is almost full (Maximum 20 items).\n");
        }
    }

    public void removeDigitalVideoDisc(disc.DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed.\n");
        } else {
            System.out.println("Disc not found in cart! Cannot remove!\n");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void filterByID(int id) {
        boolean found = false;
        System.out.println("Search Result for ID: " + id + ".\n");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println(itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No DVD found with ID: " + id + ".\n");
    }

    public void filterByTitle(String title) {
        boolean found = false;
        System.out.println("Search Result for Title: " + title + ".\n");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) System.out.println("No DVD found with title: " + title + ".\n");
    }

    public void sortCartbyCost() {
        for (int i = 0; i < qtyOrdered - 1; i++) {
            for (int j = 0; j < qtyOrdered - i - 1; j++) {
                if (itemsOrdered[j].getCost() < itemsOrdered[j + 1].getCost()) {
                    disc.DigitalVideoDisc temp = itemsOrdered[j];
                    itemsOrdered[j] = itemsOrdered[j + 1];
                    itemsOrdered[j + 1] = temp;
                }
            }
        }
        System.out.println("Cart sorted by cost (decreasing).\n");
    }

    public void sortCartbyTitle() {
        for (int i = 0; i < qtyOrdered - 1; i++) {
            for (int j = 0; j < qtyOrdered - i - 1; j++) {
                if (itemsOrdered[j].getTitle().compareToIgnoreCase(itemsOrdered[j+1].getTitle()) > 0) {
                    disc.DigitalVideoDisc temp = itemsOrdered[j];
                    itemsOrdered[j] = itemsOrdered[j + 1];
                    itemsOrdered[j + 1] = temp;
                }
            }
        }
        System.out.println("Cart sorted by title (alphabetical).\n");
    }

    public void chooseFreeItem() {
        if (qtyOrdered > 0) {
            int rd = (int) (Math.random() * qtyOrdered);
            System.out.println("Lucky! The DVD '" + itemsOrdered[rd].getTitle() + "' is now FREE!\n");
        }
    }

    public void placeOrder() {
        if (qtyOrdered == 0) {
            System.out.println("Your cart is empty. Cannot place order.\n");
        } else {
            System.out.println("Order created successfully!\n");
            System.out.println("Total cost: " + totalCost() + " $\n");
            qtyOrdered = 0;
            itemsOrdered = new disc.DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        }
    }

    public void updateQuantity(disc.DigitalVideoDisc disc, int qty) {
        System.out.println("Quantity updated for: " + disc.getTitle() + ".\n");
    }

    //12. Create Carts of DigitalVideoDiscs
    public void printCart() {
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". [ID: " + itemsOrdered[i].getTitle() + " : "
                    + itemsOrdered[i].getCost() + " $\n");
        }
        System.out.println("Total Cost: " + totalCost() + " $\n");
    }

    //14. Working with method overloading
    //14.1. Overloading by differing types of parameter
    public void addDigitalVideoDisc_array(disc.DigitalVideoDisc[] dvdList) {
        for (disc.DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc_varang(disc.DigitalVideoDisc... dvds) {
        for (disc.DigitalVideoDisc disc : dvds) {
            addDigitalVideoDisc(disc);
        }
    }

    //14.2  Overloading by differing the number of parameters
    public void addDigitalVideoDisc(disc.DigitalVideoDisc dvd1, disc.DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }*/

    //Lab03.4
    /*public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered.add(disc);
        System.out.println("The disc '" + disc.getTitle() + "' has been added.");
        System.out.println("Current quantity in cart: " + itemsOrdered.size());
    }

    public float totalCost() {
        float total = 0.0f;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null) {
                total += dvd.getCost();
            }
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    //Tìm theo ID
    public void search(int id) {
        boolean found = false;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd.getId() == id) {
                System.out.println("Found: " + dvd.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No DVD found with ID: " + id);
    }

    //Tìm theo Title
    public void search(String title) {
        boolean found = false;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd.isMatch(title)) {
                System.out.println("Found: " + dvd.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No DVD found with title: " + title);
    }
    }*/

    private ArrayList<Media> itemsOrdered;
    public Cart() {
        this.itemsOrdered = new ArrayList<Media>();
    }
    //private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media '" + media.getTitle() + "' has been added.");
            } else {
                System.out.println("The media '" + media.getTitle() + "' is already in the cart.");
            }
        } else {
            System.out.println("The cart is almost full!");
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

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}


