package com.sha.taravosh.oops_assignment.library_management;

public class ResearchPaper extends LibraryItem {
    private String researcher;

    public ResearchPaper(int itemId, String title, String researcher) {
        super(itemId, title);
        this.researcher = researcher;
    }

    @Override
    public void displayDetails() {
        // TODO
    }
}
