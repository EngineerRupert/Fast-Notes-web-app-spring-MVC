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
@RequestMapping("/notes")
public class NotesController {

    @GetMapping("/show-notes")
    public String showNotes(Model model) throws SQLException {
        model.addAttribute("person", new PersonDAO().showNotes(new Person()));
        return "/usermenu/show_notes";
    }

    @GetMapping("/create-note")
    public String createNote(Model model) {
        model.addAttribute("person", new Person());
        return "/usermenu/create_note";
    }

    @PostMapping("/create-user-note")
    public String createNote(@ModelAttribute("person") Person person) throws SQLException {
        PersonDAO personDAO = new PersonDAO();
        personDAO.createNote(person);
        return "/usermenu/note_done";
    }

}
