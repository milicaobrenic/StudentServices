package com.example.fakultetweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.*;
import java.util.*;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Integer> {

	@Query("select p from Predmet p inner join p.imas i where i.korisnik.idKorisnik = :idKorisnik and i.predmet.semestar.idSemestar = :idSemestar")
	public List<Predmet> getPredmeteKorisnika(@Param("idKorisnik")Integer idKorisnik, @Param("idSemestar")Integer idSemestar);
	
	@Query("select p from Predmet p inner join p.imas i where i.korisnik.idKorisnik = :idKorisnik")
	public List<Predmet> getPredmete(@Param("idKorisnik")Integer idKorisnik);
}
