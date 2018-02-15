package com.example.mizmer2;

/**
 * Created by Kullanıcı on 25.01.2018.
 */

public class Contact {

    //int id;
    String name, email, uname, pass;
    int type;

    public Contact() {
    }

    public Contact(String name, String email, String uname, String pass, int type) {
        this.name = name;
        this.email = email;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getType() {
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
}
