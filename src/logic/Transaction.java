package logic;

import java.time.LocalDate;

public class Transaction {
    private float value;
    private String description, category, account, note, type;
    private LocalDate date, reminder;
    private boolean consolidate;

    public void setValue(float value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReminder(LocalDate reminder) {
        this.reminder = reminder;
    }

    public void setConsolidate(boolean consolidate) {
        this.consolidate = consolidate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printAt(){
        System.out.print(value + "\n" + description + "\n" + category + "\n" + account + "\n" + note + "\n" + date.toString() + "\n" + reminder.toString() + "\n" + consolidate + "\n" + type);
    }
}
