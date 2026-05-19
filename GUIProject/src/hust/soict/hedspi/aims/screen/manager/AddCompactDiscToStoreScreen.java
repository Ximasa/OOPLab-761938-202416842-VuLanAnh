package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost, tfArtist;
    private static int nbCDs = 0;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD To Store");
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

        centerPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        centerPanel.add(tfArtist);

        centerPanel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        centerPanel.add(tfLength);

        centerPanel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            String artist = tfArtist.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            CompactDisc cd = new CompactDisc(++nbCDs, title, category, cost, length, director, artist);
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "CD added successfully!");
            new StoreManagerScreen(store);
            this.dispose();
        });
        centerPanel.add(new JLabel(""));
        centerPanel.add(btnAdd);
    }
}