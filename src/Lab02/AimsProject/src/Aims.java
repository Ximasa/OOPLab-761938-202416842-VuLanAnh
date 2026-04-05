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
}