package model.bean;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.time.LocalDate;

public class Transaction extends RecursiveTreeObject<Transaction> {
    private int id;
    private float value;
    private String description, note, type;
    private LocalDate date, reminder;
    private Category category;
    private Account account;
    private boolean consolidate;

    public Transaction(float value, String description, String note, String type, LocalDate date, LocalDate reminder, boolean consolidate, Category category, Account account) {
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

    public Transaction(int id, float value, String description, String note, String type, LocalDate date, LocalDate reminder, boolean consolidate,Category category, Account account) {
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

    public Transaction(int id, float value, String description, String note, String type, LocalDate date, LocalDate reminder, boolean consolidate) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.category = null;
        this.account = null;
        this.note = note;
        this.type = type;
        this.date = date;
        this.reminder = reminder;
        this.consolidate = consolidate;
    }
    
    public int getId(){ return id;}

    public float getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Account getAccount() {
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

    public boolean getConsolidate() { return consolidate; }

    public void setId(int id){ this.id = id; }

    @Override
    public String toString() {
        return "Id: "+ id + "\nName: " + value + "Category:" + category + "Account: "+ account;
    }
}
