package logic;

public class Account {
    private String name, iconLetters, note;
    private float initialValue;
    private boolean situation;

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setIconLetters(String iconLetters) {
        this.iconLetters = iconLetters;
    }

    public void setInitialValue(float initialValue) {
        this.initialValue = initialValue;
    }

    public void setSituation(boolean situation) {
        this.situation = situation;
    }
}
