package com.demo.Voiture.Controller;

import com.demo.Voiture.Model.CarResponse;
import com.demo.Voiture.Model.Voiture;
import com.demo.Voiture.Repository.VoitureRepo;
import com.demo.Voiture.Service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class VoitureController {

    @Autowired
    private VoitureService vs;


    @GetMapping
    public List<CarResponse> findAll()
    {
        return vs.findAll();
    }

    @GetMapping("/{id}")
   public CarResponse findById(@PathVariable Long id) throws Exception
    {
        return vs.findById(id);
    }

}


