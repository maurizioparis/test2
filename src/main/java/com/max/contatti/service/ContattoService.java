package com.max.contatti.service;

import java.util.List;
import java.util.Optional;

import com.max.openshift.model.Contatto;

public interface ContattoService {
	void saveContatto(Contatto contatto);
	List<Contatto>getAll();
	Optional<Contatto>findById(long id);
	void deleteContatto(long id);
	
	List<Contatto>findByUsername(String username);
	Long conteggioContatti();
}
