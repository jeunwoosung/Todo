package com.sparta.todo.controller;


import com.sparta.todo.dto.todo.request.TodoDeleteRequestDto;
import com.sparta.todo.dto.todo.request.TodoSaveRequestDto;
import com.sparta.todo.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.todo.dto.todo.response.TodoSaveResponseDto;
import com.sparta.todo.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.todo.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto todoSaveRequestDto) {
        return todoService.saveTodo(todoSaveRequestDto);
    }


    @GetMapping("/todos")
    public ResponseEntity<Page<TodoSimpleResponseDto>> getBoards(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(todoService.getTodos(page, size));
    }

    @PutMapping("/todos/{todoId}")
    public TodoUpdateResponseDto updateTodo(
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequestDto todoUpdateRequestDto
    ) {
        return todoService.updateTodo(todoId, todoUpdateRequestDto);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId, @RequestBody TodoDeleteRequestDto todoDeleteRequestDto) {
        todoService.deleteTodo(todoId, todoDeleteRequestDto);
    }

}

