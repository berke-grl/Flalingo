package com.example.flalingo.Entity;

public class Teacher {
    private int id;
    private String name;
    private String lastName;
    private int languageId;

    public Teacher() {
    }

    public Teacher(String name, String lastName, int languageId) {
        this.name = name;
        this.lastName = lastName;
        this.languageId = languageId;
    }

    public Teacher(int id, String name, String lastName, int languageId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.languageId = languageId;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
