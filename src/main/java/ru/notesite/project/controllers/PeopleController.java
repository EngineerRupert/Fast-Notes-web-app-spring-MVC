package ru.notesite.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.notesite.project.dao.PersonDAO;
import ru.notesite.project.models.Person;

import java.sql.SQLException;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping("/log-in")
    public String logIn(Model model) {
        model.addAttribute("person", new Person());
        return "/people/log_in";
    }

    @GetMapping("/new-user")
    public String newUser(Model model) {
        Person person = new Person();
        person.setId(0);
        person.setName("");
        person.setPassword("");
        person.setNote("");
        person.getArrayListNotes().clear();
        model.addAttribute("person", person);
        return "/people/new_user";
    }

    @GetMapping("/done")
    public String userCreated() {
        return "/people/done";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) throws SQLException {
        PersonDAO personDAO = new PersonDAO();
        int count = personDAO.createUser(person);
        String result;
        if (count == 0) {
            result = "/people/new_user_try_again";
        } else {
            result = "/people/done";
        }
        return result;
    }

    @PostMapping("/login")
    public String logIn(@ModelAttribute("person") Person person) throws SQLException {
        PersonDAO personDAO = new PersonDAO();
        int count = personDAO.logIn(person);
        String result;
        if (count == 0) {
            result = "/people/log_in_try_again";
        } else {
            result = "/usermenu/main_menu_user";
        }
        return result;
    }

}
