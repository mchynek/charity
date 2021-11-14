package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, CategoryRepository categoryRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institution", institutionRepository.findAll());
        model.addAttribute("quantity", donationRepository.selectQuantity());
        model.addAttribute("donationAll", donationRepository.countDonation());
        return "index";
    }

}
