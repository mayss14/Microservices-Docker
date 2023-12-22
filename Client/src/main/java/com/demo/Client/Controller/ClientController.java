package com.demo.Client.Controller;

import com.demo.Client.Model.Client;
import com.demo.Client.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService cs;

    @GetMapping
    public List<Client> findAll()
    {
        return cs.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception
    {
        return cs.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client c)
    {
        cs.addClient(c);
    }
}
