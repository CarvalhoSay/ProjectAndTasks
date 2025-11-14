package com.saymon.desafioLmf.services;

import com.saymon.desafioLmf.dto.ProjectRequest;
import com.saymon.desafioLmf.dto.TaskRequest;
import com.saymon.desafioLmf.dto.TaskResponse;
import com.saymon.desafioLmf.models.Project;
import com.saymon.desafioLmf.models.Task;
import com.saymon.desafioLmf.models.enums.Priority;
import com.saymon.desafioLmf.models.enums.Status;
import com.saymon.desafioLmf.repositories.ProjectRepository;
import com.saymon.desafioLmf.repositories.TaskRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }




    public TaskResponse createTask(TaskRequest request){
        Project project = projectRepository.findById(request.projectId()).orElseThrow(() -> new EntityNotFoundException("Projeto Nao encontro, tente novamente."));

        Task tk = new Task();

        tk.setTittle(request.tittle());
        tk.setDescription(request.description());
        tk.setStatus(request.status());
        tk.setPriority(request.priority());
        tk.setDueDate(request.dueDate());
        tk.setProjectId(project);

        taskRepository.save(tk);

        return new TaskResponse(tk.getId(),
                tk.getTittle(),
                tk.getDescription(),
                tk.getStatus(),
                tk.getPriority(),
                tk.getDueDate(),
                tk.getProjectID().getId()
        );

    }

    public List<TaskResponse> findByFilters(Status status, Priority priority, Long projectId){
        List<Task> task = taskRepository.findByFilters(status, priority, projectId);

        List<TaskResponse> tResponse = new ArrayList<>();

        for (Task t : task){
            tResponse.add(new TaskResponse(t.getId(),t.getTittle(),t.getDescription(),t.getStatus(),t.getPriority(),t.getDueDate(), t.getProjectID().getId()));
        }

        return tResponse;
    }

    public String atualizaStatus(Long id, Status status){
        Task tk = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task Nao encontrada"));

        tk.setStatus(status);
        taskRepository.save(tk);

        return "Status Atualizado: " + tk.getStatus();
    }

    public String deleteTask (Long id){
        Task tk = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task Nao encontrada"));

        taskRepository.delete(tk);

        return "Task Deletada!";
    }



}
