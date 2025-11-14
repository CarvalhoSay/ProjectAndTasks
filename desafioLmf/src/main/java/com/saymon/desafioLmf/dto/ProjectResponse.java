package com.saymon.desafioLmf.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record ProjectResponse(Long id, @Size(min = 5, max =100) @NotNull String name, String description, Date startDate, Date endDate) {
}
