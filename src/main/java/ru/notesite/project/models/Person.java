package ru.notesite.project.models;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private static int id;
    private static String name;
    private static String password;
    private static String note;
    private List<String> arrayListNotes = new ArrayList<>();

    public Person () {
        super();
    }

    public void setArrayListNotes(List<String> arrayListNotes) {
        this.arrayListNotes = arrayListNotes;
    }

    public List<String> getArrayListNotes() {
        return arrayListNotes;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
