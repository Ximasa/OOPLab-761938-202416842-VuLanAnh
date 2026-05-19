package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost;
    private static int nbBooks = 0;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book To Store");
        setVisible(true);
    }

    @Override
    protected void addFormFields() {
        centerPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book(++nbBooks, title, category, cost);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added successfully!");

            new StoreManagerScreen(store);
            this.dispose();
        });
        centerPanel.add(new JLabel(""));
        centerPanel.add(btnAdd);
    }
}