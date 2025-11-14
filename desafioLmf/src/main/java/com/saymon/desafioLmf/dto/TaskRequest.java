package com.saymon.desafioLmf.dto;

import com.saymon.desafioLmf.models.Project;
import com.saymon.desafioLmf.models.enums.Priority;
import com.saymon.desafioLmf.models.enums.Status;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TaskRequest(@NotNull String tittle, String description, Status status, Priority priority, Date dueDate, Long projectId) {
}
