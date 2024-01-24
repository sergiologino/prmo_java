package ru.altacod.prmo.controller;

import ru.altacod.prmo.model.OperationRecord;
import ru.altacod.prmo.repository.OperationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operationrecords")
public class OperationRecordController {

    @Autowired
    private OperationRecordRepository operationRecordRepository;

    // Получение всех записей операций
    @GetMapping
    public List<OperationRecord> getAllOperationRecords() {
        return operationRecordRepository.findAll();
    }

    // Получение записи операции по ID
    @GetMapping("/{id}")
    public ResponseEntity<OperationRecord> getOperationRecordById(@PathVariable Long id) {
        return operationRecordRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создание новой записи операции
    @PostMapping
    public OperationRecord createOperationRecord(@RequestBody OperationRecord operationRecord) {
        return operationRecordRepository.save(operationRecord);
    }

    // Обновление записи операции
    @PutMapping("/{id}")
    public ResponseEntity<OperationRecord> updateOperationRecord(@PathVariable Long id, @RequestBody OperationRecord operationRecordDetails) {
        return operationRecordRepository.findById(id)
                .map(operationRecord -> {
                    // Здесь вы обновляете поля operationRecord с помощью operationRecordDetails
                    // Например: operationRecord.setSomeField(operationRecordDetails.getSomeField());
                    return ResponseEntity.ok(operationRecordRepository.save(operationRecord));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Удаление записи операции
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOperationRecord(@PathVariable Long id) {
        return operationRecordRepository.findById(id)
                .map(operationRecord -> {
                    operationRecordRepository.delete(operationRecord);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

