package com.example.myapplication;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class details {
    private String inputUsername;
    private String inputContact;
    private String inputfoodtype;
    private String inputfoodquantity;
    private String inputcity;

    public details() {
    }

    public details(String inputUsername, String inputContact, String inputfoodtype, String inputfoodquantity, String inputcity) {
        this.inputUsername = inputUsername;
        this.inputContact = inputContact;
        this.inputfoodtype = inputfoodtype;
        this.inputfoodquantity = inputfoodquantity;
        this.inputcity = inputcity;
    }

    public String getInputUsername() {
        return inputUsername;
    }

    public String getInputContact() {
        return inputContact;
    }

    public String getInputfoodtype() {
        return inputfoodtype;
    }

    public String getInputfoodquantity() {
        return inputfoodquantity;
    }

    public String getInputcity() {
        return inputcity;
    }

}
