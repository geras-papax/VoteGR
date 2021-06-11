package com.example.votegr.ui.home;

import androidx.lifecycle.ViewModel;


public class HomeViewModel extends ViewModel {

    private String msg;
    private String name;
    private String role;

    public HomeViewModel() {
        setMessage("Καλωσήρθες");
    }

    public String getMessage() {
        return msg;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public void setMessage(String msg) {
        this.msg=msg;
    }
    public void setName(String name) {
        this.name= "Αναγνωριστικό Σύνδεσης: " + name;
    }
    public void setRole(String role) {
        if(role.equals("citizen")) {
            this.role = "Σύνδεση ως Πολίτης";
        } else if(role.equals("party")) {
            this.role = "Σύνδεση ως Κόμμα";
        } else if(role.equals("admin")) {
            this.role = "Σύνδεση ως Διαχειριστής";
        }
    }
}