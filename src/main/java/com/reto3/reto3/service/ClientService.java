package com.reto3.reto3.service;

import com.reto3.reto3.entities.Client;
import com.reto3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save (Client client){
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        } else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (e.isPresent()){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update (Client client){
        if (client.getIdClient() != null){
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (!e.isPresent()){
                if (client.getName() != null){
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null){
                    e.get().setAge(client.getAge());
                }
                if (client.getEmail() != null){
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean delete (int id){
        Boolean r = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return r;
    }
}
