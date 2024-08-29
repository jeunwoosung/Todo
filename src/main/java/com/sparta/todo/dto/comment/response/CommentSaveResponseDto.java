package com.sparta.todo.dto.comment.response;


import lombok.Getter;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String contents;

    public CommentSaveResponseDto(Long id, String contents, String name) {
        this.id = id;
        this.contents = contents;
    }
}

