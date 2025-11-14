package com.saymon.desafioLmf.models;

import com.saymon.desafioLmf.models.enums.Priority;
import com.saymon.desafioLmf.models.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tittle;

    private String description;

    private Status status;

    private Priority priority;

    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project projectId;

    public Task(){

    }

    public Task(String tittle, String description, Status status, Priority priority, Date dueDate, Project projectId) {
        this.tittle = tittle;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Project getProjectID() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }
}
