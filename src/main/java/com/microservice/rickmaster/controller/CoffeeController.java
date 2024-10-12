package com.microservice.rickmaster.controller;

import com.microservice.rickmaster.model.Coffee;
import com.microservice.rickmaster.service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee")
@Tag(name="Coffee controller", description="Контроллер который отвечает за получение данных за кофе и загрузку")
public class CoffeeController {

    private CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @RequestMapping()
    @Operation(
            summary = "получить не отсортированные данные",
            description = "метод возвращает список всех кофе которые есть в системе и суммирует их вес"
    )
    public List<Object> returnSum(){
        return coffeeService.returnSums();
    }
    @RequestMapping("sortcountry")
    @Operation(
            summary = "получить данные отсортированные по сорту и стране",
            description = "Метод возвращающий данные которые были отсортированы по стране и сорту"
    )
    public List<Object> returnSum(
            @RequestParam("country") @Parameter(description = "Страна по которой необходимо получить статистику")  String country,
            @RequestParam("sort") @Parameter(description = "сорт по которому необходимо получить статистику") String sort){
        return coffeeService.returnSums(country,sort);
    }

    @RequestMapping("bysort")
    @Operation(
            summary = "получить данные отсортированные по сорту",
            description = "Метод возвращающий данные которые были отсортированы по сорту"
    )
    public List<Object> returnSumsFilterBySort(
            @RequestBody @Parameter(description = "сорт по которому необходимо получить статистику") String sort){
        return coffeeService.returnSumsFilterBySort(sort);
    }
    @RequestMapping("bycountry")
    @Operation(
            summary = "получить данные отсортированные по стране",
            description = "Метод возвращающий данные которые были отсортированы по стране+"
    )
    public List<Object> returnSumsFilterByCountry(
            @RequestBody
            @Parameter(description = "Страна по которой необходимо получить статистику")
            String country){
        return coffeeService.returnSumsFilterByCountry( country);
    }
}
