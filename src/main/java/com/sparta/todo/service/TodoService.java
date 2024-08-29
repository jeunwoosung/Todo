package com.sparta.todo.service;

import com.sparta.todo.dto.todo.request.TodoDeleteRequestDto;
import com.sparta.todo.dto.todo.request.TodoSaveRequestDto;
import com.sparta.todo.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.todo.dto.todo.response.TodoDetailResponseDto;
import com.sparta.todo.dto.todo.response.TodoSaveResponseDto;
import com.sparta.todo.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.todo.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo newTodo = new Todo(
                todoSaveRequestDto.getName(),
                todoSaveRequestDto.getTodo(),
                todoSaveRequestDto.getContent()
        );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getName(), savedTodo.getTodo(), savedTodo.getContent(),savedTodo.getCreatedAt(),savedTodo.getModifiedAt());
    }

    public TodoDetailResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("없는 일정입니다."));

        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTodo(),
                todo.getName(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    public Page<TodoSimpleResponseDto> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoSimpleResponseDto(
                todo.getId(),
                todo.getTodo(),
                todo.getName(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        ));
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("없는 일정입니다."));

        todo.update(
                todoUpdateRequestDto.getTodo(),
                todoUpdateRequestDto.getName(),
                todoUpdateRequestDto.getContent()
        );

        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getTodo(),
                todo.getName(),
                todo.getContent()
        );
    }

    @Transactional
    public void deleteTodo(Long todoId, TodoDeleteRequestDto todoDeleteRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("없는 일정입니다."));
        
        todoRepository.deleteById(todoId);
    }
}