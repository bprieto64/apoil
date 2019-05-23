package frontend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import frontend.api.VenteApi;
import frontend.api.VoitureApi;
import frontend.model.Utilisateur;
import frontend.model.Vente;
import frontend.model.Voiture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class VenteController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private VenteApi venteApi;
	private VoitureApi voitureApi;

    @GetMapping("/user")
    public String list(Model model) {
        return "home";
    }
    
    @GetMapping("/user/{userId}")
    public String get(Model model, @PathVariable Integer venteId) {
    	model.addAttribute("vente", venteApi.get(venteId));
    	return "descriptionVoiture";
    }
    
    @GetMapping("/vehicules/{idVoiture}/acheter")
    public String showForm(Model model, @PathVariable Integer idVoiture) {
    	Vente vente = new Vente();
    	Utilisateur u = new Utilisateur();
        Voiture v = new Voiture();
        
        v.setId(idVoiture);
 
        vente.setUtilisateur(u);
        vente.setVoiture(v);
        
        model.addAttribute("voitureId", v.getId());
        model.addAttribute("vente", vente);
        
        return "detailAcheteur";
    }
    
    @PostMapping("/vehicules/{idVoiture}/acheter")
    public String processForm(@ModelAttribute Vente vente, @PathVariable Integer idVoiture) throws JsonProcessingException {
    	
    	Voiture voiture = new Voiture();
    	voiture.setId(idVoiture);
    	
    	vente.setVoiture(voiture);
    
    	
        venteApi.create(vente);
        
        return "redirect:/";
    }
	
}