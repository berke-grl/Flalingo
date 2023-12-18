package com.example.flalingo.Entity;

public class Student {
    private int id;
    private String name;
    private int teacher_id;
    private int language_id;

    public Student() {
    }

    public Student(String name, int teacher_id, int language_id) {
        this.name = name;
        this.teacher_id = teacher_id;
        this.language_id = language_id;
    }

    public Student(int id, String name, int teacher_id, int language_id) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
        this.language_id = language_id;
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

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
