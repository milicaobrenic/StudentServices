package com.example.fakultetweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.*;
import java.util.*;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

	public Korisnik findByKorisnickoIme(String korisnickoIme);
	
	@Query("select k from Korisnik k inner join k.polazes p where p.ispit.idIspit = :idIspit")
	public List<Korisnik> getStudente(@Param("idIspit")Integer idIspit);
	
	@Query("select k from Korisnik k inner join k.imas i where i.predmet.idPredmet = :idPredmet and i.korisnik.uloga.naziv like :uloga")
	public List<Korisnik> getStudenteZaPredmet(@Param("idPredmet")Integer idPredmet, @Param("uloga")String uloga);
	
	@Query("select k from Korisnik k where k.uloga.naziv like :uloga")
	public List<Korisnik> getStudente(@Param("uloga")String uloga);
	
}
