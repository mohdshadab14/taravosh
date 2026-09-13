package com.sha.taravosh;

public class Book extends LibraryItem implements Borrowable {
    private String author;

    public Book(int itemId, String title, String author) {
        super(itemId, title);
        this.author = author;
    }

    @Override
    public boolean borrowItem() {
        // TODO
        return false;
    }

    @Override
    public boolean returnItem() {
        // TODO
        return false;
    }

    @Override
    public void displayDetails() {
        // TODO
    }
}
