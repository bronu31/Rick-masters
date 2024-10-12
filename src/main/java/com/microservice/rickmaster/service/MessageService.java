package com.microservice.rickmaster.service;


import com.microservice.rickmaster.model.Message;

import java.util.List;

public interface MessageService {

    Message create(Message coffee);
    Message update(Message coffee);

    List<Object> lossesByCountry(String country);
    List<Object> lossesByBrigade(Integer brigade);
}
