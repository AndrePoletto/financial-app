package model.bean;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.time.LocalDate;

public class Transaction extends RecursiveTreeObject<Transaction> {
    private int id;
    private float value;
    private String description, category, account, note, type;
    private LocalDate date, reminder;

    public Transaction(float value, String description, String category, String account, String note, String type, LocalDate date, LocalDate reminder, boolean consolidate) {
        this.id = -1;
        this.value = value;
        this.description = description;
        this.category = category;
        this.account = account;
        this.note = note;
        this.type = type;
        this.date = date;
        this.reminder = reminder;
        this.consolidate = consolidate;
    }

    public Transaction(int id, float value, String description, String category, String account, String note, String type, LocalDate date, LocalDate reminder, boolean consolidate) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.category = category;
        this.account = account;
        this.note = note;
        this.type = type;
        this.date = date;
        this.reminder = reminder;
        this.consolidate = consolidate;
    }

    private boolean consolidate;

    public int getId(){ return id;}

    public float getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAccount() {
        return account;
    }

    public String getNote() {
        return note;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getReminder() {
        return reminder;
    }

    public boolean isConsolidate() {
        return consolidate;
    }

    public void setId(int id){ this.id = id; }

    @Override
    public String toString() {
        return "Id: "+ id + "\nName: " + value;
    }
}
