package com.sparta.todo.dto.todo.response;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private final Long id;
    private final String todo;
    private final String name;
    private final String content;

    public TodoUpdateResponseDto(Long id, String todo, String name, String content) {
        this.id = id;
        this.todo = todo;
        this.name = name;
        this.content = content;
    }
}
