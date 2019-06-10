package app.controllers;

import app.mappers.dtos.PersonDto;
import app.repositories.PersonRepository;
import app.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    private PersonService personService;

    public HomeController(PersonService personService) {

        this.personService = personService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "loged in as: "
                + context.getAuthentication().getName());
        model.addAttribute("persons", personService.getPersonsDto());
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/persons")
    public String homePage(Model model) {
        model.addAttribute("persons", personService.getPersonsDto());
        return "persons";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam(value = "persons") @PathVariable("email") String email) {
        personService.deletePerson(email);
        return "redirect:/persons";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute PersonDto personDto) {
        personService.addPerson(personDto);
        return "redirect:/persons";
    }

   @PostMapping("update")
    public String updatePersonByEmail(@ModelAttribute PersonDto personDto, Model model) {
        model.addAttribute("person", personDto);
        model.addAttribute("email", personDto.getEmail());
       return "update";
    }


    @PostMapping("/upd")
    public String updatePersonByEmail(@ModelAttribute PersonDto personDto, @RequestParam(value ="email", required = false) String param) {
        personService.updatePersonByEmail(param, personDto);

        return "redirect:/persons";
    }}