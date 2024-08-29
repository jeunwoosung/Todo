package com.sparta.todo.dto.todo.request;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {

    private String todo;
    private String name;
    private String content;
}

