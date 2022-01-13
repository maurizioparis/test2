package com.max.openshift.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.max.contatti.service.ContattoService;
import com.max.openshift.model.Contatto;

@Controller
public class ContattiController {
	
	@Autowired
	private ContattoService contattoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home"); //la pagina deve essere dentro template
		
		List<Contatto> listaContatti = contattoService.getAll();
		mv.addObject("listaContatti", listaContatti);
		mv.addObject("contatto", new Contatto());
		
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveContatto(Contatto contatto) {
		contattoService.saveContatto(contatto);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/modifica/{id}", method = RequestMethod.GET)
	public ModelAndView modificaContatto(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editpage");
		mv.addObject("contatto", contattoService.findById(id));
		return mv;
	}

	@RequestMapping(value = "/elimina/{id}", method = RequestMethod.GET)
	public ModelAndView eliminaContattoTemp(@PathVariable long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deletepage");
		Optional<Contatto> contatto = contattoService.findById(id);
		mv.addObject("contatto", contatto.get());
		return mv;
	}
	
	@RequestMapping(value = "/conferma", method = RequestMethod.POST)
	public ModelAndView eliminaContatto(Contatto contatto) {
		contattoService.deleteContatto(contatto.getId());
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/statistica", method = RequestMethod.GET)
	public ModelAndView ottieniStat(@RequestParam String username) {
		Long conteggio = contattoService.conteggioContatti();
		List<Contatto> listaContatti = contattoService.findByUsername(username);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("statpage");
		mv.addObject("conteggio", conteggio);
		mv.addObject("listaContatti", listaContatti);
		return mv;
		
	}
}
