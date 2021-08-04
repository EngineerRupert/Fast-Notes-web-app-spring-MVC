package ru.notesite.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.notesite.project.models.Person;

@Controller()
public class MenuController {

    @GetMapping("/user-menu")
    public String showMenu(Model model) {
        model.addAttribute("person", new Person());
        return "/usermenu/main_menu_user";
    }

}
