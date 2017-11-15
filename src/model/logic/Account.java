package model.logic;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

public class Account extends RecursiveTreeObject<Account> implements Serializable{

    private int id;
    private String name, iconLetters, note;
    private float value;
    private boolean situation;

    public Account(String name, String iconLetters, String note, float value, boolean situation) {
        this.id = -1;
        this.name = name;
        this.iconLetters = iconLetters;
        this.note = note;
        this.value = value;
        this.situation = situation;
    }

    public Account(int id, String name, String iconLetters, String note, float value, boolean situation) {
        this.id = id;
        this.name = name;
        this.iconLetters = iconLetters;
        this.note = note;
        this.value = value;
        this.situation = situation;
    }

    public int getId() { return this.id; }

    public String getName(){
        return name;
    }

    public String getIconLetters() {
        return iconLetters;
    }

    public String getNote() {
        return note;
    }

    public float getValue() {
        return value;
    }

    public boolean isSituation() {
        return situation;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nName:" + name;
    }
}
