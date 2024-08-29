package com.sparta.todo.controller;

import com.sparta.todo.dto.comment.CommentResponseDto;
import com.sparta.todo.dto.comment.request.CommentSaveRequestDto;
import com.sparta.todo.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.todo.dto.comment.response.CommentSaveResponseDto;
import com.sparta.todo.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.todo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long todoId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(todoId, commentSaveRequestDto);
    }

    @GetMapping("/todos/comments")
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }

    @PutMapping("/todos/{todoId}/comments/{commentId}")
    public CommentUpdateResponseDto updateComment(
            @PathVariable Long todoId, Long commentId,
            @RequestBody CommentUpdateRequestDto commentUpdateRequestDto
    ) {
        return commentService.updateComment(todoId,commentId, CommentUpdateRequestDto);
    }
}
