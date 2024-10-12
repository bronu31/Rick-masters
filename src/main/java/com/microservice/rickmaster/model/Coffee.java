package com.microservice.rickmaster.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@ToString
public class Coffee { //принимаем информацио о поставках в виде такого объекта
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float weight;
    private String country;
    private Integer robust;
    private Integer arabica;
    private String sort;

}
