package model.logic;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

public class Category extends RecursiveTreeObject<Category> implements Serializable {
    private String name, type, categoryColor, note;

    public Category(String name, String type, String categoryColor, String note){
        this.name = name;
        this.type = type;
        this.categoryColor = categoryColor;
        this.note = note;
    }

    public String getName(){
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public String getNote() {
        return note;
    }

    public void print(){
        System.out.print("type: " + type + "\nname: " + name + "\ncategoryColor: " + categoryColor +
                "\nnote: " + note);
    }

    public String getCsvFormat(){
        return type + "," + name + "," + categoryColor + "," + note + "\n";
    }
}
