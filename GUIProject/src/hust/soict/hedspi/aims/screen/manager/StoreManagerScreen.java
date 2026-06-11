package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;

//3.1.1
public class StoreManagerScreen extends JFrame {
    private Store store;

    /*public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);

        JPanel centerGrid = createCenter();
        JScrollPane scrollPane = new JScrollPane(centerGrid);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store Manager - Ximasa");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }*/

    //3.2
    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);

        JPanel centerGrid = createCenter();
        JScrollPane scrollPane = new JScrollPane(centerGrid);

        //Chỉ hiển thị thanh cuộn dọc khi số sản phẩm vượt quá 9
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        cp.add(scrollPane, BorderLayout.CENTER);

        setTitle("Store Manager - Ximasa");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

//3.1.2 North: gồm menubar và header
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    /*Menubar
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("Manage Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }*/

    //Header
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS STORE");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

/*3.1.3
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < 9; i++) {
            if (i < mediaInStore.size()) {
                //Nếu ô này đã có sản phẩm thực tế trong kho, hiển thị thẻ sản phẩm đó
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } else {
                //Nếu ô này chưa có sản phẩm, nạp một JPanel trống vào để giữ khung
                JPanel emptyCell = new JPanel();
                center.add(emptyCell);
            }
        }

        return center;
    }*/

    //3.2
    JPanel createCenter() {
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int totalItems = mediaInStore.size();

        //TH1: Có từ 9 sản phẩm trở xuống -> Cố định lưới 3x3, ẩn thanh cuộn
        if (totalItems <= 9) {
            JPanel center = new JPanel();
            center.setLayout(new GridLayout(3, 3, 2, 2));

            for (int i = 0; i < 9; i++) {
                if (i < totalItems) {
                    MediaStore cell = new MediaStore(mediaInStore.get(i));
                    center.add(cell);
                } else {
                    JPanel emptyCell = new JPanel();
                    center.add(emptyCell);
                }
            }
            return center;
        }

        //TH2: Có trên 9 sản phẩm -> Tự động tăng hàng dọc, hiện thanh cuộn
        else {
            JPanel productGrid = new JPanel();
            productGrid.setLayout(new GridLayout(0, 3, 4, 4));

            for (int i = 0; i < totalItems; i++) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                cell.setPreferredSize(new Dimension(330, 230));
                productGrid.add(cell);
            }

            JPanel mainCenterPanel = new JPanel(new BorderLayout());
            mainCenterPanel.add(productGrid, BorderLayout.NORTH);
            return mainCenterPanel;
        }
    }
    //3.2
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            this.dispose();
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            this.dispose();
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            this.dispose();
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        JMenuItem viewStoreItem = new JMenuItem("View Store");
        menu.add(viewStoreItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

//3.1.5
public static void main(String[] args) {
    //Khởi tạo một cửa hàng
    Store myStore = new Store();

    //Thêm một vài dữ liệu mẫu để hiển thị lên GUI
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

    try {
        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);
    } catch (hust.soict.hedspi.aims.exception.LimitExceededException e) {
        e.printStackTrace();
    }

    //Khởi chạy màn hình quản lý
    new StoreManagerScreen(myStore);
}
}