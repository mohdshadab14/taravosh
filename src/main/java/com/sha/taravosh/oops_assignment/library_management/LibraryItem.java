package com.sha.taravosh.oops_assignment.library_management;

public abstract class LibraryItem {
    private int itemId;
    private String title;
    private boolean available = true;

    public LibraryItem(int itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    protected void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract void displayDetails();
}
