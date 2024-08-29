package com.sparta.todo.dto.comment.request;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    private String contents;
    private String name;
}