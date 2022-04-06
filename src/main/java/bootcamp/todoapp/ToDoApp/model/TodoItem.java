package bootcamp.todoapp.ToDoApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "todo_item")
public class TodoItem {
    @Id
    @GeneratedValue
    private int id;

    private String text;
    private Date createdTS;

    public TodoItem() {
    }

    public TodoItem(String text) {
        this.text = text;
        this.createdTS = new Date();
    }

    public TodoItem(int newId, String text) {
        this.id = newId;
        this.text = text;
        this.createdTS = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
