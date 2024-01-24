package ru.altacod.prmo.controller;

import ru.altacod.prmo.model.DailyTotal;
import ru.altacod.prmo.repository.DailyTotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dailytotals")
public class DailyTotalController {

    @Autowired
    private DailyTotalRepository dailyTotalRepository;

    // Получение всех итоговых данных за день
    @GetMapping
    public List<DailyTotal> getAllDailyTotals() {
        return dailyTotalRepository.findAll();
    }

    // Получение итоговых данных за день по ID
    @GetMapping("/{id}")
    public ResponseEntity<DailyTotal> getDailyTotalById(@PathVariable Long id) {
        return dailyTotalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Создание новых итоговых данных за день
    @PostMapping
    public DailyTotal createDailyTotal(@RequestBody DailyTotal dailyTotal) {
        return dailyTotalRepository.save(dailyTotal);
    }

    // Обновление итоговых данных за день
    @PutMapping("/{id}")
    public ResponseEntity<DailyTotal> updateDailyTotal(@PathVariable Long id, @RequestBody DailyTotal dailyTotalDetails) {
        return dailyTotalRepository.findById(id)
                .map(dailyTotal -> {
                    // Здесь вы обновляете поля dailyTotal с помощью dailyTotalDetails
                    // Например: dailyTotal.setSomeField(dailyTotalDetails.getSomeField());
                    return ResponseEntity.ok(dailyTotalRepository.save(dailyTotal));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Удаление итоговых данных за день
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDailyTotal(@PathVariable Long id) {
        return dailyTotalRepository.findById(id)
                .map(dailyTotal -> {
                    dailyTotalRepository.delete(dailyTotal);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
