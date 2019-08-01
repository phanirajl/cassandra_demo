package com.idenysenko.cassandra.demo.repository;

import com.idenysenko.cassandra.demo.entity.City;
import com.idenysenko.cassandra.demo.entity.Journal;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface JournalRepository extends CassandraRepository<Journal, UUID> {

    @Query("select city from journal")
    List<City> findAllCities();

    @Query("select * from journal where clientId=:clientId and createDate >= :start and createDate <= :end")
    List<Journal> findClientRecords(
            @Param("clientId") UUID clientId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);
}
