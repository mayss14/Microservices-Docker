package com.demo.Client.Service;

import com.demo.Client.Model.Client;
import com.demo.Client.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepo rc;

    public List<Client> findAll()
    {
        return rc.findAll();
    }

    public Client findById(Long id) throws Exception
    {
        return rc.findById(id).orElseThrow( () ->  new Exception("Invalid ID"));
    }

    public void addClient(Client c)
    {
        rc.save(c);
    }
}
