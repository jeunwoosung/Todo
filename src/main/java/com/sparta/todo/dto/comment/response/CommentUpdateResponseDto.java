package com.sparta.todo.dto.comment.response;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {

    private final Long id;
    private final String name;
    private final String content;

    public CommentUpdateResponseDto(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
}