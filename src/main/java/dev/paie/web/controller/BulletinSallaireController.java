package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunarationEmployeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@Transactional
@RequestMapping("/bulletins")
public class BulletinSallaireController {

	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private RemunarationEmployeRepository remunarationEmployeRepository;
	
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	CalculerRemunerationServiceSimple calculerRemunerationService;

	
	@RequestMapping(method = RequestMethod.GET, path = "/afficher/{idBulletin}")
	public ModelAndView bulletinSalaire(@PathVariable Integer idBulletin) {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("bulletins/afficherBulletin");
        
        BulletinSalaire bulletinSalaire = bulletinSalaireRepository.findOne(idBulletin);
        
		bulletinSalaire.setResultatCalculRemuneration(calculerRemunerationService.calculer(bulletinSalaire));
		
        
		mv.addObject("bulletin", bulletinSalaire);
        
        
        System.out.println(bulletinSalaire.getRemunerationEmploye().getMatricule());
        

        return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView formulaireCreerEmploye() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("bulletins/creerBulletin");
        
        mv.addObject("periodes", periodeRepository.findAll());
        
        mv.addObject("employes", remunarationEmployeRepository.findAll());

        return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmploye(HttpServletRequest request) {

        BulletinSalaire nouveauBulletin = new BulletinSalaire();
        
        nouveauBulletin.setDateCreation(LocalDateTime.now());
        nouveauBulletin.setPeriode(periodeRepository.findOne(Integer.parseInt(request.getParameter("periodeId"))));
        nouveauBulletin.setRemunerationEmploye(remunarationEmployeRepository.findOne(Integer.parseInt(request.getParameter("employeId"))));
        nouveauBulletin.setPrimeExceptionnelle(BigDecimal.valueOf(Double.parseDouble(request.getParameter("primeExceptionnelle"))));

        
        bulletinSalaireRepository.save(nouveauBulletin);
                
        return new ModelAndView("redirect:" + "/mvc/bulletins/lister");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "lister")
	public ModelAndView listerEmploye(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("bulletins/listerBulletins");
        
        List<BulletinSalaire> bulletinSalaires = new ArrayList<BulletinSalaire>();
        for(BulletinSalaire bulletinSalaire: bulletinSalaireRepository.findAll()) {
        		bulletinSalaire.setResultatCalculRemuneration(calculerRemunerationService.calculer(bulletinSalaire));
        		bulletinSalaires.add(bulletinSalaire);
        }
        
        // Liste Bulletins
        mv.addObject("bulletins", bulletinSalaires);
        
        
        return mv;
	}
	
	
	
	
}
