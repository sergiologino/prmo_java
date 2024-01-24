package ru.altacod.prmo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "operation_records")
public class OperationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(nullable = false)
    private Long operationId; // Ссылка на сущность Operation, если она у вас есть

    @Column(nullable = false)
    private Integer count;

    // Конструкторы, геттеры и сеттеры
    public OperationRecord() {}

    // ... (другие геттеры и сеттеры)

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    // hashCode, equals и toString методы, если нужны
}
