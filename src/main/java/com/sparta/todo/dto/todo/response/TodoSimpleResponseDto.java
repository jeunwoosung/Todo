package com.sparta.todo.dto.todo.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {
    private final Long id;
    private final String todo;
    private final String name;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoSimpleResponseDto(Long id, String todo, String name, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.todo = todo;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

