package model.logic;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

public class Account extends RecursiveTreeObject<Account> implements Serializable{

    private static final long serialVersionUID = 1;

    private String name, iconLetters, note;
    private float value;
    private boolean situation;

    public Account(String name, String iconLetters, String note, float value, boolean situation) {
        this.name = name;
        this.iconLetters = iconLetters;
        this.note = note;
        this.value = value;
        this.situation = situation;
    }

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

    public void print(){
        System.out.print("name: " + name + "\niconLetters: " + iconLetters + "\nnote: " + note +
                "\nvalue: " + value + "\nsituation: " + situation);
    }

    public String getCsvFormat(){
        return name+","+iconLetters+","+note+","+value+","+situation+"\n";
    }
}
