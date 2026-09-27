package com.sha.taravosh.model;


import java.util.List;

public class StudentWithLocation {
    private List<Student> studentsList;
    private List<Location> locationsList;

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Location> getLocationsList() {
        return locationsList;
    }

    public void setLocationsList(List<Location> locationsList) {
        this.locationsList = locationsList;
    }
}
