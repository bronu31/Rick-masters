package com.microservice.rickmaster.service;

import com.microservice.rickmaster.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CoffeeService {

    Coffee create(Coffee coffee);
    Coffee update(Coffee coffee);
    List<Object> returnSums();
    List<Object> returnSumsFilterBySort(String sort);
    List<Object> returnSumsFilterByCountry(String country);
    List<Object> returnSums(String countryOfOrigin, String sort);
}
