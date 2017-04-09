package com.p7.mvc.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="Task")
public class Task implements Serializable{
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String text;
    private boolean isDone=false;


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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
