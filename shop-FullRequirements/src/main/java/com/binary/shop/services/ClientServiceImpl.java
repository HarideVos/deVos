package com.binary.shop.services;

import com.binary.shop.entities.Client;
import com.binary.shop.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(int id, Client updateClient) {
        Optional<Client> member = clientRepository.findById(id);
        if (member.isEmpty()) {
            return clientRepository.save(updateClient);
        } else {
            return null;
        }
    }

    @Override
    public Client deleteClient(int id) {
        return null;
    }

    @Override
    public Optional<Client> getClientById(int id) {
        Optional<Client> member = clientRepository.findById(id);
        if (member.isEmpty()) {
            return clientRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Client getClientByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        if (client != null) {
            return clientRepository.findByEmail(email);
        } else {
            return null;
        }
    }
}
