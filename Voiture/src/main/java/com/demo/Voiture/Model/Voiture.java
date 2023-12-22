package com.demo.Voiture.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String marque;
    private String matricule;
    private String model;
    private Long id_client;

    //@Transient
    //@ManyToOne
    //private Client client;



}
