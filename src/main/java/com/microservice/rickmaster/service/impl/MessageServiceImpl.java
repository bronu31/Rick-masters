package com.microservice.rickmaster.service.impl;

import com.microservice.rickmaster.model.Message;

import com.microservice.rickmaster.repository.MessageRepository;
import com.microservice.rickmaster.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {


    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    @Override
    public Message create(Message message) {
        return update(message);
    }

    @Override
    public Message update(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Object> lossesByCountry(String country) {
        List<Object> ret= messageRepository.lossesByCountry(country);
        return messageRepository.lossesByCountry(country);
    }

    @Override
    public List<Object> lossesByBrigade(Integer brigade) {

        return messageRepository.lossesByBrigade(brigade);
    }
}
