package com.binary.shop.services;

import com.binary.shop.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface ClientService {
    List<Client> getAllClients();
    Client createClient(Client client);
    Client updateClient(int id, Client updateClient);
    Client deleteClient(int id);
    Optional<Client> getClientById(int id);
    Client getClientByEmail(String email);


}
