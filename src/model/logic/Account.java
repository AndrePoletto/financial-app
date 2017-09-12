package model.logic;


public class Account {
    private String name, iconLetters, note;
    private float value;
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

    public void setSituation(boolean situation) {
        this.situation = situation;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public void print(){
        System.out.print("name: " + name + "\niconLetters: " + iconLetters + "\nnote: " + note +
                "\nvalue: " + value + "\nsituation: " + situation);
    }

    public String getCsvFormat(){
        return name+","+iconLetters+","+note+","+value+","+situation+"\n";
    }
}
