package com.idenysenko.cassandra.demo.service;

import com.idenysenko.cassandra.demo.entity.City;
import com.idenysenko.cassandra.demo.entity.Journal;
import com.idenysenko.cassandra.demo.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JournalService {

    private static final Logger LOG = LoggerFactory.getLogger(JournalService.class);

    private JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public Journal addJournalRecord(Journal journal) {
        journal.setId(UUID.randomUUID());
        journal.setCreateDate(LocalDateTime.now());
        return journalRepository.insert(journal);
    }

    public Map<City, Long> getJournalCitiesStatistics() {
        return journalRepository.findAll().stream()
                .collect(Collectors.groupingBy(Journal::getCity, Collectors.counting()));
    }

    public Optional<Journal> getClientLongestCall(UUID clientId, LocalDateTime start, LocalDateTime end) {
        return journalRepository.findClientRecords(clientId, start, end).stream()
                .max(Comparator.comparing(Journal::getCallDuration));
    }
}
