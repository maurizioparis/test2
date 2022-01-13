package com.max.openshift.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurizio.openshift.repository.ContattoRepository;
import com.max.contatti.service.ContattoService;
import com.max.openshift.model.Contatto;

@Service("contattoService")
public class ContattoServiceImpl implements ContattoService{
	@Autowired
	private ContattoRepository contattoRepository;

	@Override
	public void saveContatto(Contatto contatto) {
		contattoRepository.save(contatto);
	}

	@Override
	public List<Contatto> getAll() {
		return contattoRepository.findAll();
	}

	@Override
	public Optional<Contatto> findById(long id) {
		return contattoRepository.findById(id);
	}

	@Override
	public void deleteContatto(long id) {
		contattoRepository.deleteById(id);
	}

	@Override
	public List<Contatto> findByUsername(String username) {
		return contattoRepository.findByUsername(username);
	}

	@Override
	public Long conteggioContatti() {
		return contattoRepository.conteggioContatti();
	}
}
