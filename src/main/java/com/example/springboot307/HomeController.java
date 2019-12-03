package com.example.springboot307;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model) {
// First let’s create a person
        Person person = new Person();
        person.setName("Eathyn Edwards");
        person.setSsn("555-12-1234");
        Passport passport = new Passport();

        passport.setType("International");
        passport.setDate("2017");
        person.setPassport(passport);
        personRepository.save(person);

        model.addAttribute("persons", personRepository.findAll());

        return "index";

    }
}

