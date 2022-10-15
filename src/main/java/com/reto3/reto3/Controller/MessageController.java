package com.reto3.reto3.controller;

import com.reto3.reto3.entities.Message;
import com.reto3.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    public List<Message> getAll(){ return messageService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){ return messageService.getMessage(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message message){ return messageService.save(message); }

    @PutMapping("/update")
    public Message update (@RequestBody Message message){ return messageService.update(message); }

    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") int carId){ return messageService.delete(carId); }
}
