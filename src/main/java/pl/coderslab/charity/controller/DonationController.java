package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }
    @ModelAttribute("categories")
    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }
    @ModelAttribute("institutions")
    public List<Institution> allInstitutions(){
        return institutionRepository.findAll();
    }


    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("donation", new Donation());
        return "form";
    }
    @PostMapping("/form")
    public String formPost(Donation donation){
        donationRepository.save(donation);
        return "redirect:/";
    }

}
