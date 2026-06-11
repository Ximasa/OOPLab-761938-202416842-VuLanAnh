package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;

public class TestCartScreen extends Application {
    private static Cart cart;
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

        CartController cartController = new CartController(cart, store);
        fxmlLoader.setController(cartController);

        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Cart Screen Test");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();
        store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Harry Potter and the Philosopher's Stone", "Fantasy", 3.0f);
        CompactDisc cd = new CompactDisc(2, "Harry Potter and the Chamber of Secrets", "Fantasy", 3.5f);
        Book book = new Book(3, "Green Eggs and Ham", "Children", 5.0f);

        try {
            cart.addMedia(dvd);
            cart.addMedia(cd);
            cart.addMedia(book);
        } catch (hust.soict.hedspi.aims.exception.LimitExceededException e) {
            e.printStackTrace();
        }

        launch(args);
    }
}