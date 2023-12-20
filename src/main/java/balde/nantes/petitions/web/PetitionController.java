package balde.nantes.petitions.web;

import balde.nantes.petitions.entities.Petition;
import balde.nantes.petitions.repositories.PetitionRepository;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
public class PetitionController {
    private PetitionRepository petitionRepository;

    @GetMapping(path = "/index")
    public String petitions(Model model){
        List<Petition> listPetitions = petitionRepository.findAll();
        model.addAttribute("listPetitions", listPetitions);
        return "petitions";
    }

    @GetMapping(path = "/home")
    public String home(Model model){
        List<Petition> listPetitions = petitionRepository.findAll();
        model.addAttribute("listPetitions", listPetitions);
        return "home";
    }

    @GetMapping(path = "/")
    public String login(Model model){
        List<Petition> listPetitions = petitionRepository.findAll();
        model.addAttribute("listPetitions", listPetitions);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        petitionRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/formPetitions")
    public String formPetitions(Model model){
        model.addAttribute("petition", new Petition());
        return "formPetitions";
    }

    @GetMapping("/auth")
    @ResponseBody
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

    @PostMapping("/save")
    public String save(Model model, Petition petition){
        petitionRepository.save(petition);
        return "redirect:/index";
    }

    @GetMapping("/editPetition")
    public String editPetition(Model model, Long id){
        Petition petition  = petitionRepository.findById(id).orElse(null);
        if (petition == null) throw new RuntimeException("Petition introuvable");
        model.addAttribute("petition", petition);
        return "editPetition";
    }
}