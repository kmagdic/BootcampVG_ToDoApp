package bootcamp.todoapp.ToDoApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity // ovo kaže Springu da je to entitet/tablica u bazi
@Table(name = "todo_item") // ime tablice
public class TodoItem {
    @Id // id je primarni ključ
    @GeneratedValue // ovo je isto kao autoincrement u bazi
    private int id;

    private String text;

    @Column(name = "created_timestamp")
    private Date createdTS;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    private AppUser appUser;

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
