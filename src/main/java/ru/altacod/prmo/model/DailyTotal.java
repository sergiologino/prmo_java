package ru.altacod.prmo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_totals")
public class DailyTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalId;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(nullable = false)
    private Integer total;

    // Конструкторы, геттеры и сеттеры
    public DailyTotal() {}

    // ... (другие геттеры и сеттеры)

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    // hashCode, equals и toString методы, если нужны
}