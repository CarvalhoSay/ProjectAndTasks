package com.saymon.desafioLmf.controller;

import com.saymon.desafioLmf.dto.ProjectRequest;
import com.saymon.desafioLmf.dto.ProjectResponse;
import com.saymon.desafioLmf.models.Project;
import com.saymon.desafioLmf.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request){
        return ResponseEntity.ok(projectService.createProject(request));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> listarTodosProjetos(){
        return ResponseEntity.ok(projectService.findAll());

    }

}
