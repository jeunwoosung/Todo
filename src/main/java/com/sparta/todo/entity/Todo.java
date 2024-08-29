package com.sparta.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String todo;
    private String content;
    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Todo(String name, String todo, String content) {
        this.name = name;
        this.todo = todo;
        this.content = content;

    }

    public void update(String name,String todo,String content) {
        this.name = name;
        this.todo = todo;
        this.content = content;

    }
}