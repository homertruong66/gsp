package com.gsp.gsp.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;


public class Admin {

    private  int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date _created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date get_created() {
        return _created;
    }

    public void set_created(Date _created) {
        this._created = _created;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", _created=" + _created +
                '}';
    }
}
