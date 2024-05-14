package com.example.eksamenprojekt_gruppe_2.Model;

public class User {

    private int id;
    private int telefonnummer;
    private String name;
    private String email;
    private String password;
    private String username;
    private String adress;

    public User() {
    }

    public User(String name, String email, String password, String username, String adress) {

    }

    public User(int id, int telefonnummer, String name, String email, String password, String username, String adress) {
        this.id = id;
        this.telefonnummer = telefonnummer;
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.adress = adress;
    }
}
