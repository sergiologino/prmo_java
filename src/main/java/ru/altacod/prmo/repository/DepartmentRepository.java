package ru.altacod.prmo.repository;

import ru.altacod.prmo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Здесь можно добавить специфические методы, если они понадобятся
}
