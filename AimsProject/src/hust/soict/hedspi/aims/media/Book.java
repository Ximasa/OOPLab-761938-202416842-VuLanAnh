package media;

import java.util.ArrayList;
import java.util.List;

//Lab03.8
/*public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();}

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }*/

//Lab 03.9
public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    // Constructor mặc định
    public Book() {
        super();
    }

    // Constructor đầy đủ tham số
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added successfully.");
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed successfully.");
        } else {
            System.out.println("Author '" + authorName + "' does not exist in the list.");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        String authorList = String.join(", ", authors);
        return "Book [ID: " + getId() + ", Title: " + getTitle() +
                ", Category: " + getCategory() +
                ", Authors: [" + authorList + "], Cost: " + getCost() + "$]";
    }
}