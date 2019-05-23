package frontend.controller;

import frontend.api.VoitureApi;
import frontend.model.Voiture;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

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
    public String list2(Model model) {
    	for (Voiture a : voitureApi.getPhotos()) {
    		byte[] decodedBytes = Base64.getDecoder().decode(a.getPhoto());
			try {
				FileUtils.writeByteArrayToFile(new File("src/main/resources/img/" + a.getModele() + ".png"), decodedBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	model.addAttribute("voitures", voitureApi.getAll());
    	return "vehicules";
    }
    
    @GetMapping("/vehicules/{voitureId}")
    public String get(Model model, @PathVariable Integer voitureId) {
    	model.addAttribute("voiture", voitureApi.get(voitureId));
    	return "descriptionVoiture";
    }

    
}
