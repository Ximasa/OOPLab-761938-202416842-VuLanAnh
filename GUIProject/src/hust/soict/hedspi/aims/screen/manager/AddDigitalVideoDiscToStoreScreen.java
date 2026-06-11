package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD To Store");
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

        centerPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        centerPanel.add(tfLength);

        centerPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            try {
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(this, "DVD added successfully!");
                new StoreManagerScreen(store);
                this.dispose();
            } catch (hust.soict.hedspi.aims.exception.LimitExceededException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        centerPanel.add(new JLabel(""));
        centerPanel.add(btnAdd);
    }
}