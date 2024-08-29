package com.sparta.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(String contents, String name, Todo todo) {
        this.contents = contents;
        this.name = name;
        this.todo = todo;
    }

    public void update(String name,String content) {
        this.name = name;
        this.contents = contents;


    }
}