package com.idenysenko.cassandra.demo.repository;

import com.idenysenko.cassandra.demo.entity.Client;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ClientRepository extends CassandraRepository<Client, UUID> {

}
