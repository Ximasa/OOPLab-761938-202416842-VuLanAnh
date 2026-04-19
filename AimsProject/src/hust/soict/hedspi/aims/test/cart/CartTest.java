package test.cart;
import cart.Cart;
import disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        System.out.println("\nSearch by ID:");
        cart.search(1);
        cart.search(3);
        cart.search(0);

        System.out.println("\nSearch by Title:");
        cart.search("Star Wars");
        cart.search("Avatar");
        cart.search("Aladin");
        cart.search("Animation");
    }
}