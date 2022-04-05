package bootcamp.todoapp.ToDoApp.model;

import java.util.Date;

public class TodoItem {
    private int id;
    private String text;
    private Date createdTS;

    public TodoItem(String text) {
        this.text = text;
        this.createdTS = new Date();
    }

    public TodoItem(int newId, String text) {
        this.id = newId;
        this.text = text;
        this.createdTS = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(Date createdTS) {
        this.createdTS = createdTS;
    }
}
