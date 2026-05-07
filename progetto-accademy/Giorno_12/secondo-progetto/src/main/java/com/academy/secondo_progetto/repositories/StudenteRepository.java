package com.academy.secondo_progetto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.secondo_progetto.entities.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer> 
{
	@Query("SELECT s FROM Studente s WHERE s.corsoLaurea = :corso")
    List<Studente> findByCorsoLaurea(@Param("corso") String corso);
	
	List<Studente> findByCognome(String cognome);
}