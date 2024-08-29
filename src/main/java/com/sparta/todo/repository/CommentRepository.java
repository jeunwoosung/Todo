package com.sparta.todo.repository;

import com.sparta.todo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository {
    List<Comment> findByTodoId(Long id);
}
