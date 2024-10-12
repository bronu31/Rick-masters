package com.microservice.rickmaster.controller;


import com.microservice.rickmaster.model.Message;
import com.microservice.rickmaster.service.MessageService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@Tag(name="message controller",
        description="Контроллер который отвечает за получение данных за сообщения и выгрузку статистики по бридам")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @PostMapping()
    public void receive(
            @RequestBody
            @Parameter(description = "сообщение которое необходимо сохранить")
            Message message){
        messageService.create(message);
    }
    @RequestMapping("/brigade")
    public List<Object> receive(
            @RequestParam("brigade")
            @Parameter(description = "номер бригады по которой получается статистика")
            Integer bridade){
        return messageService.lossesByBrigade(bridade);
    }
    @RequestMapping("/country")
    public List<Object> receive(
            @RequestParam("country")
            @Parameter(description = "название страны по которой получается статистика")
            String country){
       return messageService.lossesByCountry(country);
    }
}
