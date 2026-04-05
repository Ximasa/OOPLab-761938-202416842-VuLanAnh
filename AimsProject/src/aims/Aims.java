package aims;

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

        System.out.println("Current cart status:");
        anOrder.printCart();

        //13. Removing items from the cart
        System.out.println("Attempting to remove: " + dvd2.getTitle());
        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("Cart status after removal:");
        anOrder.printCart();

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron",
                162, 25.0f);
        anOrder.removeDigitalVideoDisc(dvd4);

    }
}