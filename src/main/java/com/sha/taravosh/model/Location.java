package com.sha.taravosh.model;

public class Location {
    private String city;
    private String schoolName;
    private int rating;

    public Location(String city, String schoolName, int rating){
        this.city = city;
        this.schoolName = schoolName;
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
