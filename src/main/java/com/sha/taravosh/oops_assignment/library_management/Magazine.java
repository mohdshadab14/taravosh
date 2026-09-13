package com.sha.taravosh.oops_assignment.library_management;

public class Magazine extends LibraryItem implements Borrowable {
    private int issueNumber;

    public Magazine(int itemId, String title, int issueNumber) {
        super(itemId, title);
        this.issueNumber = issueNumber;
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
