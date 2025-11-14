package com.saymon.desafioLmf.controller;

import com.saymon.desafioLmf.dto.TaskRequest;
import com.saymon.desafioLmf.dto.TaskResponse;
import com.saymon.desafioLmf.dto.UpdateStatusRequest;
import com.saymon.desafioLmf.models.enums.Priority;
import com.saymon.desafioLmf.models.enums.Status;
import com.saymon.desafioLmf.services.TaskService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask (@RequestBody TaskRequest request){
        TaskResponse tk = taskService.createTask(request);
        return ResponseEntity.ok(tk);


    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findTasks (
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false) Long projectId){


        List<TaskResponse> tk = taskService.findByFilters(status,priority,projectId);

        return ResponseEntity.ok(tk);

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> attStatus(@PathVariable Long id,@RequestBody UpdateStatusRequest status){
        String t = taskService.atualizaStatus(id, status.status());
       return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTask(@PathVariable Long id){
        String t = taskService.deleteTask(id);

        return ResponseEntity.ok(t);
    }
}
