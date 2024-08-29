package com.sparta.todo.dto.comment;

import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final Long id;
    private final String contents;
    private final String name;

    public CommentResponseDto(Long id, String contents, String name) {
        this.id = id;
        this.contents = contents;
        this.name = name;

    }
}
