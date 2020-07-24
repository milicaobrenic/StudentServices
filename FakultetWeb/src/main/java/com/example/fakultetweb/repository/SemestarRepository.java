package com.example.fakultetweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.*;
import java.util.*;

@Repository
public interface SemestarRepository extends JpaRepository<Semestar, Integer> {

	@Query("select s from Semestar s inner join s.ima2s i where i.korisnik.idKorisnik = :idKorisnik")
	public List<Semestar> getSemestreStudenta(@Param("idKorisnik")Integer idKorisnik);
	
}
