package com.dm.bookwithnotes.controller;

import com.dm.bookwithnotes.models.Note;
//import com.dm.bookwithnotes.models.User;
import com.dm.bookwithnotes.models.User;
import com.dm.bookwithnotes.services.NoteService;
//import com.dm.bookwithnotes.services.UserService;
import com.dm.bookwithnotes.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final NoteService noteService;
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Thank you for visiting.");
        return "index";
    }

    @GetMapping("/home")
    public String home(
            @RequestParam(name="title", required = false) String title,
            Model model
    ) {
        model.addAttribute("notes", noteService.noteList(title) );
        return "home";
    }

    @PostMapping("/home/create")
    public String createNote(Note note) {
        noteService.saveNote(note);
        return "redirect:/home";
    }

    @PostMapping("/home/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/home";
    }

    @GetMapping("/home/note/{id}")
    public String watchNote(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "note";
    }

    // Пользователь

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/{user}")
    public String user(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("notes", user.getNotes());
        return "user-info";
    }


    // Регистрация

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        if(userService.saveUser(user)) {
            return "redirect:/login";
        }

        return "redirect:/register";
    }


}
