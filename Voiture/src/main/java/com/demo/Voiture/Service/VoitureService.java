package com.demo.Voiture.Service;


import com.demo.Voiture.Model.CarResponse;
import com.demo.Voiture.Model.Client;
import com.demo.Voiture.Model.Voiture;
import com.demo.Voiture.Repository.VoitureRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepo vr;

    @Autowired
    private RestTemplate  restTemplate;
    private final String URL="http://localhost:8888/SERVICE-CLIENT";

    public List<CarResponse> findAll()
    {
        List<Voiture> cars = vr.findAll();
        ResponseEntity<Client[]> response = restTemplate.getForEntity(this.URL+"/api/client",Client[].class);
        Client[] clients = response.getBody();
        return cars.stream().map((Voiture v) -> mapToCarResponse(v,clients)).toList();
    }

    private CarResponse mapToCarResponse(Voiture v, Client[] clients) {
        Client foundClient = Arrays.stream(clients)
                .filter(client -> client.getId().equals(v.getId_client()))
                .findFirst()
                .orElse(null);

        return CarResponse.builder()
                .Id(v.getId())
                        .marque(v.getMarque())
                        .client(foundClient)
                        .matricule(v.getMatricule())
                        .model(v.getModel())
                        .build();
    }

    public CarResponse findById(Long id) throws Exception {
        Voiture v = vr.findById(id).orElseThrow(() -> new Exception("Invalid id"));
        Client c = restTemplate.getForObject(this.URL + "/api/client/" + v.getId_client(), Client.class);
        return CarResponse.builder()
                .Id(v.getId())
                .marque(v.getMarque())
                .client(c)
                .matricule(v.getMatricule())
                .model(v.getModel())
                .build();

    }


}
