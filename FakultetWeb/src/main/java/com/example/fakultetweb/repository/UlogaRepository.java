package com.example.fakultetweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.*;

@Repository
public interface UlogaRepository extends JpaRepository<Uloga, Integer> {

	public Uloga findByNaziv(String naziv);
	
}
