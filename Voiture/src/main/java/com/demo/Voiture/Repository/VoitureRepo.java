package com.demo.Voiture.Repository;


import com.demo.Voiture.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepo extends JpaRepository<Voiture,Long> {

}
