package com.qa.testData;

public class UserData {

    private String title;
    private String firstname;
    private String lastname;
    private String company;

    public UserData (String title, String firstname, String lastname, String company){
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
