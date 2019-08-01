package com.idenysenko.cassandra.demo.service;

import com.idenysenko.cassandra.demo.entity.Client;
import com.idenysenko.cassandra.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        client.setId(UUID.randomUUID());
        return clientRepository.insert(client);
    }
}
