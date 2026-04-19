//Lab 3.18
import cart.Cart;
import disc.DigitalVideoDisc;
import media.*;
import store.Store;
import java.util.Scanner;
import java.util.List;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0:
                    System.out.println("Program closed. Goodbye Lan Anh!");
                    System.exit(0);
                default: System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n**************** AIMS ****************");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("**************************************");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\n--- STORE OPTIONS ---");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("---------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\n--- DETAILS ---");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("----------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\n--- CART OPTIONS ---");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void viewStore() {
        while (true) {
            store.printStore();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) { // Details
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                Media m = findMediaByTitle(store.getItemsInStore(), title);
                if (m != null) {
                    System.out.println(m.toString());
                    handleMediaDetails(m);
                } else System.out.println("Media not found!");
            }
            else if (choice == 2) { // Add to cart
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                Media m = findMediaByTitle(store.getItemsInStore(), title);
                if (m != null) {
                    cart.addMedia(m);
                    if (m instanceof DigitalVideoDisc) {
                        System.out.println("Current DVDs in cart: " + getDVDCountInCart());
                    }
                } else System.out.println("Media not found!");
            }
            else if (choice == 3) { // Play
                System.out.print("Enter title to play: ");
                String title = scanner.nextLine();
                Media m = findMediaByTitle(store.getItemsInStore(), title);
                playMediaLogic(m);
            }
            else if (choice == 4) viewCart();
            else if (choice == 0) break;
        }
    }

    public static void handleMediaDetails(Media m) {
        while (true) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                cart.addMedia(m);
                if (m instanceof DigitalVideoDisc) {
                    System.out.println("Current DVDs in cart: " + getDVDCountInCart());
                }
            }
            else if (choice == 2) playMediaLogic(m);
            else if (choice == 0) break;
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media | 2. Remove media");
        int sub = scanner.nextInt(); scanner.nextLine();
        if (sub == 1) {
            System.out.println("Choose type: 1. DVD | 2. CD | 3. Book");
            int type = scanner.nextInt(); scanner.nextLine();
            System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
            System.out.print("Title: "); String title = scanner.nextLine();
            System.out.print("Category: "); String category = scanner.nextLine();
            System.out.print("Cost: "); float cost = scanner.nextFloat(); scanner.nextLine();

            if (type == 1) { // DVD
                System.out.print("Length: "); int length = scanner.nextInt(); scanner.nextLine();
                System.out.print("Director: "); String director = scanner.nextLine();
                store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
            } else if (type == 2) { // CD
                System.out.print("Artist: "); String artist = scanner.nextLine();
                System.out.print("Director: "); String director = scanner.nextLine();
                CompactDisc cd = new CompactDisc(id, title, category, cost, 0, director, artist);
                System.out.println("--- Adding Tracks (type 'done' to stop) ---");
                while (true) {
                    System.out.print("Track title: "); String tTitle = scanner.nextLine();
                    if (tTitle.equalsIgnoreCase("done")) break;
                    System.out.print("Track length: "); int tLen = scanner.nextInt(); scanner.nextLine();
                    cd.addTrack(new Track(tTitle, tLen));
                }
                store.addMedia(cd);
            } else if (type == 3) { // Book
                Book book = new Book(id, title, category, cost);
                System.out.println("--- Adding Authors (type 'done' to stop) ---");
                while (true) {
                    System.out.print("Author: "); String author = scanner.nextLine();
                    if (author.equalsIgnoreCase("done")) break;
                    book.addAuthor(author);
                }
                store.addMedia(book);
            }
        } else if (sub == 2) {
            System.out.print("Title to remove: ");
            String t = scanner.nextLine();
            Media m = findMediaByTitle(store.getItemsInStore(), t);
            if (m != null) store.removeMedia(m);
        }
    }

    public static void viewCart() {
        while (true) {
            cartMenu();
            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1: // Filter
                    System.out.println("1. Filter by ID | 2. Filter by Title");
                    int fType = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter keyword: ");
                    String key = scanner.nextLine();
                    if (fType == 1) {
                        try {
                            int id = Integer.parseInt(key);
                            for (Media m : cart.getItemsOrdered()) if (m.getId() == id) System.out.println(m.toString());
                        } catch (Exception e) { System.out.println("Invalid ID."); }
                    } else {
                        for (Media m : cart.getItemsOrdered()) if (m.getTitle().contains(key)) System.out.println(m.toString());
                    }
                    break;
                case 2: // Sort
                    System.out.println("1. Sort by Title | 2. Sort by Cost");
                    int sType = scanner.nextInt(); scanner.nextLine();
                    if (sType == 1) cart.sortByTitle(); else cart.sortByCost();
                    break;
                case 3: // Remove
                    System.out.print("Title: ");
                    String rT = scanner.nextLine();
                    Media rm = findMediaByTitle(cart.getItemsOrdered(), rT);
                    if (rm != null) cart.removeMedia(rm);
                    break;
                case 4: // Play
                    System.out.print("Title: ");
                    String pT = scanner.nextLine();
                    Media pm = findMediaByTitle(cart.getItemsOrdered(), pT);
                    playMediaLogic(pm);
                    break;
                case 5: // Order
                    System.out.println("Order created! Cart cleared.");
                    cart = new Cart();
                    return;
                case 0: return;
            }
        }
    }

    private static void playMediaLogic(Media m) {
        if (m == null) { System.out.println("Media not found!"); return; }
        if (m instanceof Playable) ((Playable) m).play();
        else System.out.println("ERROR: " + m.getTitle() + " (Type: " + m.getClass().getSimpleName() + ") cannot be played!");
    }

    private static Media findMediaByTitle(List<Media> list, String title) {
        for (Media m : list) if (m.getTitle().equalsIgnoreCase(title)) return m;
        return null;
    }

    private static int getDVDCountInCart() {
        int count = 0;
        for (Media m : cart.getItemsOrdered()) if (m instanceof DigitalVideoDisc) count++;
        return count;
    }

    private static void initData() {
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
        store.addMedia(new Book(2, "Java Programming", "Education", 45.0f));
        store.addMedia(new CompactDisc(3, "Greatest Hits", "Music", 15.0f, 60, "Director A", "Artist B"));
    }
}

/*import cart.Cart;
import disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        //12. Create Carts of DigitalVideoDiscs
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", null, 0, 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        /* System.out.println("Current cart status:");
        anOrder.printCart();

        //13. Removing items from the cart
        System.out.println("Attempting to remove: " + dvd2.getTitle());
        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("Cart status after removal:");
        anOrder.printCart();

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron",
                162, 25.0f);
        anOrder.removeDigitalVideoDisc(dvd4);

        //14. Working with method overloading
        System.out.println("\nTesting Method Overloading");

        //14.1. Overloading by differing types of parameter
        DigitalVideoDisc[] dvdList = {
                new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan",
                        148, 20.0f),
                new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan",
                        169, 22.5f)
        };
        System.out.println("Adding an array of DVDs:");
        anOrder.addDigitalVideoDisc_array(dvdList);
        anOrder.printCart();

        System.out.println("Adding 3 DVDs using Varargs:");
        anOrder.addDigitalVideoDisc_varang(dvd1, dvd2, dvd4);
        anOrder.printCart();

        //14.2  Overloading by differing the number of parameters
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Cinderella", "Animation", "Disney",
                74, 12.5f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Mulan", "Animation", "Barry Cook",
                88, 15.0f);
        System.out.println("Adding 2 DVDs at once:");
        anOrder.addDigitalVideoDisc(dvd5, dvd6);
        anOrder.printCart();
    }
}*/