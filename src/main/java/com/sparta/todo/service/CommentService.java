package com.sparta.todo.service;

import com.sparta.todo.dto.comment.CommentResponseDto;
import com.sparta.todo.dto.comment.request.CommentSaveRequestDto;
import com.sparta.todo.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.todo.dto.comment.response.CommentSaveResponseDto;
import com.sparta.todo.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.todo.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.todo.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.todo.entity.Comment;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.CommentRepository;
import com.sparta.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("없는 일정입니다."));

        Comment newComment = new Comment(commentSaveRequestDto.getContents(),commentSaveRequestDto.getName(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents(), savedComment.getName());
    }

    public List<CommentResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents(),comment.getName()));
        }
        return dtoList;
    }

    @Transactional
    public TodoUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {


        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("없는 댓글 입니다."));

        comment.update(
                todoUpdateRequestDto.getName(),
                todoUpdateRequestDto.getContent()
        );

        return new CommentUpdateResponseDto(
                comment.getId(),
                comment.getName(),
                comment.getContents()
        );


    }
}
