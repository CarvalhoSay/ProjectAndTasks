package com.saymon.desafioLmf.repositories;

import com.saymon.desafioLmf.models.Task;
import com.saymon.desafioLmf.models.enums.Priority;
import com.saymon.desafioLmf.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {


    // Uso de IA para facilitar criacao de querie
    @Query("SELECT t FROM Task t WHERE "
            + "(:status IS NULL OR t.status = :status) AND "
            + "(:priority IS NULL OR t.priority = :priority) AND "
            + "(:projectId IS NULL OR t.projectId.id = :projectId)")
    List<Task> findByFilters(@Param("status") Status status,
                             @Param("priority") Priority priority,
                             @Param("projectId") Long projectId);
}
