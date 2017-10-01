package model.logic;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import java.time.LocalDate;

public class Transaction extends RecursiveTreeObject<Transaction> implements Serializable {
    private float value;
    private String description, category, account, note, type;
    private LocalDate date, reminder;
    private boolean consolidate;

    public Transaction(float value, String description, String category, String account, String note, String type, LocalDate date, LocalDate reminder, boolean consolidate) {
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

    public void print(){
        System.out.print("value: " + value + "\ndescription: " + description + "\ncategory: " + category +
                "\naccount: " + account + "\nnote: " + note + "\ndate: " + date.toString() + "\nreminder: " +
                reminder.toString() + "\nconsolidate: " + consolidate + "\ntype: " + type);
    }

    public String getCsvFormat(){
        return value + "," + description + "," + category +
                "," + account + "," + note + "," + date.toString() + "," +
                reminder.toString() + "," + consolidate + "," + type;
    }
}
