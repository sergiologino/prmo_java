package ru.altacod.prmo.repository;



import ru.altacod.prmo.model.OperationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OperationRecordRepository extends JpaRepository<OperationRecord, Long> {
    List<OperationRecord> findByDate(Date date);
    // Другие специфические методы по необходимости
}

