package com.saymon.desafioLmf.services;

import com.saymon.desafioLmf.dto.ProjectRequest;
import com.saymon.desafioLmf.dto.ProjectResponse;
import com.saymon.desafioLmf.models.Project;
import com.saymon.desafioLmf.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public ProjectResponse createProject(ProjectRequest request){
        Project project = new Project();

        project.setName(request.name());
        project.setDescription(request.description());
        project.setStartDate(request.startDate());
        project.setEndDate(request.endDate());

        projectRepository.save(project);

      return new ProjectResponse(project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );

    }

    public List<ProjectResponse> findAll(){
        List<Project> findEntity = projectRepository.findAll();

        List<ProjectResponse> findResponse = new ArrayList<>();

        for (Project p : findEntity){
            findResponse.add(new ProjectResponse(
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getStartDate(),
                    p.getEndDate()));

        }


        return findResponse;
    }


}
