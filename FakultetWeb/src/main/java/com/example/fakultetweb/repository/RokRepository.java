package com.example.fakultetweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.*;

@Repository
public interface RokRepository extends JpaRepository<Rok, Integer> {

}
