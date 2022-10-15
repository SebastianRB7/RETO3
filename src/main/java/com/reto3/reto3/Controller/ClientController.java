package com.reto3.reto3.controller;

import com.reto3.reto3.entities.Client;
import com.reto3.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getAll(){ return clientService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Client> getClient (@PathVariable("id") int id){ return clientService.getClient(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client){ return clientService.save(client); }

    @PutMapping("/update")
    public Client update (@RequestBody Client client){ return clientService.update(client); }

    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") int carId){ return clientService.delete(carId); }
}
