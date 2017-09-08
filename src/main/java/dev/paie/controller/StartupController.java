package dev.paie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;

@Controller
public class StartupController {

	@Autowired
	private InitialiserDonneesService initialiserDonneesService;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		
		initialiserDonneesService.initialiser();
	}
}
