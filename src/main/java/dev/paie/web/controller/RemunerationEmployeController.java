package dev.paie.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunarationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private RemunarationEmployeRepository remunarationEmployeRepository;
	

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView formulaireCreerEmploye() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("employes/creerEmploye");
        
        // Liste Entreprises
        mv.addObject("entreprises",entrepriseRepository.findAll());
        
        // Liste ProfilsRemunération
        mv.addObject("profilsRemuneration", profilRemunerationRepository.findAll());
        
        // Liste ProfilsRemunération
        mv.addObject("grades", gradeRepository.findAll());
        return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmploye(HttpServletRequest request) {
        RemunerationEmploye nouvelEmploye = new RemunerationEmploye();
        
        nouvelEmploye.setMatricule(request.getParameter("matricule"));
        nouvelEmploye.setEntreprise(entrepriseRepository.findOne(Integer.parseInt(request.getParameter("entrepriseId"))));
        nouvelEmploye.setProfilRemuneration(profilRemunerationRepository.findOne(Integer.parseInt(request.getParameter("profilId"))));
        nouvelEmploye.setGrade(gradeRepository.findOne(Integer.parseInt(request.getParameter("gradeId"))));
        
        remunarationEmployeRepository.save(nouvelEmploye);
        
        return new ModelAndView("redirect:" + "/mvc/employes/lister");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("employes/listerEmploye");
        
        // Liste Employes
        mv.addObject("employes", remunarationEmployeRepository.findAll());
        
        
        return mv;
	}
	
	
	
	
}
