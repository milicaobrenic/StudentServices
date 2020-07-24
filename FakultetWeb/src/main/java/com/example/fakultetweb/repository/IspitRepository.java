package com.example.fakultetweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.*;

@Repository
public interface IspitRepository extends JpaRepository<Ispit, Integer> {

	@Query("select i from Ispit i inner join i.polazes p where p.korisnik.idKorisnik = :idKorisnik")
	public List<Ispit> getIspiteStudenta(@Param("idKorisnik")Integer idKorisnik);
	
}
