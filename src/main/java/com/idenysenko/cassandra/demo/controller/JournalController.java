package com.idenysenko.cassandra.demo.controller;

import com.idenysenko.cassandra.demo.entity.City;
import com.idenysenko.cassandra.demo.entity.Journal;
import com.idenysenko.cassandra.demo.service.JournalService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/journals")
public class JournalController {

    private JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping
    public Journal addJournalRecord(@Valid @RequestBody Journal journal) {
        return journalService.addJournalRecord(journal);
    }

    @GetMapping("/statistics/cities")
    public Map<City, Long> getJournalCitiesStatistics() {
        return journalService.getJournalCitiesStatistics();
    }

    @GetMapping("/clients/{id}/longest")
    public Optional<Journal> getClientLongestCall(
            @PathVariable(name = "id") UUID clientId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return journalService.getClientLongestCall(clientId, start, end);
    }
}
