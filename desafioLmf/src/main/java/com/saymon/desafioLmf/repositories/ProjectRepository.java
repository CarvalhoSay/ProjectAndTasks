package com.saymon.desafioLmf.repositories;

import com.saymon.desafioLmf.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
