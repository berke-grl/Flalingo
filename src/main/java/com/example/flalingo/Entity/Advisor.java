package com.example.flalingo.Entity;

public class Advisor {
    private int id;
    private String name;
    private int teacher_id;
    private int student_id;
    private int language_id;

    public Advisor() {
    }

    public Advisor(String name, int teacher_id, int student_id, int language_id) {
        this.name = name;
        this.teacher_id = teacher_id;
        this.student_id = student_id;
        this.language_id = language_id;
    }

    public Advisor(int id, String name, int teacher_id, int student_id, int language_id) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
        this.student_id = student_id;
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

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
