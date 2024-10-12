package com.microservice.rickmaster.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Message { //информация о том какое зерно будут обжаривать
    //через GRPC
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float weight;
    private String sort;
    private String country;
    @Column(name = "weight_after_roasting")
    private Double weightAfterRoasting;
    private Integer brigadeID;
}
