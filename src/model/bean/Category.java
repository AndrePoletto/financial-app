package model.bean;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;

public class Category extends RecursiveTreeObject<Category> {
    private int id;
    private String name, type, categoryColor, note;

    public Category(String name, String type, String categoryColor, String note){
        this.id = -1;
        this.name = name;
        this.type = type;
        this.categoryColor = categoryColor;
        this.note = note;
    }

    public Category(int id, String name, String type, String categoryColor, String note){
        this.id = id;
        this.name = name;
        this.type = type;
        this.categoryColor = categoryColor;
        this.note = note;
    }
    public int getId() { return id;}

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

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Id: " + id + "\nName: " + name;
    }
}
