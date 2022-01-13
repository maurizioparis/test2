package com.maurizio.openshift.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.max.openshift.model.Contatto;

public interface ContattoRepository extends JpaRepository<Contatto, Long>{
	
	@Query(value="select c from Contatto c where c.username = ?1")
	List<Contatto> findByUsername(String username);
	
	@Query(value = "Select count(*) from Contatto")
	Long conteggioContatti();

}
