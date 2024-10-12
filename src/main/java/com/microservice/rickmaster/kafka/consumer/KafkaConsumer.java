package com.microservice.rickmaster.kafka.consumer;


import com.microservice.rickmaster.model.Coffee;
import com.microservice.rickmaster.service.CoffeeService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

// Class
    public class KafkaConsumer {

    private CoffeeService coffeeService;

    public KafkaConsumer(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @KafkaListener(topics = "coffee",
                groupId = "groupId",
        containerFactory = "CoffeeListener")



        // Method
        public void
        consume(Coffee coffee)
        {

            coffeeService.create(coffee);
            System.out.println("message = " + coffee);
        }
    }
