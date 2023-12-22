package com.demo.Voiture.Model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private Long Id;
    private String marque;
    private String matricule;
    private String model;
    private Client client;
}
