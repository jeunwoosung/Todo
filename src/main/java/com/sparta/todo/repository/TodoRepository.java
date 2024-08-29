package com.sparta.todo.repository;

import com.sparta.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    }
