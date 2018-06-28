package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class PetController {
    @Autowired
    PersonRepository petOwners;

    @Autowired
    PetRepository petlist;

    @RequestMapping("/")
    public String index(Model model)
    {

        double total=0;
        double taxrate = 1.06;
        model.addAttribute("petlist",petlist.findAll());
        model.addAttribute("ownerlist",petOwners.findAll());

        // Calculate the total in the controller (Thymeleaf does not support global variables)
        for (Pet eachPet:petlist.findAll()) {
            total+=eachPet.getPetName()*eachPet.getOwners().getPrice();

        }
        model.addAttribute("sumTotal",total* taxrate);

        return "index";
    }

    @RequestMapping("/addpet")
    public String addPet(Model model)
    {
        model.addAttribute("aPet", new Pet());
        model.addAttribute("petowners",petOwners.findAll());
        return "pet";
    }

    @RequestMapping("/savepet")
    public String savePet(@ModelAttribute("aPet") Pet pet, Model model)
    {

        petlist.save(pet);

        return "redirect:/";
    }

    @PostConstruct
    public void fillTables()
    {
//        Preset product values
        Person p = new Person();
        p.setMyName("Apple");
        p.setPrice(2.50);
        petOwners.save(p);

        p = new Person();
        p.setMyName("Pear");
        p.setPrice(3.50);
        petOwners.save(p);

        p= new Person();
        p.setMyName("Banana");
        p.setPrice(4.50);
        petOwners.save(p);
    }
}
