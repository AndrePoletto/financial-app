package logic;

public class Category {
    private String type, name, categoryColor, note;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void print(){
        System.out.print("type: " + type + "\nname: " + name + "\ncategoryColor: " + categoryColor +
                "\nnote: " + note);
    }
}
