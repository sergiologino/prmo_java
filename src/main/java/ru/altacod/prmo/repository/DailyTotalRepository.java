package ru.altacod.prmo.repository;

import ru.altacod.prmo.model.DailyTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DailyTotalRepository extends JpaRepository<DailyTotal, Long> {
    List<DailyTotal> findByDate(Date date);
    // Дополнительные методы, если они вам нужны
}
