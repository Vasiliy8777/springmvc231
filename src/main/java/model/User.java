package model;

public class User {

    private int id=1;
    private String name;
    private  String sureName;
    public User(int id, String name, String sureName) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
    }
    public User(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }
}
