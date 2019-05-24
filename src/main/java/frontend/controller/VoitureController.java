package frontend.controller;

import frontend.api.VoitureApi;
import frontend.model.Voiture;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VoitureController {

	@Autowired
	private VoitureApi voitureApi;

	@GetMapping("/")
	public String list(Model model) {
		return "home";
	}

	@GetMapping("/vehicules")
	public String list2(Model model, @RequestParam(value = "marque", defaultValue = "") String marque,
			@RequestParam(value = "modele", defaultValue = "") String modele,
			@RequestParam(value = "prixMin", defaultValue = "0") String prixMin,
			@RequestParam(value = "prixMax", defaultValue = "1000000000") String prixMax) {
		Map<String, String> filters = new HashMap<String, String>();
		
		
		if(modele!= null && !modele.isEmpty() ) {
			filters.put("modele", modele);
		}
		if(marque!= null && !marque.isEmpty() ) {
			filters.put("marque", marque);
		}
		if(prixMin!= null && !prixMin.isEmpty() ) {
			filters.put("prixMin", prixMin);
		}
		if(prixMax!= null && !prixMax.isEmpty() ) {
			filters.put("prixMax", prixMax);
		}

		model.addAttribute("voitures", voitureApi.getWithFilters(filters));

		for (Voiture a : voitureApi.getPhotos()) {
			byte[] decodedBytes = Base64.getDecoder().decode(a.getPhoto());
			try {
				FileUtils.writeByteArrayToFile(new File("src/main/resources/img/" + a.getModele() + ".png"),
						decodedBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "vehicules";
	}

	@GetMapping("/vehicules/{voitureId}")
	public String get(Model model, @PathVariable Integer voitureId) {
		model.addAttribute("voiture", voitureApi.get(voitureId));
		return "descriptionVoiture";
	}

}
