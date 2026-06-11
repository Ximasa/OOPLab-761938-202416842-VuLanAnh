package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

public class ViewStoreController {
    @FXML
    private GridPane gridPane;

    private Store store;

    public ViewStoreController(Store store) {
        this.store = store;
    }

    @FXML
    void btnViewCartPressed(javafx.event.ActionEvent event) {
    }

    @FXML
    public void initialize() {
        try {
            java.net.URL storeURL = getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml");
            if (storeURL != null) {
                java.io.File dir = new java.io.File(storeURL.toURI()).getParentFile();
            }
        } catch (Exception e) {
        }
        // -------------------------------------------------------------

        int column = 0;
        int row = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                java.net.URL fxmlLocation = getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Item.fxml");

                if (fxmlLocation == null) {
                    continue;
                }

                fxmlLoader.setLocation(fxmlLocation);
                ItemController itemController = new ItemController();
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

}
