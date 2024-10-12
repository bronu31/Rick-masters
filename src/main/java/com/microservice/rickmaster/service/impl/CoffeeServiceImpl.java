package com.microservice.rickmaster.service.impl;

import com.microservice.rickmaster.model.Coffee;
import com.microservice.rickmaster.repository.CoffeeRepository;
import com.microservice.rickmaster.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.SmartValidator;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private CoffeeRepository coffeeRepository;


    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Coffee create(Coffee coffee) {
        return update(coffee);
    }

    @Override
    public Coffee update(Coffee coffee) {
        if ((coffee.getRobust()+coffee.getArabica()>100||coffee.getRobust()+coffee.getArabica()<=0)
                ||!coffee.getCountry().isEmpty()||!coffee.getSort().isEmpty())
        {
            return null;
        }
        return coffeeRepository.save(coffee);
    }

    @Override
    public List<Object> returnSums() {
        return coffeeRepository.returnSums();
    }

    @Override
    public List<Object> returnSumsFilterBySort(String sort) {
        return coffeeRepository.returnSumsFilterBySort(sort);
    }

    @Override
    public List<Object> returnSumsFilterByCountry(String country) {
        return coffeeRepository.returnSumsFilterByCountry(country);
    }

    @Override
    public List<Object> returnSums(String country, String sort) {
        return coffeeRepository.returnSums(country,sort);
    }
}
