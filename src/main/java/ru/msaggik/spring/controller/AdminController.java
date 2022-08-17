package ru.msaggik.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.msaggik.spring.dao.PeopleDAO;
import ru.msaggik.spring.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PeopleDAO peopleDAO;
    @Autowired
    public AdminController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping() // возврат страницы с выпадающим списком
    public String adminPage(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", peopleDAO.index());

        return "adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person) {
        System.out.println(person.getId());
        return "redirect:/people";
    }

}
